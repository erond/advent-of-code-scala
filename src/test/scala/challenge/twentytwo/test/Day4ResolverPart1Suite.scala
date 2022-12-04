package challenge.twentytwo.test

import challenges.twentytwo.dayfour.model.Assignment
import challenges.twentytwo.dayfour.resolver.Day4ResolverPart1
import common.test.ResolverSuite

class Day4ResolverPart1Suite extends ResolverSuite {

  override val resolver = new Day4ResolverPart1()
  override val input: Seq[String] = Seq(
    "2-4,6-8",
    "2-3,4-5",
    "5-7,7-9",
    "2-8,3-7",
    "6-6,4-6",
    "2-6,4-8"
  )

  "Day4 resolver part 1" should "calculate how many assignment pairs are fully in overlap" in {
    resolver.resolve(input) should be(2L)
  }

  "parser" should "create 2 assignments" in {
    val parsed = resolver.parse("2-4,6-8")
    parsed should be(
      Some(
        (Assignment(Seq(2, 3, 4)), Assignment(Seq(6, 7, 8)))
      )
    )
  }

  it should "return None for incorrect values" in {
    resolver.parse("2,6-8") should be(None)
    resolver.parse("2-4") should be(None)
    resolver.parse("2-a,6-8") should be(None)
    resolver.parse("2_3,6-8") should be(None)
    resolver.parse(" ") should be(None)
    resolver.parse("") should be(None)
  }

}
