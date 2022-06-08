import classes.{AppConfig, Application}
import org.slf4j.{Logger, LoggerFactory, Marker}
import pureconfig._
import pureconfig.generic.auto._
import support.IOService


object Main extends App {
  val logger: Logger = LoggerFactory.getLogger(getClass().getSimpleName())
  val config: AppConfig = ConfigSource.default.at("app").loadOrThrow[AppConfig]
  val filePath: Option[String] = IOService.validateArgs(args.toList)

  println(filePath)


  val app = new Application(config = config, logger = logger)
}