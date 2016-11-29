package com.wpi.service;

import com.wpi.client_src.ServerAccess;
import com.wpi.controller.SampleClientMessageHandler;
import com.wpi.models.Model;
import com.wpi.xml.Message;

public class ConnectService {

	
	public void connect(){
 		Model.serverAccess = new ServerAccess(Model.IP, Model.PORT);
 		if (!Model.serverAccess.connect(new SampleClientMessageHandler())) {
 			System.out.println("Unable to connect to server (" + Model.IP + "). Exiting.");
 			System.exit(0);
 		}
 		System.out.println("Connected to " + Model.IP);
 		
 		
 		// Should we on the client ever need to communicate with the server, we need this ServerAccess
 		// object.
 		
 		// send an introductory connect request now that we have created (but not made visible!)
 		// the GUI
 		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
 		Message m = new Message (xmlString);
 		Model.serverAccess.sendRequest(m);
	}
}
