package challenge.twentytwo.test

import challenges.twentytwo.daytwo.model._
import challenges.twentytwo.daytwo.resolver.Day2ResolverPart2
import common.test.ResolverSuite

class Day2ResolverPart2Suite extends ResolverSuite {

  override val resolver = new Day2ResolverPart2()
  override val input: Seq[String] = Seq(
    "A Y",
    "B X",
    "C Z"
  )

  "Day2 resolver part 2" should "calculate the total score" in {
    resolver.resolve(input) should be(12L)
  }

  "parser" should "return valid opponent and my move" in {
    resolver.parse(input.head) should be(Some(ParsedStrategyMove2(A, DRAW)))
  }

  it should "return none for invalid strings or invalida values" in {
    resolver.parse("V A") should be(None)
    resolver.parse(" ") should be(None)
    resolver.parse("A") should be(None)
  }

}
