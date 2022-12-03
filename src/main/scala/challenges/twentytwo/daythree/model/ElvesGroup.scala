package challenges.twentytwo.daythree.model

// assumption: every rucksack has distinct items thanks to parsing
case class ElvesGroup(rucksacks: Seq[Rucksack]) {
  require(rucksacks.size == 3, "max 3 elves per group")
  lazy val itemInCommon: RucksackObject = {
    val intersection: Rucksack = rucksacks.reduce((a, b) => Rucksack(a.items.intersect(b.items)))
    intersection.items.head
  }
  def priorityOfItemInCommon: Int = itemInCommon.priority
}
