package utils

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class FileUtilsTest extends AnyFlatSpec with Matchers {
  "File winch doesn't exists" should "return false" in {
    assert(!FileUtils.validatePath("blah"))
  }
  "File winch does exists" should "return true" in {
    assert(FileUtils.validatePath("src/test/resources/testfile.txt"))
  }
  "Empty list of args" should "return None" in {
    assert(FileUtils.validateArgs(List()).isEmpty)
  }
  "List containing 1 arg with invalid path" should "return None" in {
    assert(FileUtils.validateArgs(List("bifgbhkfjds")).isEmpty)
  }
  "List containing 1 arg with valid path" should "return Some" in {
    assert(FileUtils.validateArgs(List("src/test/resources/testfile.txt")).isDefined)
  }
  "List containing more then 1 arg with valid path" should "return Some" in {
    assert(FileUtils.validateArgs(List("src/test/resources/testfile.txt", "nbfkhbk", "bfsdjfjdsh")).isDefined)
  }
  "List containing more then 1 arg with invalid path" should "return None" in {
    assert(FileUtils.validateArgs(List("bvdhkbfd", "nbfkhbk", "bfsdjfjdsh")).isEmpty)
  }

}