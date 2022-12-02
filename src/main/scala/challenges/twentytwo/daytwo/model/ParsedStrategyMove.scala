package challenges.twentytwo.daytwo.model

sealed trait ParsedStrategyMove {
  def opponentMove: OpponentMove
  def totalScore: Int
}
case class ParsedStrategyMove1(override val opponentMove: OpponentMove, myMove: MyMove) extends ParsedStrategyMove {
  override lazy val totalScore: Int = Match(this).score + myMove.score
}

case class ParsedStrategyMove2(override val opponentMove: OpponentMove, matchResult: Match) extends ParsedStrategyMove {
  override lazy val totalScore: Int = matchResult.score + opponentMove.wasVSIn(matchResult).score
}
