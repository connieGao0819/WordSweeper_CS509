package com.wpi.models;
/**
 * Player entity class, which contains all the info and functions about the player.  
 * 
 * @author Haozhe Zhang,Jiani Gao
 *
 */
public class Player {
	 	private String name;
	    private long score;
	    private boolean isManager;
	    
	    /**Player constructor*/
		public Player(String name){
			this.name = name;
			this.score = 0;
			this.isManager = false;
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		public long getScore() {
			return score;
		}
		public void setScore(long score) {
			this.score = score;
		}
		
		public boolean isManager() {
			return isManager;
		}
		/**set the player as a manager player.
		 */
		public void setAsManager(boolean mana){
			this.isManager = mana;
		}
		
		public void resetPlayerScore(){
			this.score = 0;
		}
	}