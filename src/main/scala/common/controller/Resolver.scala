package common.controller

import common.input.InputParser

trait Resolver[P, O] extends InputParser[P] {

  final def resolve(input: Seq[String]): O = {
    businessLogic(parse(input).getOrElse(throw new Exception("unable to parse input")))
  }

  def businessLogic(parsed: P): O

}
