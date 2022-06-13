package classes

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ClosedShape, IOResult, Materializer}
import com.typesafe.scalalogging.Logger
import akka.stream.scaladsl._
import importer.Importable

import java.nio.file.{Path, Paths}
import scala.concurrent.Future

class Application(val config: AppConfig, val importer: Importable) {
  def run(): Unit = {
    val logger: Logger = Logger[Application]
    // Init akka.actors
    implicit val system: ActorSystem = ActorSystem("Task")

    val sink = Sink.foreach(println)

//    val foreach = filePath.flatMap(FileIO.fromPath(_).to(sink).run());

    val g = RunnableGraph.fromGraph(GraphDSL.create() { implicit builder: GraphDSL.Builder[NotUsed] =>
      import GraphDSL.Implicits._
      val in = Source(1 to 10)
      val out = Sink.ignore

      val bcast = builder.add(Broadcast[Int](2))
      val merge = builder.add(Merge[Int](2))

      val f1, f2, f3, f4 = Flow[Int].map(_ + 10)

      in ~> f1 ~> bcast ~> f2 ~> merge ~> f3 ~> out
      bcast ~> f4 ~> merge
      ClosedShape
    })

    g.run()
  }
}
