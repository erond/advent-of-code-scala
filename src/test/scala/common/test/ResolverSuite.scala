package common.test

import common.controller.Resolver
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

trait ResolverSuite extends AnyFlatSpec with Matchers {

  def resolver: Resolver[_]

  def input: Seq[String]

}
