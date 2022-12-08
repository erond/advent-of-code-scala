package challenge.twentytwo.test

import challenges.twentytwo.dayfive.model.{Crate, CratesStack, CratesWarehouse, RearrangeMove}
import challenges.twentytwo.dayfive.resolver.Day5ResolverPart1
import common.test.ResolverSuite

import scala.collection.mutable

class Day5ResolverPart1Suite extends ResolverSuite {

  override val resolver = new Day5ResolverPart1()

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

  "Day 5 part 1 business logic" should "calculate the final position of top of the stacks crates" in {
    resolver.businessLogic(expectedParsed) should be("CMZ")
  }

  /**
    *      [D]
    *  [N] [C]
    *  [Z] [M] [P]
    *  1   2   3
    *
    *  move 1 from 2 to 1
    *  move 3 from 1 to 3
    *  move 2 from 2 to 1
    *  move 1 from 1 to 2
    */
  "parser" should "build a warehouse made of stack and moves" in {
    val parsed = resolver.parse(input)
    parsed should be(Some(expectedParsed))
  }

}
