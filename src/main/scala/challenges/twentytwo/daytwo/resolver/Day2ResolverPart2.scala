package challenges.twentytwo.daytwo.resolver

import challenges.twentytwo.daytwo.model.{Match, MyMove, OpponentMove, ParsedStrategyMove1, ParsedStrategyMove2}
import common.controller.Resolver

import scala.util.Try

class Day2ResolverPart2 extends Resolver[ParsedStrategyMove2] {

  override def resolve(input: Seq[String]): Long = {
    input.flatMap(parse).map(_.totalScore).sum
  }

  override def parse(toParse: String): Option[ParsedStrategyMove2] = {
    // input is like "A X"
    Try {
      val chars = toParse.toCharArray
      ParsedStrategyMove2(OpponentMove(chars.head), Match(chars.last))
    }.toOption
  }
}
