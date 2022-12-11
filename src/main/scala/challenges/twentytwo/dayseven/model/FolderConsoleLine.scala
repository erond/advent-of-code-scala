package challenges.twentytwo.dayseven.model

import scala.util.Try

case class FolderConsoleLine(rawConsoleLine: String) extends ParsedConsoleLine with FSContent {
  val parts: Array[String] = rawConsoleLine.split("\\s", 2)
  require(parts(0) == FolderConsoleLine.START, s"unable to parse $rawConsoleLine as folder")
  def name: String = parts(1)

}

object FolderConsoleLine {
  val START: String                                 = "dir"
  def parse(rawConsoleLine: String): Option[FolderConsoleLine] = Try { FolderConsoleLine(rawConsoleLine) }.toOption

}
