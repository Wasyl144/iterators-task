import org.slf4j.Logger

class Application(val config: AppConfig, logger: Logger) {
  def run(): Unit = {
    this.logger.info("test")
  }
}
