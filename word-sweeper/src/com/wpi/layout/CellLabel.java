package com.wpi.layout;

import javax.swing.JLabel;

import com.wpi.models.Cell;

public class CellLabel extends JLabel{
	private Cell cell;

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}
	
}
