package com.tfp.tictactoe

sealed trait CellType
case object EmptyCellType extends CellType
case class OccupiedCellType(player: Player) extends CellType

case class Cell(position: Position, cellType: CellType)
type Row = List[Cell]
