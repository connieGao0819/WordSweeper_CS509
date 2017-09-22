package com.wpi.service;

import java.util.ArrayList;
import java.util.List;

import com.wpi.models.Board;
import com.wpi.models.Cell;
/**
 * set score of each cell
 * @author haozhezhang
 *
 */
public class CellsService {

	private List<Cell> cells = null;
	public int row;
	public int col;
	private int xbonus;
	private int ybonus;
	
	public CellsService(int row, int col, int xbonus, int ybonus){
		cells = new ArrayList<Cell>();
		this.row = row;
		this.col = col;
		this.xbonus = xbonus;
		this.ybonus = ybonus;
	}
	
	public void setCellNum(String[] letters){
		boolean hasBonus = false;
		int index = 0;
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				Cell cell = new Cell();
				cell.setChosen(false);
				cell.setCol(this.col+j);
				cell.setRow(this.row+i);
				if(letters[index].equals("Q")){
					cell.setLetter("QU");
				}else{
					cell.setLetter(letters[index]);
				}
				if(cell.getCol()==ybonus && cell.getRow()==xbonus){
					cell.setBonus(true);
					cell.setScore(10*CalculateLocalScore.calculateLetterScore(cell.getLetter()));
					hasBonus = true;
				}
				else{
					cell.setBonus(false);
					cell.setScore(CalculateLocalScore.calculateLetterScore(cell.getLetter()));
				}
				cell.setRepetition(false);
				index++;
				cells.add(cell);
			}
		}
		if(!hasBonus){
			int bonusIndex = (int)(0+Math.random()*15);
			cells.get(bonusIndex).setBonus(true);
			cells.get(bonusIndex).setScore(10*CalculateLocalScore.calculateLetterScore(cells.get(bonusIndex).getLetter()));

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
