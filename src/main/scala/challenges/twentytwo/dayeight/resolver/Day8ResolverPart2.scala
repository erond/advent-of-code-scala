package challenges.twentytwo.dayeight.resolver

class Day8ResolverPart2 extends Day8ResolverPart1 {

  case class ViewFinder(trees: Long = 0, stopFound: Boolean = false)

  override def businessLogic(parsed: Seq[Seq[Short]]): Long = {
    val rows    = parsed.size
    val columns = parsed.head.size
    (0 until rows).flatMap { row =>
      (0 until columns).map { column =>
        if (row == 0 || row == (rows - 1) || column == 0 || column == (columns - 1)) 0L
        else {
          val center = parsed(row)(column)
          val up: ViewFinder = (row - 1 to 0 by -1).foldLeft(ViewFinder()) { (viewFinder, upRow) =>
            if (!viewFinder.stopFound) {
              if (center > parsed(upRow)(column))
                viewFinder.copy(trees = viewFinder.trees + 1, stopFound = upRow == 0)
              else if (center == parsed(upRow)(column)) viewFinder.copy(trees = viewFinder.trees + 1, stopFound = true)
              else viewFinder.copy(trees = viewFinder.trees + 1, stopFound = true)
            } else {
              viewFinder
            }
          }
          val left = (column - 1 to 0 by -1).foldLeft(ViewFinder()) { (viewFinder, leftColum) =>
            if (!viewFinder.stopFound) {
              if (center > parsed(row)(leftColum))
                viewFinder.copy(trees = viewFinder.trees + 1, stopFound = leftColum == 0)
              else if (center == parsed(row)(leftColum)) viewFinder.copy(trees = viewFinder.trees + 1, stopFound = true)
              else viewFinder.copy(trees = viewFinder.trees + 1, stopFound = true)
            } else {
              viewFinder
            }
          }
          val down = ((row + 1) until rows).foldLeft(ViewFinder()) { (viewFinder, downRow) =>
            if (!viewFinder.stopFound) {
              if (center > parsed(downRow)(column))
                viewFinder.copy(trees = viewFinder.trees + 1, stopFound = downRow == rows)
              else if (center == parsed(downRow)(column))
                viewFinder.copy(trees = viewFinder.trees + 1, stopFound = true)
              else viewFinder.copy(trees = viewFinder.trees + 1, stopFound = true)
            } else {
              viewFinder
            }
          }
          val right = {
            ((column + 1) until columns).foldLeft(ViewFinder()) { (viewFinder, rightColumn) =>
              if (!viewFinder.stopFound) {
                if (center > parsed(row)(rightColumn))
                  viewFinder.copy(trees = viewFinder.trees + 1, stopFound = rightColumn == columns)
                else if (center == parsed(row)(rightColumn))
                  viewFinder.copy(trees = viewFinder.trees + 1, stopFound = true)
                else viewFinder.copy(trees = viewFinder.trees + 1, stopFound = true)
              } else {
                viewFinder
              }
            }
          }
          val scenicScore = up.trees * left.trees * down.trees * right.trees

          scenicScore
        }
      }
    }.max
  }

}
