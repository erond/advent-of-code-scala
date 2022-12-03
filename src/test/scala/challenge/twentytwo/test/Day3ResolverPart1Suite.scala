package challenge.twentytwo.test

import challenges.twentytwo.daythree.model.{RucksackInCompartments, RucksackObject}
import challenges.twentytwo.daythree.resolver.Day3ResolverPart1
import common.test.ResolverSuite

class Day3ResolverPart1Suite extends ResolverSuite {

  override val resolver = new Day3ResolverPart1()
  override val input: Seq[String] = Seq(
    "vJrwpWtwJgWrhcsFMMfFFhFp",
    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
    "PmmdzqPrVvPwwTWBwg",
    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
    "ttgJtRGJQctTZtZT",
    "CrZsJsPPZsGzwwsLwLmpwMDw"
  )

  "Day3 resolver part 1" should "calculate the total score" in {
    resolver.resolve(input) should be(157L)
  }

  "parser" should "remove duplicates, create Rucksack in 2 compartments and provide the common item" in {
    val parsed = resolver.parse("aaBcBBde")
    parsed should be(
      Some(
        RucksackInCompartments(
          Seq(
            RucksackObject('a'),
            RucksackObject('B'),
            RucksackObject('c')
          ),
          Seq(
            RucksackObject('B'),
            RucksackObject('d'),
            RucksackObject('e')
          )
        )
      )
    )
    parsed.get.objectInCommon should be(RucksackObject('B'))
  }

}
