package com.wpi.controller;

import com.wpi.layout.GameLayout;
import com.wpi.models.Model;
import com.wpi.xml.Message;

public class RepositionBoardController {
	
	GameLayout app;
	Model model;

	public RepositionBoardController(GameLayout app, Model model) {
		this.app = app;
		this.model = model;
	}
	/** Make the request on the server and wait for response. */
	public void process() {
	
		String xmlString = Message.requestHeader() + String.format("<repositionBoardRequest name='%s' gameId='%s'", 
							model.PLAYER.getName(), model.GAME.getGameID()) + 
							" rowChange='"+ model.BOARD.getGlobalStartingRow() +
							"' colChange='" + model.BOARD.getGlobalStartingCol() + "'/></request>";
		
		Message m = new Message (xmlString);
		//app.getRequestArea().append(m.toString());
		//app.getRequestArea().append("\n");
		Model.serverAccess.sendRequest(m);		
	}	

}
