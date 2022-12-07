package common.input

import scala.io.Source
import scala.util.{Try, Using}

object InputReader {

  final def readInput(year: Int, day: Int): Seq[String] = {
    Using(Source.fromResource(s"$year/$day/input.txt"))(_.getLines().toSeq)
  }.getOrElse(throw new UnsupportedOperationException("unable to read input"))

}
