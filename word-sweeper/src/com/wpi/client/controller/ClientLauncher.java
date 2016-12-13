package com.wpi.client.controller;
import com.wpi.layout.GameLayout;
import com.wpi.layout.HomeLayout;
import com.wpi.client.controller.responseController.BoardResponseController;
import com.wpi.client.controller.responseController.ConnectResponseController;
import com.wpi.client.controller.responseController.ExitGameResponseController;
import com.wpi.client.controller.responseController.FindWordResponseController;
import com.wpi.client.controller.responseController.JoinGameResponseController;
import com.wpi.client.controller.responseController.LockGameResponseController;
import com.wpi.client.controller.responseController.ResetGameResponseController;
import com.wpi.client.controller.responseController.SampleClientMessageHandler;
import com.wpi.client.model.ServerAccess;
import com.wpi.models.Model;
import com.wpi.xml.Message;

public class ClientLauncher {


 	public static void main(String[] args) throws Exception {
 		// FIRST thing to do is register the protocol being used. There will be a single class protocol
 		// that will be defined and which everyone will use. For now, demonstrate with skeleton protocol.
 		
 		// Initialize the client application and its corresponding model
 		if (!Message.configure("wordsweeper.xsd")) {
 			System.exit(0);
 		}
		GameLayout gameLayout = new GameLayout();
		Model.gameLayout = gameLayout;
		Model.serverAccess = new ServerAccess(Model.IP, Model.PORT);
		SampleClientMessageHandler  handler = new SampleClientMessageHandler();
		handler.registerHandler(new BoardResponseController());
		handler.registerHandler(new ConnectResponseController());
		handler.registerHandler(new JoinGameResponseController());
		handler.registerHandler(new ResetGameResponseController());
		handler.registerHandler(new LockGameResponseController());
		handler.registerHandler(new ExitGameResponseController());
		handler.registerHandler(new FindWordResponseController());
		if (!Model.serverAccess.connect(handler)) {
			System.out.println("Unable to connect to server (" + Model.IP + "). Exiting.");
			System.exit(0);
		}
		System.out.println("Connected to " + Model.IP);
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		Message m = new Message(xmlString);
		Model.serverAccess.sendRequest(m);
 		HomeLayout app = new HomeLayout();
 		Model.homeLayout = app;
 		app.setLayout();
        app.addListener();
 	}
}
