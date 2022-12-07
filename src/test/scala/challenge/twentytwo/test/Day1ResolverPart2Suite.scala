package challenge.twentytwo.test

import challenges.twentytwo.dayone.resolver.Day1ResolverPart2
import common.test.ResolverSuite

class Day1ResolverPart2Suite extends ResolverSuite {

  override val resolver = new Day1ResolverPart2()

  "Day 1 resolver part 2" should "return a max(sum) across multiple lists of values" in {
    resolver.resolve(input) should be(145L)
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
    resolver.parse(Seq(res.toString)) should be(Some(Seq(Some(res))))
  }

  it should "return None for spaces or other invalid chars" in {
    val res = ""
    resolver.parse(Seq(res)) should be(Some(Seq(Option.empty[Long])))
  }

  override def year: Int = 2022
  override def day: Int = 1
}
