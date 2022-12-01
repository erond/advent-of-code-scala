package common.input.test

import common.input.InputReader
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util._

class InputReaderSuite extends AnyFlatSpec with Matchers {
  "InputReader" should "read the example file in test resources" in {
    val input: Try[Seq[String]] = InputReader.readInput(2022, 1)
    input match {
      case Success(lines)     => lines.head should be("test")
      case Failure(exception) => fail(exception)
    }
  }

}
