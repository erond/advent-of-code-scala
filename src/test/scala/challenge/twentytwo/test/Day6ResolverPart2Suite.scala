package challenge.twentytwo.test

import challenges.twentytwo.daysix.Day6ResolverPart2
import common.test.ResolverSuite

class Day6ResolverPart2Suite extends ResolverSuite {

  override val resolver = new Day6ResolverPart2()

  override def year: Int = 2022

  override def day: Int = 6

  "Day 6 part 2 business logic" should "find the last signal char completing the marker sequence with different size" in {
    resolver.businessLogic("mjqjpqmgbljsphdztnvjfqwrcgsmlb".toCharArray.zipWithIndex.toSeq) should be(19)
    resolver.businessLogic("bvwbjplbgvbhsrlpgdmjqwftvncz".toCharArray.zipWithIndex.toSeq) should be(23)
    resolver.businessLogic("nppdvjthqldpwncqszvftbrmjlhg".toCharArray.zipWithIndex.toSeq) should be(23)
    resolver.businessLogic("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".toCharArray.zipWithIndex.toSeq) should be(29)
    resolver.businessLogic("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".toCharArray.zipWithIndex.toSeq) should be(26)
  }

}
