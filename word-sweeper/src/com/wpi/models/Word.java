package com.wpi.models;

public class Word {
    
    private String spell;
    private int score;
    private int localScore;
    public String getSpell() {
        return spell;
    }
    public void setSpell(String spell) {
        this.spell = spell;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setlocalScore(Integer localScore){
    	this.localScore=localScore;
    }
    public Integer getlocalScore(){
    	return localScore;
    }
	public void setContent(String chosenCellsLetters) {
		// TODO Auto-generated method stub
		
	}
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
