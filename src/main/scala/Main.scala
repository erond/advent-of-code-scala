import challenges.twentytwo.Day1
import common.controller.Resolver
import common.input.InputReader

object Main {

  val resolvers: Map[Int, Map[Int, Resolver]] = Map(
    2022 -> Map(
      1 -> new Day1()
    )
  )

  def main(args: Array[String]): Unit = {
    val programStart = System.nanoTime()
    require(args.length == 2, "2 args expected: year and day to execute (e.g. 2022,1)")
    val year  = args.head.toInt
    val day   = args.last.toInt
    val resolver = resolvers(year)(day)
    val input = InputReader.readInput(year, day).getOrElse(throw new Exception("Unable to read input"))
    invokeResolver(resolver, input, 1)
    invokeResolver(resolver, input, 2)
    val programEnd = System.nanoTime()
    println(s"Main program for year=$year and day=$day took ${(programEnd-programStart)/1000} microsec")
  }

  def invokeResolver(resolver: Resolver, input: Seq[String], part: Int): Long = {
    val resolverStart = System.nanoTime()
    val solution1 = resolver.resolve(part, input)
    val resolverEnd = System.nanoTime()
    println(s"Solution $part is $solution1 - algorithm took ${(resolverEnd - resolverStart) / 1000} microsec")
    solution1
  }

}
