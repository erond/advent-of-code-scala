package challenges.twentytwo.dayfive.resolver

import challenges.twentytwo.dayfive.model.CratesWarehouse

class Day5ResolverPart2 extends Day5ResolverPart1 {

  override def businessLogic(parsed: CratesWarehouse): String = {
    parsed.rearrangeMoves
      .foreach { move =>
        val stackTO   = parsed.stacks(move.toID).crates
        val stackFROM = parsed.stacks(move.fromID).crates
        val buffer = (1 to move.cratesToMove).map { _ =>
          stackFROM.pop()
        }
        buffer.reverse.foreach(c => stackTO.push(c))
      }
    parsed.stacks.map(_._2.crates.pop().id).reduce(_ + _)
  }

}
