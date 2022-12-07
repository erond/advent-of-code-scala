package challenges.twentytwo.daytwo.resolver

import challenges.twentytwo.daytwo.model.{Match, OpponentMove, ParsedStrategyMove2}
import common.controller.Resolver

import scala.util.Try

class Day2ResolverPart2 extends Resolver[Seq[ParsedStrategyMove2], Long] {

  override def businessLogic(parsed: Seq[ParsedStrategyMove2]): Long = {
    parsed
      .map(_.totalScore)
      .sum
  }

  override def parse(toParse: Seq[String]): Option[Seq[ParsedStrategyMove2]] = {
    // input is like "A X"
    Try {
      toParse.map { s =>
        val chars = s.toCharArray
        ParsedStrategyMove2(OpponentMove(chars.head), Match(chars.last))
      }
    }.toOption
  }
}
