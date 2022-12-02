package challenges.twentytwo.daytwo.resolver

import challenges.twentytwo.daytwo.model.{MyMove, OpponentMove, ParsedStrategyMove1}
import common.controller.Resolver

import scala.util.Try

class Day2ResolverPart1 extends Resolver[ParsedStrategyMove1] {

  override def resolve(input: Seq[String]): Long = {
    input.flatMap(parse).map(_.totalScore).sum
  }

  override def parse(toParse: String): Option[ParsedStrategyMove1] = {
    // input is like "A X"
    Try {
      val chars = toParse.toCharArray
      ParsedStrategyMove1(OpponentMove(chars.head), MyMove(chars.last))
    }.toOption
  }
}
