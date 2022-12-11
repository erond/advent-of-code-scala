package challenge.twentytwo.test

import challenges.twentytwo.dayseven.model._
import challenges.twentytwo.dayseven.resolver.Day7ResolverPart1
import common.test.ResolverSuite

class Day7ResolverPart1Suite extends ResolverSuite {

  override val resolver = new Day7ResolverPart1()

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

  "Day 7 part 1 business logic" should "find the total size of folders < 100000 bytes" in {
    resolver.businessLogic(expectedParsed) should be(95437L)
  }

  "parser" should "transform the input in a list of parsed lines" in {
    val parsed = resolver.parse(input)
    parsed should be(Some(expectedParsed))
  }

  "command parser" should "parse a CD" in {
    CommandConsoleLine.parse("$ cd /") should be(Some(CD("$ cd /")))
    CommandConsoleLine.parse("$ cd ..") should be(Some(CD("$ cd ..")))
    CommandConsoleLine.parse("$ ls") should be(Some(LS("$ ls")))
    CommandConsoleLine.parse("14848514 b.txt") should be(None)
    CommandConsoleLine.parse("dir e") should be(None)
  }

}
