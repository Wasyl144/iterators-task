package utils

import java.io.File

object FileUtils {
  def validateArgs(argList: List[String]): Option[String] = {
    argList match {
      case firstArg :: _ => Some(firstArg).filter(FileUtils.validatePath)
      case (_) => None
    }
  }

  def validatePath(path: String): Boolean = {
    new File(path).exists()
  }
}
