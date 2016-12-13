package com.wpi.client.controller.requestController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

/**
 * When the player clicks "Create Game" button, a createGameRequest will be sent
 * to the server.
 * <p>
 * The {@link #process()} makes a createGameRequest in XML format, and send it
 * to the server.
 * 
 * @author HanBao
 *
 */
public class CreateGameController {



	/** Make a createGameRequest in XML format, and send it to the server. */
	public void process() {

		String xmlString;

		if (Model.GAME.getPassword() == null) {// No password.
			xmlString = Message.requestHeader()
					+ String.format("<createGameRequest name='%s'/></request>", Model.PLAYER.getName());
		} else {// There is a password.
			xmlString = Message.requestHeader()
					+ String.format("<createGameRequest name='%s' password='%s'/></request>", Model.PLAYER.getName(),
							Model.GAME.getPassword());
		}

		Message m = new Message(xmlString);
		Model.serverAccess.sendRequest(m);

		Model.GAME.setLocked(false);// reset the lock flag

	}
}
