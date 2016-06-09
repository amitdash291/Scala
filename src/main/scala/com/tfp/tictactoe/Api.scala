package com.tfp.tictactoe

object Api {
  def move(playableBoard: PlayableBoard)(position: Position)(player: Player): Result = ???

  def whoWon(finishedBoard: FinishedBoard): Option[Player] = ???

  //// "Either" could also be used but is not a recommended approach
  //def whoWon(board: FinishedBoard): Either[Player, Nothing] = ???

  def playerAt(hasBeenPlayedBoard: HasBeenPlayedBoard)(position: Position): Option[Player] = {
    hasBeenPlayedBoard.rows[position.row].cell[position.column] match {
      case EmptyCellType => Nothing
      case OccupiedCellType(player) => player
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
