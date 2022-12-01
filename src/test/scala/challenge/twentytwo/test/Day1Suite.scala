package challenge.twentytwo.test

import challenges.twentytwo.Day1
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day1Suite extends AnyFlatSpec with Matchers {

  val resolver = new Day1()

  "Day 1 resolver" should "return a max(sum) across multiple lists of values" in {
    val input = Seq(
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
    resolver.resolve(1, input) should be(100L)
    resolver.resolve(2, input) should be(145L)
  }

  "getTopn" should "return empty list for empty input" in {
    resolver.getTopn(3, Seq.empty[Int]) should be(Seq.empty[Int])
  }

  it should "return the same list but sorted desc as long as its size is < n" in {
    val input = Seq(1,2,3)
    resolver.getTopn(3, input) should be(input.reverse)
  }

}
