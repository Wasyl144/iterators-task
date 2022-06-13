package importer

import scala.io.Source

trait Importable {
  def read(): Source = ???
}
