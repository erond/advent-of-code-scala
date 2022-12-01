package common.controller

trait Resolver {

  /**
   * OK as long as return value (Solution) is always Long and for all the parts of the challenge
   */
  def resolve(part: Int, input: Seq[String]): Long

}
