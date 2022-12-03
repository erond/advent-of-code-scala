package challenges.twentytwo.daythree.model

// must already be distinct
case class RucksackInCompartments(firstHalf: Seq[RucksackObject], secondHalf: Seq[RucksackObject]) {
  lazy val objectInCommon: RucksackObject = {
    // assumption: items have been deduplicated during parsing
    firstHalf.intersect(secondHalf).head
  }
  def priorityOfObjectInCommon: Int = objectInCommon.priority
}
