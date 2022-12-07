package common.test

import common.controller.Resolver
import common.input.InputReader
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.Try

trait ResolverSuite extends AnyFlatSpec with Matchers {

  def resolver: Resolver[_, _]
  def year: Int
  def day: Int
  def input: Seq[String] =
    InputReader
      .readInput(year, day)

}
