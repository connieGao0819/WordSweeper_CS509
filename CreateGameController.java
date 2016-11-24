package com.wpi.controller;


import com.wpi.xml.Message;
import com.wpi.models.Model;
import com.wpi.layout.HomeLayout;

public class CreateGameController {

	HomeLayout app;
	Model model;

	public CreateGameController(HomeLayout app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		String xmlString;
		if(this.app.getPassword() == null){
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s'></request>", this.app.getName());		
		}else{
			xmlString = Message.requestHeader() + String.format("<createGameRequest name='%s' password='%s'/></request>", this.app.getName(), this.app.getPassword());
		}
		
		Message m = new Message (xmlString);
		// Request the lock (this might not succeed).
		//app.getRequestArea().append(m.toString());
		//app.getRequestArea().append("\n");
		app.getServerAccess().sendRequest(m);
	}
}
