package challenges.twentytwo.dayone.resolver

import challenges.twentytwo.dayone.model.{StatePart1, StatePart2}
import common.controller.Resolver

import scala.math.Ordering.Implicits.infixOrderingOps
import scala.util.Try

class Day1ResolverPart1 extends Resolver[Long] {

  override def parse(toParse: String): Option[Long] = Try(toParse.toLong).toOption

  override def resolve(input: Seq[String]): Long = {

    val res = input
      .foldRight(StatePart1(0L, 0L)) { (value, state) =>
        parse(value).fold(StatePart1(Math.max(state.max, state.accum), 0L)) { validLong =>
          StatePart1(state.max, state.accum + validLong)
        }
      }
    Math.max(res.max, res.accum)

  }

  def getTopn[A](n: Int, elements: Seq[A])(implicit ord: Ordering[A]): Seq[A] = {
    elements.sortWith(_ > _).take(n)
  }

}
