package challenges.twentytwo.dayseven.resolver

import challenges.twentytwo.dayseven.model._
import common.controller.Resolver

import java.nio.file.Path
import scala.collection.mutable
import scala.util.Try

class Day7ResolverPart1 extends Resolver[ParsedConsole, Long] {

  // find all of the directories with a total size of at most 100000
  val THRESHOLD = 100000L

  case class FSTraverseState(
      parentFolder: Path,
      globalStructure: mutable.TreeMap[Path, FSContentBundle],
      lsInProgress: Boolean = false
  )

  override def businessLogic(parsed: ParsedConsole): Long = {
    val finalFS = parsed.lines
      .foldLeft(
        FSTraverseState(parentFolder = CD.ROOT, globalStructure = mutable.TreeMap(CD.ROOT -> FSContentBundle.empty))
      ) {
        case (state, newLine) =>
          newLine match {
            case cd: CD =>
              val nextPath       = CD.buildFinalPath(state.parentFolder, cd.destination)
              val folderElements = state.globalStructure.getOrElse(nextPath, FSContentBundle.empty)
              state.copy(
                parentFolder = nextPath,
                globalStructure = state.globalStructure.addOne((nextPath, folderElements)),
                lsInProgress = false
              )
            case _: LS =>
              state.copy(lsInProgress = true)
            case folder: FolderConsoleLine =>
              require(state.lsInProgress, s"not being part of a LS, I can't assign folder $folder to a path")
              val folderElements = state.globalStructure.getOrElse(state.parentFolder, FSContentBundle.empty) :+ folder
              state.copy(
                globalStructure = state.globalStructure.addOne((state.parentFolder, folderElements)),
                lsInProgress = state.lsInProgress
              )
            case file: FileConsoleLine =>
              require(state.lsInProgress, s"not being part of a LS, I can't assign file $file to a path")
              val folderElements = state.globalStructure.getOrElse(state.parentFolder, FSContentBundle.empty) :+ file
              state.copy(
                globalStructure = state.globalStructure.addOne((state.parentFolder, folderElements)),
                lsInProgress = state.lsInProgress
              )
            case _ => throw new UnsupportedOperationException(s"Unable to handle $newLine")
          }
      }
    val mapToSize: Seq[Long] = mapNodesToSize(finalFS.globalStructure)

    computeFinalResult(mapToSize)
  }

  private def mapNodesToSize(input: mutable.TreeMap[Path, FSContentBundle]): Seq[Long] = {
    input.toSeq.map {
      case (path, node) =>
        computeFolderSize(path, node, input)
    }
  }

  def computeFinalResult(input: Seq[Long]): Long = {
    input.filter(_ <= THRESHOLD).sum
  }

  private def computeFolderSize(
      path: Path,
      node: FSContentBundle,
      overallFS: mutable.TreeMap[Path, FSContentBundle]
  ): Long = {
    node.items.map {
      case file: FileConsoleLine => file.size
      case folder: FolderConsoleLine =>
        val nextPath = Path.of(path.toString, folder.name)
        computeFolderSize(nextPath, overallFS(nextPath), overallFS)
    }.sum
  }

  override def parse(toParse: Seq[String]): Option[ParsedConsole] =
    Try {
      ParsedConsole(toParse.flatMap(ParsedConsole.parseLine))
    }.toOption

}
