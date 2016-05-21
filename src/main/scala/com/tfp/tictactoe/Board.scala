package com.tfp.tictactoe

sealed trait Board
sealed trait PlayableBoard extends Board
sealed trait HasBeenPlayedBoard extends Board
sealed trait FinishedBoard extends HasBeenPlayedBoard

case object EmptyBoard extends PlayableBoard
case class InPlayBoard(cells: List[Cell]) extends PlayableBoard with HasBeenPlayedBoard
case class WinningBoard(cells: List[Cell]) extends FinishedBoard
case class FullBoard(cells: List[Cell]) extends FinishedBoard
