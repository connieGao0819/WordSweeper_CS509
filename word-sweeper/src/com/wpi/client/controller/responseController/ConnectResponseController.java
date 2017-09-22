package com.wpi.client.controller.responseController;

import com.wpi.xml.Message;
/**
 * Connect response information sent from server should be received once a player is trying to connect to the server.
 * This class deals with the connect response information based on xml transmission protocol.
 * 
 * The {@link #process(Message)}} returns true if the connection is successful.
 * @author haozhezhang,Jiani Gao
 *
 */
public class ConnectResponseController extends ControllerChain {

	public ConnectResponseController() {
		super();
	}

	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("connectResponse")) {
			return next.process(response);
		}

		
		return true;
	}

}
