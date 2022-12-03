package challenges.twentytwo.daythree.resolver

import challenges.twentytwo.daythree.model._
import common.controller.Resolver

import scala.util.Try

class Day3ResolverPart2 extends Resolver[Rucksack] {

  /**
   * w/r/t/ part 1, now we must group by 3 subsequent elves and find the common item
   */
  override def resolve(input: Seq[String]): Long = {
    input.flatMap(parse).sliding(3, 3).map(ElvesGroup(_).priorityOfItemInCommon).sum.toLong
  }

  /**
   * w/r/t/ part 1, this time we consider the whole rucksack, with distinct items to speedup the search
   */
  override def parse(toParse: String): Option[Rucksack] = {
    Try {
      Rucksack(toParse.toCharArray.toSeq.distinct.map(RucksackObject(_)))
    }.toOption
  }
}
