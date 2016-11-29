package com.wpi.models;

import com.wpi.client_src.ServerAccess;

public class Model {
		
		public static Game GAME;
		public static Board BOARD;
		public static Player PLAYER;
		public static ServerAccess serverAccess;
		public static String IP = "localhost";
		public static int PORT = 11425; 

	   	


		
//		public void updateInfo(String gameID, String managingUser, String playerName, int newStartingCol, int newStaringRow, 
//								String boardInfo, long score)
//		{
//			this.game.setGameID(gameID);
//			this.player.setName(playerName);
//			this.player.setScore(score);
//			this.game.setManagingUser(managingUser);
//			if(managingUser.equals(this.player.getName())){
//				this.player.setAsManager();
//			}
//			this.board.updateBoard(newStartingCol, newStaringRow, boardInfo);
//			this.board.setRequestColChange(0);
//			this.board.setRequestRowChange(0);
//		}
//
//		public Game getGame() {
//			return game;
//		}
//
//		public void setGame(Game game) {
//			this.game = game;
//		}
//
//		public Board getBoard() {
//			return board;
//		}
//
//		public void setBoard(Board board) {
//			this.board = board;
//		}
//
//		public Player getPlayer() {
//			return player;
//		}
//
//		public void setPlayer(Player player) {
//			this.player = player;
//		}
//		
//		public void resetGame(){
//			this.getPlayer().resetPlayerScore();
//			this.getBoard().empltyChosenCells();
//		}
}
