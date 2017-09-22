package com.wpi.client.controller.responseController;

import com.wpi.models.Model;
import com.wpi.xml.Message;
/**
 * An exit game response information should be received once a player is trying to exit the game.
 * This handles the exit game response information
 * 
 * The {@link #process(Message)}} updates the isWaitingResponse and existedGame information in entity classes, and returns the boundary from game GUI to the login GUI.
 * 
 * @author haozhezhang
 *
 */
public class ExitGameResponseController extends ControllerChain {


	public ExitGameResponseController() {
		super();
	}

	@Override
	public boolean process(Message response) {

		System.out.println("Response::" + response.toString());

		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("exitGameResponse")) {
			return next.process(response);
		}
		Model.existedGame = false;
		System.exit(0);
		return true;
	}
}
