package com.wpi.controller;

import com.wpi.layout.GameLayout;
import com.wpi.models.Model;
import com.wpi.xml.Message;

public class ResetGameRequestController {
	GameLayout app;
	Model model;
	
	public ResetGameRequestController(GameLayout app, Model model) {
		this.app = app;
		this.model = model;
	}
	/** Make the request on the server and wait for response. */
	public void process() {
		
		String xmlString = Message.requestHeader() + String.format("<resetGameRequest gameId='%s'/></request>", model.getGame().getGameID());			
		System.out.println(xmlString);
		Message m = new Message (xmlString);
		// Request the lock (this might not succeed).
		
		//app.getRequestArea().append(m.toString());
		//app.getRequestArea().append("\n");
		app.getServerAccess().sendRequest(m);
	}
}
