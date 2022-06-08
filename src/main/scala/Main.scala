import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import classes.{AppConfig, Application}
import com.typesafe.scalalogging.Logger
import pureconfig._
import pureconfig.generic.auto._
import utils.FileUtils


object Main extends App {
  val logger: Logger = Logger(getClass.getName)
  val config: AppConfig = ConfigSource.default.at("app").loadOrThrow[AppConfig]
  val filePath: Option[String] = FileUtils.validateArgs(args.toList)

  val app = new Application(config = config, filePath)
  app.run()
}