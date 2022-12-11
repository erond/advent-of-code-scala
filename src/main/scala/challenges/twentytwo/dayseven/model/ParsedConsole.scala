package challenges.twentytwo.dayseven.model

case class ParsedConsole(lines: Seq[ParsedConsoleLine])

object ParsedConsole {
  def parseLine(rawLine: String): Option[ParsedConsoleLine] = {
    CommandConsoleLine
      .parse(rawLine)
      .orElse(FileConsoleLine.parse(rawLine))
      .orElse(FolderConsoleLine.parse(rawLine))
      .orElse(throw new UnsupportedOperationException(s"unable to parse input line $rawLine"))
  }
}
