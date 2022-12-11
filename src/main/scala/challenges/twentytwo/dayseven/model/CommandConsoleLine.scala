package challenges.twentytwo.dayseven.model

import java.nio.file.Path

sealed trait CommandConsoleLine extends ParsedConsoleLine {
  require(rawConsoleLine.startsWith(CommandConsoleLine.START), s"$rawConsoleLine is not a valid command")
}

case class CD(rawConsoleLine: String) extends CommandConsoleLine {
  require(
    rawConsoleLine.startsWith(CD.START),
    s"$rawConsoleLine is not a valid CD command since it doesn't start with ${CD.START}"
  )
  lazy val destination: String = rawConsoleLine.replace(s"${CD.START} ", "").trim
  require(destination.nonEmpty, s"$rawConsoleLine is not a valid CD command since it doesn't have a destination value")
}

object CD {
  lazy val START: String = s"${CommandConsoleLine.START} cd"
  lazy val BACK: String = ".."
  lazy val ROOT: Path = Path.of(ROOT_STRING)
  lazy val ROOT_STRING: String = "/"

  def buildFinalPath(currentPath: Path, destination: String): Path = destination.trim match {
    case ROOT_STRING => ROOT
    case BACK => currentPath.getParent
    case dest if dest.nonEmpty => Path.of(currentPath.toString, destination)
    case _ => throw new UnsupportedOperationException(s"Unable to change directory (CD) to $destination from currentPath $currentPath")
  }

}

case class LS(rawConsoleLine: String) extends CommandConsoleLine {
  require(
    rawConsoleLine.startsWith(s"${LS.START}"),
    s"$rawConsoleLine is not a valid LS command since it doesn't start with ${LS.START}"
  )
}
object LS {
  val START: String = s"${CommandConsoleLine.START} ls"
}

object CommandConsoleLine {
  val START: String    = "$"
  val TEXT_LENGHT: Int = 4
  def parse(rawCommand: String): Option[CommandConsoleLine] = {
    rawCommand.take(TEXT_LENGHT) match {
      case CD.START => Some(CD(rawCommand))
      case LS.START => Some(LS(rawCommand))
      case _        => None
    }
  }
}
