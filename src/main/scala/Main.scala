import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import classes.{AppConfig, Application}
import com.typesafe.scalalogging.Logger
import importer.Importable
import pureconfig._
import pureconfig.generic.auto._
import utils.MainUtils.loadImporter

object Main extends App {
  val logger: Logger = Logger(getClass.getName)
  val config: AppConfig = ConfigSource.default.at("app").loadOrThrow[AppConfig]
  val importer: Option[Importable] = loadImporter(arg = config.importer)
  println(importer)

  //  val app = new Application(config = config, importer = importer)
  //  app.run()

}

