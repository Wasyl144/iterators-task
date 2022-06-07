import org.slf4j.LoggerFactory
import java.io.File
import pureconfig._
import pureconfig.generic.auto._


object Main extends App {
  val logger = LoggerFactory.getLogger(getClass().getSimpleName())
  val config: AppConfig = ConfigSource.default.at("app").loadOrThrow[AppConfig]

  val file = args.length match {
    case 0 => "Lipex"
    case _ => if (new File(args(0)).exists()) {
      args(0)
    } else {
      ""
    }
  }

  println(file)


  val app = new Application(config = config, logger = logger)
}