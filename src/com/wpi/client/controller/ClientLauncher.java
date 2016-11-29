package com.wpi.client.controller;
import com.wpi.layout.HomeLayout;
import com.wpi.client_src.ServerAccess;
import com.wpi.controller.SampleClientMessageHandler;
import com.wpi.models.Model;
import com.wpi.xml.Message;

public class ClientLauncher {
 // If requested by ClientLauncher (pass in '-server' as argument).
// 	public static final String serverHost = "72.249.186.243";
// 	public static ServerAccess SA = null;

 	public static void main(String[] args) throws Exception {
 		// FIRST thing to do is register the protocol being used. There will be a single class protocol
 		// that will be defined and which everyone will use. For now, demonstrate with skeleton protocol.
 		
 		// Initialize the client application and its corresponding model
 		HomeLayout app = new HomeLayout();
 		app.setLayout();
        app.addListener();
 	}
}
