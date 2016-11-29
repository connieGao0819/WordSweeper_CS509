package com.wpi.controller;


import com.wpi.xml.Message;
import com.wpi.layout.HomeLayout;
import com.wpi.models.Model;

public class CreateGameController {

	HomeLayout app;

	public CreateGameController(HomeLayout app) {
		this.app = app;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		String xmlString;
		if(Model.GAME.getPassword() == null){
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s'></request>", Model.PLAYER.getName());		
		}else{
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s' password='%s'/></request>", Model.PLAYER.getName(), Model.GAME.getPassword());
		}
		
		Message m = new Message (xmlString);
		// Request the lock (this might not succeed).
		//app.getRequestArea().append(m.toString());
		//app.getRequestArea().append("\n");
		Model.serverAccess.sendRequest(m);
	}
}
