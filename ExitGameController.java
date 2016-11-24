package com.wpi.controller;

import com.wpi.layout.HomeLayout;
import com.wpi.models.Model;
import com.wpi.xml.Message;

public class ExitGameController {
	HomeLayout app;
	Model model;
	
	public ExitGameController(HomeLayout app, Model model) {
		this.app = app;
		this.model = model;
	
    }

	/** Make the request on the server and wait for response. */
	public void process() {
		String xmlString = Message.requestHeader() + String.format("<exitGameRequest name='%s' gameID='%s'/></request>", model.getPlayer().getName(),model.getGame().getGameID());
		Message m = new Message (xmlString);
		
		// Request the lock (this might not succeed).
		app.getServerAccess().sendRequest(m);
	}
}
