package utils

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers._
import org.scalatest.matchers.must.Matchers

class MainUtilsTest extends AnyFlatSpec with Matchers {
  "Importer winch doesnt exists" should "return true" in {
    assert(MainUtils.loadImporter("blah").isEmpty)
  }
  "Importer winch exists" should "return true" in {
    println(MainUtils.loadImporter("importer.file.FileImporter"))
    assert(MainUtils.loadImporter("importer.file.FileImporter").isDefined)
  }
}
