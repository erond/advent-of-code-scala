package challenges.twentytwo.daysix

import common.controller.Resolver

import scala.util.Try

class Day6ResolverPart1 extends Resolver[Seq[(Char, Int)], Int] {

  def markerSize: Int = 4

  override def businessLogic(parsed: Seq[(Char, Int)]): Int = {
    val found = parsed.sliding(markerSize, 1).find(p => p.map(_._1).distinct.size == p.size)
    found.get.last._2 + 1
  }

  override def parse(toParse: Seq[String]): Option[Seq[(Char, Int)]] =
    Try {
      toParse.head.trim.toCharArray.zipWithIndex.toSeq
    }.toOption
}
