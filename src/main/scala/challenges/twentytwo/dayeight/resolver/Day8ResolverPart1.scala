package challenges.twentytwo.dayeight.resolver

import common.controller.Resolver

import scala.util.Try

class Day8ResolverPart1 extends Resolver[Seq[Seq[Short]], Long] {

  override def businessLogic(parsed: Seq[Seq[Short]]): Long = {
    val rows    = parsed.size
    val columns = parsed.head.size
    (0 until rows)
      .flatMap { row =>
        (0 until columns).map { column =>
          if (row == 0 || row == (rows - 1) || column == 0 || column == (columns - 1)) true
          else {
            val center = parsed(row)(column)
            lazy val up     = Try(0 until row forall (upRow => center > parsed(upRow)(column))).getOrElse(false)
            lazy val left   = Try(0 until column forall (leftColum => center > parsed(row)(leftColum))).getOrElse(false)
            lazy val down   = Try((row + 1) until rows forall (downRow => center > parsed(downRow)(column))).getOrElse(false)
            lazy val right  = Try((column + 1) until columns forall (rightColumn => center > parsed(row)(rightColumn))).getOrElse(false)
            up || left || down || right
          }
        }
      }
      .count(_ == true)
  }

  override def parse(toParse: Seq[String]): Option[Seq[Seq[Short]]] =
    Try {
      toParse.map(_.toCharArray.toSeq.map(_.toString.toShort))
    }.toOption
}
