package challenge.twentytwo.test

import challenges.twentytwo.daytwo.model._
import challenges.twentytwo.daytwo.resolver.Day2ResolverPart1
import common.test.ResolverSuite

class Day2ResolverPart1Suite extends ResolverSuite {

  override val resolver = new Day2ResolverPart1()

  "Day2 resolver part 1" should "calculate the total score" in {
    resolver.resolve(input) should be(15L)
  }

  "parser" should "return valid opponent and my move" in {
    resolver.parse(Seq("A Y")) should be(Some(Seq(ParsedStrategyMove1(A, Y))))
  }

  it should "return none for invalid strings or invalida values" in {
    resolver.parse(Seq("V A")) should be(None)
    resolver.parse(Seq(" ")) should be(None)
    resolver.parse(Seq("A")) should be(None)
  }

  override def year: Int = 2022

  override def day: Int = 2
}
