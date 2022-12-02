package common.input

trait InputParser[A] {

  def parse(toParse: String): Option[A]

}
