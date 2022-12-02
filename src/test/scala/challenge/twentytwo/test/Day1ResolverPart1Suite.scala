package challenge.twentytwo.test

import challenges.twentytwo.dayone.resolver.{Day1ResolverPart1, Day1ResolverPart2}
import common.test.ResolverSuite

class Day1ResolverPart1Suite extends ResolverSuite {

  override val resolver = new Day1ResolverPart1()
  override val input: Seq[String] = Seq(
    "0",
    " ",
    "10",
    " ",
    "5",
    "10",
    " ",
    "5",
    "10",
    "15",
    " ",
    "100"
  )

  "Day 1 resolver part 1" should "return a max(sum) across multiple lists of values" in {
    resolver.resolve(input) should be(100L)
  }

  "getTopn" should "return empty list for empty input" in {
    resolver.getTopn(3, Seq.empty[Int]) should be(Seq.empty[Int])
  }

  it should "return the same list but sorted desc as long as its size is < n" in {
    val input = Seq(1,2,3)
    resolver.getTopn(3, input) should be(input.reverse)
  }

  "parser" should "parse a valid long" in {
    val res = 12345L
    resolver.parse(res.toString) should be(Some(res))
  }

  it should "return None for spaces or other invalid chars" in {
    resolver.parse(" ") should be(None)
  }

}
