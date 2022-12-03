package challenges.twentytwo.daythree.model

case class RucksackObject(name: Char, priority: Int)

object RucksackObject {
  def apply(c: Char): RucksackObject = RucksackInventory.inventoryObjects(c)
}


