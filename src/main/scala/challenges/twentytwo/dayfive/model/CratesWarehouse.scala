package challenges.twentytwo.dayfive.model

import scala.collection.mutable
import scala.util.matching.Regex

case class CratesWarehouse(stacks: mutable.Map[Int, CratesStack], rearrangeMoves: Seq[RearrangeMove])

object CratesWarehouse {
  val STACK_STRING_SIZE       = 4
  val FIND_IDS_IN_MOVE: Regex = """ (\d+)""".r
}
