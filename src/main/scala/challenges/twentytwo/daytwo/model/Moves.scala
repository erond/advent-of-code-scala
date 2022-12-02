package challenges.twentytwo.daytwo.model

sealed trait Moves

sealed trait OpponentMove extends Moves {
  def wasVSIn(m: Match): MyMove
}

object OpponentMove {
  def apply(char: Char): OpponentMove = char match {
    case 'A' => A
    case 'B' => B
    case 'C' => C
    case _   => throw new UnsupportedOperationException("invalid opponent move")
  }
}

case object A extends OpponentMove {
  override def wasVSIn(m: Match): MyMove = m match {
    case WIN  => Y
    case LOSE => Z
    case DRAW => X
  }
} // rock

case object B extends OpponentMove {
  override def wasVSIn(m: Match): MyMove = m match {
    case WIN  => Z
    case LOSE => X
    case DRAW => Y
  }
} // paper

case object C extends OpponentMove {
  override def wasVSIn(m: Match): MyMove = m match {
    case WIN => X
    case LOSE => Y
    case DRAW => Z
  }
} // scissor

sealed trait MyMove extends Moves {
  def score: Int
  def VS(o: OpponentMove): Match
}
case object X extends MyMove {
  override val score = 1

  override def VS(o: OpponentMove): Match = o match {
    case A => DRAW
    case B => LOSE
    case C => WIN
  }

} // rock

case object Y extends MyMove {
  override val score = 2

  override def VS(o: OpponentMove): Match = o match {
    case A => WIN
    case B => DRAW
    case C => LOSE
  }

} // paper

case object Z extends MyMove {
  override val score = 3

  override def VS(o: OpponentMove): Match = o match {
    case A => LOSE
    case B => WIN
    case C => DRAW
  }

} // scissor

object MyMove {
  def apply(char: Char): MyMove = char match {
    case 'X' => X
    case 'Y' => Y
    case 'Z' => Z
    case _   => throw new UnsupportedOperationException("invalid my move")
  }
}

sealed trait Match {
  def score: Int
}
case object WIN extends Match {
  override def score: Int = 6
}
case object DRAW extends Match {
  override def score: Int = 3
}
case object LOSE extends Match {
  override def score: Int = 0
}

object Match {
  def apply(m: ParsedStrategyMove1): Match = m.myMove.VS(m.opponentMove)

  def apply(char: Char): Match = char match {
    case 'X' => LOSE
    case 'Y' => DRAW
    case 'Z' => WIN
    case _   => throw new UnsupportedOperationException("invalid match operation")
  }
}
