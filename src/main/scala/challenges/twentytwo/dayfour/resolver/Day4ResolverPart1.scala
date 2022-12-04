package challenges.twentytwo.dayfour.resolver

import challenges.twentytwo.dayfour.model.Assignment
import common.controller.Resolver

class Day4ResolverPart1 extends Resolver[(Assignment, Assignment)] with Day4Parser {

  // assumptions: ranges are sorted, with correct domain values and in the right quantity (At least 2 assignments)
  override def resolve(input: Seq[String]): Long = {
    input
      .flatMap(parse)
      .flatMap { assignments =>
        val first                 = assignments._1
        val second                = assignments._2
        // looking for full overlap
        val firstIsSubsetOfSecond = first.from >= second.from && first.to <= second.to
        lazy val secondIsSubsetOfFirst = !firstIsSubsetOfSecond && second.from >= first.from && second.to <= first.to

        if (firstIsSubsetOfSecond || secondIsSubsetOfFirst) Some(true) else None
      }
      .size
  }

}
