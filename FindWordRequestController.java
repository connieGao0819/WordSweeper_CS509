package com.wpi.controller;

import com.wpi.layout.GameLayout;
import com.wpi.models.Model;
import com.wpi.xml.Message;

public class FindWordRequestController {
	
	public GameLayout app;
	public Model model;
	
	public FindWordRequestController(GameLayout a, Model m) {
		this.app = a;
		this.model = m;
	}
	/** Make the request on the server and wait for response. */
	public void process() {
		
		String chosenCellsInfoXMLString = model.getBoard().getChosenCellsXMLString();
		String gameID = model.getGame().getGameID();
		String name = model.getPlayer().getName();
		String word = model.getBoard().getWord().getSpell();
		
		String xmlString = Message.requestHeader() + String.format("<findWordRequest gameId='%s' name='%s' word='%s'>" + gameID + name + word + chosenCellsInfoXMLString + "</findWordRequest></request>" );
		
		System.out.println(xmlString);
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);

   }
}
