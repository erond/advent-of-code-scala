package common.controller

import common.input.InputParser

trait Resolver[A] extends InputParser[A] {

  def resolve(input: Seq[String]): Long

}
