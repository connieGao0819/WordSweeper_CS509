package com.wpi.models;

public class Model {
		
		private Game game;
		private Board board;
		private Player player;

	   	
		public Model(){
		  this.game = new Game();
		  this.board = new Board();
		  this.player = new Player();
		}


		
		public void updateInfo(String gameID, String administrator, String playerName, int newStartingCol, int newStaringRow, 
								String boardInfo, long score)
		{
			this.game.setGameID(gameID);
			this.player.setName(playerName);
			this.player.setScore(score);
			this.game.setManagingUser(administrator);
			if(administrator.equals(this.player.getName())){
				this.player.setAsManager();
			}
			this.board.updateBoard(newStartingCol, newStaringRow, boardInfo);
			this.board.setRequestColChange(0);
			this.board.setRequestRowChange(0);
		}

		public Game getGame() {
			return game;
		}

		public void setGame(Game game) {
			this.game = game;
		}

		public Board getBoard() {
			return board;
		}

		public void setBoard(Board board) {
			this.board = board;
		}

		public Player getPlayer() {
			return player;
		}

		public void setPlayer(Player player) {
			this.player = player;
		}
		
		public void resetGame(){
			this.getPlayer().resetPlayerScore();
			this.getBoard().empltyChosenCells();
		}
}
