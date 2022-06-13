package utils

import importer.Importable

object MainUtils {
  def loadImporter(arg: String): Option[Importable] = {
    try {
      Some(Class.forName(arg).getConstructor().newInstance().asInstanceOf[Importable])
    } catch {
      case e: Exception => None
      case e: Error => None
    }
  }
}
