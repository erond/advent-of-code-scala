package challenges.twentytwo.dayseven.model

import scala.util.Try

case class FileConsoleLine(rawConsoleLine: String) extends ParsedConsoleLine with FSContent {
  val parts: Array[String] = rawConsoleLine.split("\\s", 2)
  require(
    parts(0).toLong > 0,
    s"unable to parse $rawConsoleLine as file with negative size"
  )
  require(
    parts(1).nonEmpty,
    s"file name cannot be empty, so I can't parse $rawConsoleLine"
  )

  def name: String = parts(1)
  def size: Long   = parts(0).toLong
}

object FileConsoleLine {
  def parse(rawConsoleLine: String): Option[FileConsoleLine] = Try { FileConsoleLine(rawConsoleLine) }.toOption
}
