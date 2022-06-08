package support

import java.io.File

object IOService {
  def validateArgs(argList: List[String]): Option[String] = {
    argList match {
      case firstArg :: _ => Some(firstArg).filter(IOService.validatePath)
      case (_) => None
    }
  }

  def validatePath(path: String): Boolean = {
    new File(path).exists()
  }
}
