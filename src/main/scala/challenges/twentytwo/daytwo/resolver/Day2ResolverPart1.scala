package challenges.twentytwo.daytwo.resolver

import challenges.twentytwo.daytwo.model.{MyMove, OpponentMove, ParsedStrategyMove1}
import common.controller.Resolver

import scala.util.Try

class Day2ResolverPart1 extends Resolver[Seq[ParsedStrategyMove1], Long] {

  override def businessLogic(parsed: Seq[ParsedStrategyMove1]): Long = {
    parsed
      .map(_.totalScore)
      .sum
  }

  override def parse(toParse: Seq[String]): Option[Seq[ParsedStrategyMove1]] = {
    // input is like "A X"
    Try {
      toParse.map { s =>
        val chars = s.toCharArray
        ParsedStrategyMove1(OpponentMove(chars.head), MyMove(chars.last))
      }
    }.toOption
  }
}
