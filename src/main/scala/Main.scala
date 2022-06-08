import classes.{AppConfig, Application}
import com.typesafe.scalalogging.Logger
import pureconfig._
import pureconfig.generic.auto._
import utils.FileUtils


object Main extends App {
  val logger: Logger = Logger("Main")
  val config: AppConfig = ConfigSource.default.at("app").loadOrThrow[AppConfig]
  val filePath: Option[String] = FileUtils.validateArgs(args.toList)

  println(filePath)
  logger.debug("test")


  val app = new Application(config = config)
}