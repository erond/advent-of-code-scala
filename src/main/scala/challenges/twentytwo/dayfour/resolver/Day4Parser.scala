package challenges.twentytwo.dayfour.resolver

import challenges.twentytwo.dayfour.model.Assignment
import common.input.InputParser

import scala.language.postfixOps
import scala.util.Try

trait Day4Parser extends InputParser[(Assignment, Assignment)] {

  val ASSIGNMENT_SEPARATOR = ","
  val SECTIONID_SEPARATOR = "-"
  val EXPECTED_ASSIGNMENTS = 2
  val EXPECTED_SECTIONIDs = 2

  /**
   * "2-4,5-8" must become Assignment(Seq(2,3,4),Seq(5,6,7,8))
   */
  override def parse(toParse: String): Option[(Assignment, Assignment)] = {
    Try {
      val parts: Array[String] = toParse.split(ASSIGNMENT_SEPARATOR, EXPECTED_ASSIGNMENTS)
      require(parts.length == EXPECTED_ASSIGNMENTS, s"2 assignments are mandatory. ${parts.length} found in $toParse")
      val firstRangeString: Array[String] = parts.head.split(SECTIONID_SEPARATOR, EXPECTED_SECTIONIDs)
      require(
        firstRangeString.length == EXPECTED_SECTIONIDs,
        s"Range must me made of start and end, this ones is invalid: ${parts.head}"
      )
      val firstStart = firstRangeString(0).toInt
      val firstEnd = firstRangeString(1).toInt
      val firstAssignment = firstStart to firstEnd toArray

      val secondRangeString: Array[String] = parts.last.split(SECTIONID_SEPARATOR, EXPECTED_SECTIONIDs)
      require(
        secondRangeString.length == EXPECTED_SECTIONIDs,
        s"Range must me made of start and end, this ones is invalid: ${parts.last}"
      )
      val secondStart = secondRangeString(0).toInt
      val secondEnd = secondRangeString(1).toInt
      val secondAssignment = secondStart to secondEnd toArray

      (Assignment(firstAssignment), Assignment(secondAssignment))
    }.toOption
  }

}
