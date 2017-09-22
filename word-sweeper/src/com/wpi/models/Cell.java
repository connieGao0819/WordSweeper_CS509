package com.wpi.models;
/**
 * Cell entity class, which contains all the info and functions about the cell.  
 * 
 * @author Haozhe Zhang,Jiani Gao
 *
 */

public class Cell {
	
	private String letter;
	private Integer score;
	private boolean chosen;
	private boolean repetition;
	private Integer row;
	private Integer col;
	private boolean bonus;
	
	public boolean isBonus() {
		return bonus;
	}
	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}
	public boolean isRepetition() {
		return repetition;
	}
	public void setRepetition(boolean repetition) {
		this.repetition = repetition;
	}

	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public boolean isChosen() {
		return chosen;
	}
	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getCol() {
		return col;
	}
	public void setCol(Integer col) {
		this.col = col;
	}
	

}
