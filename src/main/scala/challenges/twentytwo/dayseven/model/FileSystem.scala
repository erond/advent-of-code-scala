package challenges.twentytwo.dayseven.model

import scala.collection.mutable

case class FileSystem(content: mutable.TreeMap[String, ParsedConsoleLine])

object FileSystem {
  def empty: FileSystem = FileSystem(mutable.TreeMap.empty[String, ParsedConsoleLine])

}
