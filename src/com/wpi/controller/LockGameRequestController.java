package com.wpi.controller;

import com.wpi.xml.Message;
import com.wpi.models.Model;
import com.wpi.layout.GameLayout;

public class LockGameRequestController {
	
	GameLayout app;
	Model model;
	
	public LockGameRequestController(GameLayout app, Model model) {
		this.app = app;
		this.model = model;
	}
	/** Make the request on the server and wait for response. */
	public void process() {
	
		String xmlString = Message.requestHeader() + String.format("<lockGameRequest gameId='%s'/></request>", model.GAME.getGameID());
		
		Message m = new Message (xmlString);
		//app.getRequestArea().append(m.toString());
		//app.getRequestArea().append("\n");
		Model.serverAccess.sendRequest(m);
	}
}
