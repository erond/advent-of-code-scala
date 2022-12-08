package challenge.twentytwo.test

import challenges.twentytwo.dayfive.model.{Crate, CratesStack, CratesWarehouse, RearrangeMove}
import challenges.twentytwo.dayfive.resolver.Day5ResolverPart2
import common.test.ResolverSuite

import scala.collection.mutable

class Day5ResolverPart2Suite extends ResolverSuite {

  override val resolver = new Day5ResolverPart2()

  override def year: Int = 2022

  override def day: Int = 5

  def expectedParsed: CratesWarehouse = CratesWarehouse(
    mutable.Map(
      1 -> CratesStack(mutable.Stack(Crate("N"), Crate("Z"))),
      2 -> CratesStack(mutable.Stack(Crate("D"), Crate("C"), Crate("M"))),
      3 -> CratesStack(mutable.Stack(Crate("P")))
    ),
    Seq(
      RearrangeMove(2, 1, 1),
      RearrangeMove(1, 3, 3),
      RearrangeMove(2, 1, 2),
      RearrangeMove(1, 2, 1)
    )
  )

  "Day 5 part 2 business logic" should "calculate the final position of top of the stacks crates moving in bulk" in {
    resolver.businessLogic(expectedParsed) should be("MCD")
  }

  // parser is tested in part 1, it hasn't changed

}
