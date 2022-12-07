package challenge.twentytwo.test

import challenges.twentytwo.dayone.resolver.Day1ResolverPart1
import common.test.ResolverSuite

class Day1ResolverPart1Suite extends ResolverSuite {

  override val resolver = new Day1ResolverPart1()

  "Day 1 resolver part 1" should "return a max(sum) across multiple lists of values" in {
    resolver.resolve(input) should be(100L)
  }

  "parser" should "parse a valid long" in {
    val res = 12345L
    resolver.parse(Seq(res.toString)) should be(Some(Seq(Some(res))))
  }

  it should "return None for spaces or other invalid chars" in {
    val res = ""
    resolver.parse(Seq(res)) should be(Some(Seq(Option.empty[Long])))
  }

  override def year = 2022

  override def day = 1
}
