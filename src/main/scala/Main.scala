import challenges.twentytwo.dayeight.resolver.{Day8ResolverPart1, Day8ResolverPart2}
import challenges.twentytwo.dayfive.resolver.{Day5ResolverPart1, Day5ResolverPart2}
import challenges.twentytwo.dayfour.resolver.{Day4ResolverPart1, Day4ResolverPart2}
import challenges.twentytwo.dayone.resolver.{Day1ResolverPart1, Day1ResolverPart2}
import challenges.twentytwo.dayseven.resolver.{Day7ResolverPart1, Day7ResolverPart2}
import challenges.twentytwo.daysix.{Day6ResolverPart1, Day6ResolverPart2}
import challenges.twentytwo.daythree.resolver.{Day3ResolverPart1, Day3ResolverPart2}
import challenges.twentytwo.daytwo.resolver.{Day2ResolverPart1, Day2ResolverPart2}
import common.controller.Resolver
import common.input.InputReader

object Main extends App {

  val programStart = System.nanoTime()

  lazy val challengesSolved: Map[Int, Map[Int, Seq[Resolver[_, _]]]] = Map(
    2022 -> Map(
      1 -> Seq(new Day1ResolverPart1, new Day1ResolverPart2),
      2 -> Seq(new Day2ResolverPart1, new Day2ResolverPart2),
      3 -> Seq(new Day3ResolverPart1, new Day3ResolverPart2),
      4 -> Seq(new Day4ResolverPart1, new Day4ResolverPart2),
      5 -> Seq(new Day5ResolverPart1, new Day5ResolverPart2),
      6 -> Seq(new Day6ResolverPart1, new Day6ResolverPart2),
      7 -> Seq(new Day7ResolverPart1, new Day7ResolverPart2),
      8 -> Seq(new Day8ResolverPart1, new Day8ResolverPart2)
    )
  )

  args.length match {
    case 0 => // execute all
      challengesSolved.keys.foreach(processYear)
    case 1 => // execute year
      val year = args.head.toInt
      processYear(year)
    case 2 => // execute year,day
      val year                        = args.head.toInt
      val day                         = args.last.toInt
      val resolvers: Seq[Resolver[_, _]] = challengesSolved(year)(day)
      resolvers.foreach(resolver => invokeResolver(resolver, year, day))
    case _ => throw new IllegalArgumentException("Only 0 (all), 1 (year), or 2 (year and day) args accepted!")
  }

  val programEnd = System.nanoTime()
  println(s"Main program took ${(programEnd - programStart) / 1000} microsec")

  def processYear(aYear: Int): Unit = {
    val allResolversForTheYear = challengesSolved(aYear)
    allResolversForTheYear.foreach {
      case (aDay, resolvers) =>
        println(s"Processing year $aYear and day $aDay")
        resolvers.foreach(resolver => invokeResolver(resolver, aYear, aDay))
    }
  }

  def invokeResolver(resolver: Resolver[_, _], aYear: Int, aDay: Int): Any = {
    val input         = InputReader.readInput(aYear, aDay)
    val resolverStart = System.nanoTime()
    val solution     = resolver.resolve(input)
    val resolverEnd   = System.nanoTime()
    println(
      s"Solution of ${resolver.getClass.getCanonicalName} is $solution - algorithm took ${(resolverEnd - resolverStart) / 1000} microsec"
    )
    solution
  }

}
