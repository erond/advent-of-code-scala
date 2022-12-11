package challenges.twentytwo.dayseven.model

case class FSContentBundle(items: Seq[FSContent with ParsedConsoleLine]) {
  lazy val size: Long = items.flatMap(i => i match {
    case line: FileConsoleLine => Some(line.size)
    case _ => None
  }).sum

  def :+(item: FSContent with ParsedConsoleLine): FSContentBundle = this.copy(items :+ item)

  override def toString: String = s"${items.map(_.rawConsoleLine).mkString(", ")} | total size: $size"
}

object FSContentBundle {
  def empty: FSContentBundle = FSContentBundle(Seq.empty[FSContent with ParsedConsoleLine])
}
