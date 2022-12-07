package challenge.twentytwo.test

import challenges.twentytwo.dayfour.model.Assignment
import challenges.twentytwo.dayfour.resolver.Day4ResolverPart1
import common.test.ResolverSuite

class Day4ResolverPart1Suite extends ResolverSuite {

  override val resolver = new Day4ResolverPart1()

  override def year: Int = 2022

  override def day: Int = 4

  "Day4 resolver part 1" should "calculate how many assignment pairs are fully in overlap" in {
    resolver.resolve(input) should be(2L)
  }

  "parser" should "create 2 assignments" in {
    val parsed = resolver.parse(Seq("2-4,6-8"))
    parsed should be(
      Some(
        Seq((Assignment(2, 4), Assignment(6, 8)))
      )
    )
  }

  it should "return None for incorrect values" in {
    resolver.parse(Seq("2,6-8")) should be(None)
    resolver.parse(Seq("2-4")) should be(None)
    resolver.parse(Seq("2-a,6-8")) should be(None)
    resolver.parse(Seq("2_3,6-8")) should be(None)
    resolver.parse(Seq(" ")) should be(None)
    resolver.parse(Seq("")) should be(None)
  }

}
