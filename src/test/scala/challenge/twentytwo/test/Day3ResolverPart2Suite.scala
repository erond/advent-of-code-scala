package challenge.twentytwo.test

import challenges.twentytwo.daythree.model.{Rucksack, RucksackObject}
import challenges.twentytwo.daythree.resolver.Day3ResolverPart2
import common.test.ResolverSuite

class Day3ResolverPart2Suite extends ResolverSuite {

  override val resolver = new Day3ResolverPart2()
  override val input: Seq[String] = Seq(
    "vJrwpWtwJgWrhcsFMMfFFhFp",
    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
    "PmmdzqPrVvPwwTWBwg",
    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
    "ttgJtRGJQctTZtZT",
    "CrZsJsPPZsGzwwsLwLmpwMDw"
  )

  "Day3 resolver part 2" should "calculate the total score for groups of 3" in {
    resolver.resolve(input) should be(70L)
  }

  "parser" should "remove duplicates, create Rucksack" in {
    val parsed = resolver.parse("aaBcBBde")
    parsed should be(
      Some(
        Rucksack(
          Seq(
            RucksackObject('a'),
            RucksackObject('B'),
            RucksackObject('c'),
            RucksackObject('d'),
            RucksackObject('e')
          )
        )
      )
    )
  }

}
