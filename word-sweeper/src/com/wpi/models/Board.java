package com.wpi.models;

import java.util.ArrayList;
import java.util.List;

import com.wpi.service.CalculateLocalScore;
/**
 * Board entity class, which contains all the info and functions about the board.  
 * 
 * @author Haozhe Zhang,Jiani Gao
 *
 */

public class Board {
	private List<Cell> cells;
	private List<Cell> chosenCells;
	private int globalStartingCol;
	private int globalStartingRow;
	private int up;
	private int down;
	private int left;
	private int right;
	private Integer chosenLettersScore;
	private int xbonus;
	private int ybonus;
	private int rowChange;
	private int colChange;

	/**Board constructor*/
	public Board(){
		chosenCells = new ArrayList<Cell>();
	}
	/**get the xbonus attribute 
	 * @return
	 */
	public int getXbonus() {
		return xbonus;
	}
    
	public void setXbonus(int xbonus) {
		this.xbonus = xbonus;
	}
	/**get the ybonus attribute 
	 * @return
	 */
	public int getYbonus() {
		return ybonus;
	}

	public void setYbonus(int ybonus) {
		this.ybonus = ybonus;
	}
	/**get the rowChange attribute 
	 * @return
	 */
	public int getRowChange() {
		return rowChange;
	}

	public void setRowChange(int rowChange) {
		this.rowChange = rowChange;
	}
	/**get the colChange attribute 
	 * @return
	 */
	public int getColChange() {
		return colChange;
	}

	public void setColChange(int colChange) {
		this.colChange = colChange;
	}

	public void setChosenLettersScore(Integer chosenLettersScore) {
		this.chosenLettersScore = chosenLettersScore;
	}

	public Board(List<Cell> cells, int x, int y,int size, int xbonus, int ybonus){
		this.cells = cells;
		chosenCells = new ArrayList<Cell>();
		globalStartingCol = y;
		globalStartingRow = x;
		chosenLettersScore = 0;
		up = x-1;
		down = size-x-3;
		left = y-1;
		right = size-y-3;
		this.xbonus = xbonus;
		this.ybonus = ybonus;
	}
	/**get the globalStartingRow attribute 
	 * @return
	 */
	public int getGlobalStartingRow() {
		return globalStartingRow;
	}
    
	public void setGlobalStartingRow(int globalStartingRow) {
		this.globalStartingRow = globalStartingRow;
	}
	/**get the cells attribute 
	 * @return
	 */
	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}
	
	public void clearChosenCells(){
		chosenCells.clear();
	}
	/**get the chosenCells attribute 
	 * @return
	 */
	public List<Cell> getChosenCells() {
		return chosenCells;
	}

	public void setChosenCells(List<Cell> chosenCells) {
		this.chosenCells = chosenCells;
	}
	/**get the globalStartingCol attribute 
	 * @return
	 */
	public int getGlobalStartingCol() {
		return globalStartingCol;
	}

	public void setGlobalStartingCol(int globalStartingCol) {
		this.globalStartingCol = globalStartingCol;
	}
	/**get the up attribute 
	 * @return
	 */
	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}
	/**get the down attribute 
	 * @return
	 */
	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}
	/**get the left attribute 
	 * @return
	 */
	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}
	/**get the right attribute 
	 * @return
	 */
	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}
	/**get the chosenLettersScore attribute 
	 * @return
	 */
	public Integer getChosenLettersScore() {
		chosenLettersScore=0;
		if(chosenCells.size()==0){
			return 0;
		}
		chosenLettersScore =  CalculateLocalScore.calculateWordScore(this.getWord(), this.getWord().length());
		return chosenLettersScore;
	}
	/**get the chosenCellsString attribute 
	 * @return
	 */
	public String getChosenCellsXMLString() {
		String chosenCellsString = "";
		for (Cell cell : chosenCells) {
			chosenCellsString += String.format("<cell position='%s,%s' letter='%s'/>",
					String.valueOf(cell.getCol()), String.valueOf(cell.getRow()), cell.getLetter());
		}
		return chosenCellsString;
	}
	/**get the word attribute 
	 * @return
	 */
	public String getWord(){
		String word = "";
		for(Cell cell : chosenCells){
			word+=cell.getLetter();
		}
		return word;
	}

}
