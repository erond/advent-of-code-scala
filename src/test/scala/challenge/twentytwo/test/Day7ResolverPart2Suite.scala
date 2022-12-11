package challenge.twentytwo.test

import challenges.twentytwo.dayseven.model._
import challenges.twentytwo.dayseven.resolver.Day7ResolverPart2
import common.test.ResolverSuite

class Day7ResolverPart2Suite extends ResolverSuite {

  override val resolver = new Day7ResolverPart2()

  override def year: Int = 2022

  override def day: Int = 7

  val expectedParsed: ParsedConsole = ParsedConsole(
    Seq(
      CD("$ cd /"),
      LS("$ ls"),
      FolderConsoleLine("dir a"),
      FileConsoleLine("14848514 b.txt"),
      FileConsoleLine("8504156 c.dat"),
      FolderConsoleLine("dir d"),
      CD("$ cd a"),
      LS("$ ls"),
      FolderConsoleLine("dir e"),
      FileConsoleLine("29116 f"),
      FileConsoleLine("2557 g"),
      FileConsoleLine("62596 h.lst"),
      CD("$ cd e"),
      LS("$ ls"),
      FileConsoleLine("584 i"),
      CD("$ cd .."),
      CD("$ cd .."),
      CD("$ cd d"),
      LS("$ ls"),
      FileConsoleLine("4060174 j"),
      FileConsoleLine("8033020 d.log"),
      FileConsoleLine("5626152 d.ext"),
      FileConsoleLine("7214296 k")
    )
  )

  "Day 7 part 2 business logic" should "find the size of the dir that can be deleted" in {
    resolver.businessLogic(expectedParsed) should be(24933642L)
  }

}
