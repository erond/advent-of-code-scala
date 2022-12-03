package challenges.twentytwo.daythree.resolver

import challenges.twentytwo.daythree.model._
import common.controller.Resolver

import scala.util.Try

class Day3ResolverPart1 extends Resolver[RucksackInCompartments] {

  /**
    * Find the item type that appears in both compartments of each rucksack, the return the result
    * @param input is all the items in rucksack. Every item type is identified by a single lowercase or uppercase letter
    *              (that is, 'a' and 'A' refer to different types of items)
    * @return the sum of the priorities of those item types
    */
  override def resolve(input: Seq[String]): Long = {
    input.flatMap(parse).map(_.priorityOfObjectInCommon).sum.toLong
  }

  /**
    * A given rucksack always has the same number of items in each of its two compartments,
    * so the first half of the characters represent items in the first compartment,
    * while the second half of the characters represent items in the second compartment
    *
    * To help prioritize item rearrangement, every item type can be converted to a priority
    *  - Lowercase item types a through z have priorities 1 through 26
    *  - Uppercase item types A through Z have priorities 27 through 52
    *
    * @param toParse The list of items for each rucksack is given as characters all on a single line
    * @return the two compartments objects, with related priority of the object in common (and the object, for debug)
    *         but with disting objects for performance reasons
    */
  override def parse(toParse: String): Option[RucksackInCompartments] = {
    Try {
      require(toParse.length % 2 == 0, "odd size for rucksack == impossibile to split in equal halves")
      val (half1, half2) = toParse.splitAt(toParse.length / 2)
      RucksackInCompartments(
        half1.toCharArray.toSeq.distinct.map(RucksackObject(_)),
        half2.toCharArray.toSeq.distinct.map(RucksackObject(_))
      )
    }.toOption
  }
}
