package challenge.twentytwo.test

import challenges.twentytwo.daysix.Day6ResolverPart1
import common.test.ResolverSuite

class Day6ResolverPart1Suite extends ResolverSuite {

  override val resolver = new Day6ResolverPart1()

  override def year: Int = 2022

  override def day: Int = 6

  def expectedParsed: Seq[(Char, Int)] = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".toCharArray.zipWithIndex.toSeq

  "Day 6 part 1 business logic" should "find the last signal char completing the marker sequence" in {
    resolver.businessLogic(expectedParsed) should be(11)
  }

  "parser" should "transform the sequence to an array of char" in {
    val parsed = resolver.parse(input)
    parsed should be(Some(expectedParsed))
  }

}
