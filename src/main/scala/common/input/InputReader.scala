package common.input

import scala.io.Source
import scala.util.{Try, Using}

object InputReader {

  def readInput(year: Int, day: Int): Try[Seq[String]] = {
    Using(Source.fromResource(s"$year/$day/input.txt")) { reader =>
      reader.getLines().toSeq
    }
  }

}
