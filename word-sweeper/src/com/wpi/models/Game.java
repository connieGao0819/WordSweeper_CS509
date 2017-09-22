package com.wpi.models;

import java.awt.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
/**
 * Game entity class, which contains all the info and functions about the game.  
 * 
 * @author Haozhe Zhang,Jiani Gao
 *
 */
public class Game {
	private String gameID;
	private String password;
	private Map<String, Integer> playersInfoMap;
	private Map<String, String> playersBoardPositionMap;
	private boolean isLocked;
	private String manager;
	
	/**get the manager attribute 
	 * @return
	 */
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Game(String password){
		this.password = password;
		playersInfoMap = new HashMap<String, Integer>();;
		playersBoardPositionMap = new HashMap<String, String>();
	}
	
	public Game(String id, String password) {
		this.password = password;
		gameID = id;
		playersInfoMap = new HashMap<String, Integer>();;
		playersBoardPositionMap = new HashMap<String, String>();
	}
	/**get the gameID attribute 
	 * @return
	 */
	public String getGameID() {
		return gameID;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}
	/**get the password attribute 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	/**get the playersInfoMap attribute 
	 * @return
	 */
	public Map<String, Integer> getPlayersInfoMap() {
		return playersInfoMap;
	}

	public void setPlayersInfoMap(Map<String, Integer> playersInfoMap) {
		this.playersInfoMap = playersInfoMap;
	}
	/**get the playersBoardPositionMap attribute 
	 * @return
	 */
	public Map<String, String> getPlayersBoardPositionMap() {
		return playersBoardPositionMap;
	}

	public void setPlayersBoardPositionMap(Map<String, String> playersBoardPositionMap) {
		this.playersBoardPositionMap = playersBoardPositionMap;
	}
	/**get the boolean of whether the game is locked
	 * @return islocked
	 */
	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	/**add the player's name and score into the InfoMap.
	
	 */
	public void addPlayerScore(String name, Integer score){
		playersInfoMap.put(name, score);
	}
	/**get the Player's score attribute 
	 * @return
	 */
	public int getPlayerScore(String name){
		return playersInfoMap.get(name);
	}
	/**add the player's name and position into the InfoMap.
	 * @return
	 */
	public void addPlayerPosition(String name, String pos){
		playersBoardPositionMap.put(name, pos);
	}
	/**get the PlayersBoardPosition attribute 
	 * @return
	 */
	public String getPlayerPosition(String name){
		return playersBoardPositionMap.get(name);
	}
}
