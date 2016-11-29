package com.wpi.service;

import java.util.ArrayList;
import java.util.List;

import com.wpi.models.Board;
import com.wpi.models.Cell;

public class CellsService {

	private List<Cell> cells = null;
	public int row;
	public int col;
	
	public CellsService(int row, int col){
		cells = new ArrayList<Cell>();
		this.row = row;
		this.col = col;
	}
	
	public void setCellNum(List<String> letters){
		
		int index = 0;
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				Cell cell = new Cell();
				cell.setChosen(false);
				cell.setCol(this.col+j);
				cell.setRow(this.row+i);
				cell.setLetter(letters.get(index));
				cell.setRepetition(false);
				cell.setScore(CalculateLocalScore.calculateLetterScore(cell.getLetter()));
				index++;
				cells.add(cell);
			}
		}
		
	}
	
	public void setRepetition(int x, int y){
		int xborder = x+3;
		int yborder = y+3;
		for(Cell cell: cells){
			if(((cell.getRow()>=x)&&(cell.getRow()<=xborder))&&((cell.getCol()>=y)&&(cell.getCol()<=yborder))){
				cell.setRepetition(true);
			}
		}
	}
	
	public List<Cell> getCells(){
		if(cells.size()==0)
			return null;
		else
			return cells;
	}
}
