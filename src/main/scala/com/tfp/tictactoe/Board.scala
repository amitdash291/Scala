package com.tfp.tictactoe

sealed trait Board
sealed trait PlayableBoard extends Board
sealed trait HasBeenPlayedBoard extends Board
sealed trait FinishedBoard extends HasBeenPlayedBoard

case object EmptyBoard extends PlayableBoard
case class InPlayBoard(rows: List[Row]) extends PlayableBoard with HasBeenPlayedBoard
case class WinningBoard(rows: List[Row]) extends FinishedBoard
case class FullBoard(rows: List[Row]) extends FinishedBoard
