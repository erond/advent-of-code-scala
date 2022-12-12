package challenge.twentytwo.test

import challenges.twentytwo.dayeight.resolver.Day8ResolverPart2
import common.test.ResolverSuite

class Day8ResolverPart2Suite extends ResolverSuite {

  override val resolver = new Day8ResolverPart2()

  override def year: Int = 2022

  override def day: Int = 8

  val expectedParsed: Seq[Seq[Short]] =
    Seq(Seq(3, 0, 3, 7, 3), Seq(2, 5, 5, 1, 2), Seq(6, 5, 3, 3, 2), Seq(3, 3, 5, 4, 9), Seq(3, 5, 3, 9, 0))

  "Day 8 part 2 business logic" should "find maximum scenic score" in {
    resolver.businessLogic(expectedParsed) should be(8L)
  }

}
