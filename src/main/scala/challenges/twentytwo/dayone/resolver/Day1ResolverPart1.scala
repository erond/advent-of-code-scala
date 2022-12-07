package challenges.twentytwo.dayone.resolver

import challenges.twentytwo.dayone.model.StatePart1
import common.controller.Resolver

import scala.util.Try

class Day1ResolverPart1 extends Resolver[Seq[Option[Long]], Long] {

  override def parse(toParse: Seq[String]): Option[Seq[Option[Long]]] =
    Try {
      toParse.map(s => Try(s.toLong).toOption)
    }.toOption

  override def businessLogic(parsed: Seq[Option[Long]]): Long = {

    val res = parsed
      .foldRight(StatePart1(0L, 0L)) { (value, state) =>
        value.fold(StatePart1(Math.max(state.max, state.accum), 0L)) { validLong =>
          StatePart1(state.max, state.accum + validLong)
        }
      }
    Math.max(res.max, res.accum)

  }

}
