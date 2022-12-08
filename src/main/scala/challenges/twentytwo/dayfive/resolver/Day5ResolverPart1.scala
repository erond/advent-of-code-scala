package challenges.twentytwo.dayfive.resolver

import challenges.twentytwo.dayfive.model.{Crate, CratesStack, CratesWarehouse, RearrangeMove}
import common.controller.Resolver

import scala.collection.mutable
import scala.util.Try

class Day5ResolverPart1 extends Resolver[CratesWarehouse, String] {

  override def businessLogic(parsed: CratesWarehouse): String = {
    parsed.rearrangeMoves
      .foreach { move =>
        val stackTO   = parsed.stacks(move.toID).crates
        val stackFROM = parsed.stacks(move.fromID).crates
        (1 to move.cratesToMove).foreach(_ => stackTO.push(stackFROM.pop()))
      }
    parsed.stacks.map(_._2.crates.pop().id).reduce(_ + _)
  }

  override def parse(toParse: Seq[String]): Option[CratesWarehouse] =
    Try {

      val splitPoint = toParse.indexWhere(_.isEmpty)

      val stacksToParse: Seq[String] = toParse.take(splitPoint - 1)
      val movesToParse: Seq[String]  = toParse.slice(splitPoint + 1, toParse.size)

      val rearrangeMoves: Seq[RearrangeMove] = movesToParse
        .map { m =>
          val ids          = CratesWarehouse.FIND_IDS_IN_MOVE.findAllMatchIn(m)
          val cratesToMove = ids.next().matched.trim.toInt
          val fromStack    = ids.next().matched.trim.toInt
          val toStack      = ids.next().matched.trim.toInt
          RearrangeMove(fromStack, toStack, cratesToMove)
        }

      val tokenized: Seq[(Int, String)] =
        stacksToParse
          .flatMap { s =>
            val cratesOrNot: Seq[String] = s
              .sliding(CratesWarehouse.STACK_STRING_SIZE, CratesWarehouse.STACK_STRING_SIZE)
              .toSeq
              .map(_.trim.replaceAll("\\[*]*", ""))
            (1 to cratesOrNot.size).map(id => id -> cratesOrNot(id - 1)).toMap
          }

      val stacks = tokenized
        .foldRight(mutable.Map.empty[Int, mutable.Stack[Crate]]) {
          case ((id, value), state) =>
            if (value.nonEmpty) {
              state.addOne(id, state.get(id).fold(mutable.Stack.from(Seq(Crate(value))))(_.push(Crate(value))))
            } else state
        }
        .map { case (k, v) => k -> CratesStack(v) }

      CratesWarehouse(stacks, rearrangeMoves)
    }.toOption

}
