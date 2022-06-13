package utils

import java.io.File
import java.nio.file.{Path, Paths}

object FileUtils {
  def validateArgs(argList: List[String]): Option[Path] = {
    argList match {
      case firstArg :: _ => Some(firstArg).filter(FileUtils.validatePath).map(path => Paths.get(path));
      case (_) => None
    }
  }

  def validatePath(path: String): Boolean = {
    new File(path).exists()
  }
  
}
