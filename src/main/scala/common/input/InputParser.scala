package common.input

trait InputParser[P] {

  def parse(toParse: Seq[String]): Option[P]

}
