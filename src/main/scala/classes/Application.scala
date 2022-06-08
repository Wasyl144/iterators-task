package classes

import com.typesafe.scalalogging.Logger

class Application(val config: AppConfig, val filePath: Option[String]) {
  def run(): Unit = {
    val logger: Logger = Logger[Application]
    logger.debug("test debugowy z klasy application")

  }
}
