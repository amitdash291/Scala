package com.tfp.tictactoe

object Api {
  def move(playableBoard: PlayableBoard)(position: Position)(player: Player): Result = ???

  def whoWon(finishedBoard: FinishedBoard): Option[Player] = ???

  //// "Either" could also be used but is not a recommended approach
  //def whoWon(board: FinishedBoard): Either[Player, Nothing] = ???

  def playerAt(board: Board)(position: Position): Option[Player] = {
    board match {
      case EmptyBoard => Nothing
      case HasBeenPlayedBoard(cells) => {
        cells match {
          case EmptyCellType => Nothing
          case OccupiedCellType(player) => player
        }
      }
    }
  }

  def isDraw(finishedBoard: FinishedBoard): Boolean = {
    whoWon(finishedBoard).isEmpty
    /*whoWon(finishedBoard) match {
      case None => true
      case Some(player) => false
    }*/
    //whoWon(finishedBoard).map(player => false).getOrElse(true);
  }

  def takeBack(hasBeenPlayedBoard: HasBeenPlayedBoard): PlayableBoard = ???
}
