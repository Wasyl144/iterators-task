package classes

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, IOResult}
import com.typesafe.scalalogging.Logger
import akka.stream.scaladsl._

import java.nio.file.Paths
import scala.concurrent.Future

class Application(val config: AppConfig, val filePath: Option[String]) {
  def run(): Unit = {
    val logger: Logger = Logger[Application]
    logger.debug("test debugowy z klasy application")
    // Init akka.actors
    implicit val system: ActorSystem = ActorSystem("Task")

    // Init Akka streams
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    val fileStream = filePath match {
      case Some(x) => Some(Paths.get(x))
      case None => None
    }
//    val file = Paths.get("example.csv")

    val foreach: Option[Future[IOResult]]= fileStream match {
      case Some(value) => Some(FileIO.fromPath(value).to(Sink.ignore).run())
      case None => None
    }
  }
}
