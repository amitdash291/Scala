package com.tfp.tictactoe

sealed trait Result
case class Success(board: HasBeenPlayedBoard) extends Result
case object Failure extends Result
