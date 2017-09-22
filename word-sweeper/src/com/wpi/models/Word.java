package com.wpi.models;

import java.util.List;
/**
 * Word entity class, which contains all the info and functions about the word.  
 * 
 * @author Haozhe Zhang,Jiani Gao
 *
 */
public class Word {
    
    private String spell = "";
    private int score = 0;;
    
    /**get the spell attribute 
	 * @return
	 */
	public String getSpell() {
		return spell;
	}
	public void setSpell(String spell) {
		this.spell = spell;
	}
	/**get the score attribute 
	 * @return
	 */
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
    
    
    
}
