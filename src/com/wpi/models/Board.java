package com.wpi.models;

import java.util.ArrayList;
import java.util.List;

import com.wpi.service.CalculateLocalScore;

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
	


	
	public Board(List<Cell> cells, int x, int y,int size){
		this.cells = cells;
		chosenCells = new ArrayList<Cell>();
		globalStartingCol = y;
		globalStartingRow = x;
		chosenLettersScore = 0;
		up = x-1;
		down = size-x-3;
		left = y-1;
		right = size-y-3;
	}

	public int getGlobalStartingRow() {
		return globalStartingRow;
	}

	public void setGlobalStartingRow(int globalStartingRow) {
		this.globalStartingRow = globalStartingRow;
	}
	
	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	public List<Cell> getChosenCells() {
		return chosenCells;
	}

	public void setChosenCells(List<Cell> chosenCells) {
		this.chosenCells = chosenCells;
	}

	public int getGlobalStartingCol() {
		return globalStartingCol;
	}

	public void setGlobalStartingCol(int globalStartingCol) {
		this.globalStartingCol = globalStartingCol;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public Integer getChosenLettersScore() {
		if(chosenCells.size()==0){
			return 0;
		}
		for(Cell cell: chosenCells){
			chosenLettersScore+=cell.getScore();
		}
		return chosenLettersScore;
	}



}
