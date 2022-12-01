package challenges.twentytwo

import common.controller.Resolver

import scala.math.Ordering.Implicits.infixOrderingOps
import scala.util.Try

class Day1 extends Resolver {

  override def resolve(part: Int, input: Seq[String]): Long = {
    part match {
      case 1 =>
        val res = input
          .foldRight(StatePart1(0L, 0L)) { (value, state) =>
            val newValueOpt = Try(value.toLong).toOption
            newValueOpt.fold(StatePart1(Math.max(state.max, state.accum), 0L)) { validLong =>
              StatePart1(state.max, state.accum + validLong)
            }
          }
        Math.max(res.max, res.accum)
      case 2 =>
        val res = input
          .foldRight(StatePart2(Seq.empty, 0L)) { (value, state) =>
            val newValueOpt = Try(value.toLong).toOption
            newValueOpt.fold(StatePart2(getTopn(3, state.top3 :+ state.accum), 0L)) { validLong =>
              StatePart2(state.top3, state.accum + validLong)
            }
          }
        getTopn(3, res.top3 :+ res.accum).sum
      case _ => throw new UnsupportedOperationException("Only parts 1 and 2 have been defined")
    }
  }

  def getTopn[A](n: Int, elements: Seq[A])(implicit ord: Ordering[A]): Seq[A] = {
    elements.sortWith(_ > _).take(n)
  }

}

case class StatePart1(max: Long, accum: Long)
case class StatePart2(top3: Seq[Long], accum: Long)
