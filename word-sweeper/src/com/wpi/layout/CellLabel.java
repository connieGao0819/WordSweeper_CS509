package com.wpi.layout;

import javax.swing.JLabel;

import com.wpi.models.Cell;
/**
 * CellLabel class, which contains all the info and functions about the board.  
 * 
 * @author Haozhe Zhang,Jiani Gao
 *
 */
public class CellLabel extends JLabel{
	private Cell cell;

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}
	
}
