package challenges.twentytwo.daythree.model

import scala.language.postfixOps

object RucksackInventory {
  val inventoryNames: Array[Char]        = ('a' to 'z' toArray) ++ ('A' to 'Z' toArray)
  lazy val inventoryPriorities: Set[Int] = 1 to inventoryNames.length toSet
  // no duplicates since it starts from a set
  lazy val inventoryObjects: Map[Char,RucksackObject] = inventoryPriorities.map { i =>
    val objectName = inventoryNames.apply(i - 1)
    objectName -> new RucksackObject(objectName, i)
  }.toMap
}
