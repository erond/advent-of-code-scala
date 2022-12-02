package challenges.twentytwo.dayone.resolver

import challenges.twentytwo.dayone.model.{StatePart1, StatePart2}
import common.controller.Resolver

import scala.math.Ordering.Implicits.infixOrderingOps
import scala.util.Try

class Day1ResolverPart2 extends Resolver[Long] {

  override def parse(toParse: String): Option[Long] = Try(toParse.toLong).toOption

  override def resolve(input: Seq[String]): Long = {
    val res = input
      .foldRight(StatePart2(Seq.empty, 0L)) { (value, state) =>
        parse(value).fold(StatePart2(getTopn(3, state.top3 :+ state.accum), 0L)) { validLong =>
          StatePart2(state.top3, state.accum + validLong)
        }
      }
    getTopn(3, res.top3 :+ res.accum).sum
  }

  def getTopn[A](n: Int, elements: Seq[A])(implicit ord: Ordering[A]): Seq[A] = {
    elements.sortWith(_ > _).take(n)
  }

}
