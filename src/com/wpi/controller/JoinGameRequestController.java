package com.wpi.controller;


import com.wpi.xml.Message;
import com.wpi.models.Model;
import com.wpi.layout.HomeLayout;

public class JoinGameRequestController {

	HomeLayout app;
	Model model;

	public JoinGameRequestController(HomeLayout app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		String xmlString;
		if(Model.GAME.getPassword() == null){
			xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s'/></request>", model.GAME.getGameID(), Model.PLAYER.getName());
		}else{
			xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s' password='%s'/></request>",model.GAME.getGameID(), Model.PLAYER.getName(),Model.GAME.getPassword());
		}

		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
		Model.serverAccess.sendRequest(m);
	}
}
