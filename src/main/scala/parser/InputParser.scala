package parser

trait InputParser {
  def loadFile(fileSrc: String): Unit

  def convertInput(): Unit
}
