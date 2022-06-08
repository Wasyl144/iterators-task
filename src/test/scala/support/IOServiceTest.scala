package support

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class IOServiceTest extends AnyFlatSpec with Matchers {
  "File winch doesn't exists" should "return false" in {
    assert(!IOService.validatePath("blah"))
  }
  "File winch does exists" should "return true" in {
    assert(IOService.validatePath("src/test/resources/testfile.txt"))
  }
  "Empty list of args" should "return None" in {
    assert(IOService.validateArgs(List()).isEmpty)
  }
  "List containing 1 arg with invalid path" should "return None" in {
    assert(IOService.validateArgs(List("bifgbhkfjds")).isEmpty)
  }
  "List containing 1 arg with valid path" should "return Some" in {
    assert(IOService.validateArgs(List("src/test/resources/testfile.txt")).isDefined)
  }
  "List containing more then 1 arg with valid path" should "return Some" in {
    assert(IOService.validateArgs(List("src/test/resources/testfile.txt", "nbfkhbk", "bfsdjfjdsh")).isDefined)
  }
  "List containing more then 1 arg with invalid path" should "return None" in {
    assert(IOService.validateArgs(List("bvdhkbfd", "nbfkhbk", "bfsdjfjdsh")).isEmpty)
  }

}