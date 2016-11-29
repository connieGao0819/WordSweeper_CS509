package com.wpi.models;

import java.awt.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Game {
	private String gameID;
	private String password;
	private Map<String, Integer> playersInfoMap;
	private Map<String, String> playersBoardPositionMap;
	private boolean isLocked;
	
	public Game(String id, String password) {
		this.password = password;
		gameID = id;
		playersInfoMap = new HashMap<String, Integer>();;
		playersBoardPositionMap = new HashMap<String, String>();
	}

	public String getGameID() {
		return gameID;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Integer> getPlayersInfoMap() {
		return playersInfoMap;
	}

	public void setPlayersInfoMap(Map<String, Integer> playersInfoMap) {
		this.playersInfoMap = playersInfoMap;
	}

	public Map<String, String> getPlayersBoardPositionMap() {
		return playersBoardPositionMap;
	}

	public void setPlayersBoardPositionMap(Map<String, String> playersBoardPositionMap) {
		this.playersBoardPositionMap = playersBoardPositionMap;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	
	/*public String getPlayersListByJoinTime(){
		String allPlayersList = "";
		int i = 1;
		for(Map.Entry<String, Integer> playerInfoSet : playersInfoMap.entrySet()){
			allPlayersList += (String.format("  %s\t", String.valueOf(i++)) + playerInfoSet.getKey() + "\t  " + playerInfoSet.getValue().toString() + "\n");
		}
		System.out.println(allPlayersList);
		return allPlayersList;
	}
	
	public String getPlayersListByScore(){
		String allPlayersInfoSortedByScore = "";
		
	    List<Entry<String, Integer>> allPlayersListSortedByScore = new LinkedList<>(this.playersInfoMap.entrySet());
	    Collections.sort(allPlayersListSortedByScore, new Comparator<Object>() {
	        @Override
			@SuppressWarnings("unchecked")
	        public int compare(Object o1, Object o2) {
	            return ((Comparable<Integer>) ((Map.Entry<String, Integer>) (o1)).getValue()).compareTo(((Map.Entry<String, Integer>) (o2)).getValue());
	        }
	    });
	    
	    for(int i = 0; i < allPlayersListSortedByScore.size(); i++){
	    	allPlayersInfoSortedByScore += (String.format("  %s\t", String.valueOf(i+1)) + 
	    			allPlayersListSortedByScore.get(i).getKey() + "\t  " + 
	    			allPlayersListSortedByScore.get(i).getValue().toString() + "\n");
	    }
		
		return allPlayersInfoSortedByScore;		
	}
	
	  public String getPlayersListByName(){
		String allPlayersInfoSortedByName = "";
		
	    List<Entry<String, Integer>> allPlayersListSortedByScore = new LinkedList<>(this.playersInfoMap.entrySet());
	    Collections.sort(allPlayersListSortedByScore, new Comparator<Object>() {
	        @Override
			@SuppressWarnings("unchecked")
	        public int compare(Object o1, Object o2) {
	            return ((Comparable<String>) ((Map.Entry<String, Integer>) (o1)).getKey()).compareTo(((Map.Entry<String, Integer>) (o2)).getKey());
	        }
	    });
	    
	    for(int i = 0; i < allPlayersListSortedByScore.size(); i++){
	    	allPlayersInfoSortedByName += (String.format("  %s\t", String.valueOf(i+1)) + 
	    			allPlayersListSortedByScore.get(i).getKey() + "\t  " + 
	    			allPlayersListSortedByScore.get(i).getValue().toString() + "\n");
	    }
		
		return allPlayersInfoSortedByName;		
	}

	public Map<String, String> getPlayersPositionMap() {
		return playersBoardPositionMap;
	}

	public void setPlayersPositionMap(Map<String, String> playersPositionMap) {
		this.playersBoardPositionMap = playersPositionMap;
	}*/
}
