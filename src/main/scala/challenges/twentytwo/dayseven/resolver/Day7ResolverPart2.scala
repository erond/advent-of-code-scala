package challenges.twentytwo.dayseven.resolver

class Day7ResolverPart2 extends Day7ResolverPart1 {

  val MAX_CAPACITY = 70000000L
  val MIN_CAPACITY_FOR_UPDATE = 30000000L

  override def computeFinalResult(input: Seq[Long]): Long = {
    val currentAvailableSpace = MAX_CAPACITY - input.max
    val stillToBeMadeAvailable = MIN_CAPACITY_FOR_UPDATE - currentAvailableSpace
    require(stillToBeMadeAvailable > 0, "If we got here it means we didn't have the problem in the first place")
    input.filter(_ >= stillToBeMadeAvailable).min
  }

}
