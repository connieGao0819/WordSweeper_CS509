package com.wpi.client.controller.requestController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

/**
 * When the player clicks "Join Game" button, a joinGameRequest will be sent to
 * the server.
 * <p>
 * The {@link #process()} makes a joinGameRequest in XML format, and send it to
 * the server.
 * 
 * @author HanBao
 *
 */
public class JoinGameController {


	/** Make a joinGameRequest in XML format, and send it to the server. */
	public void process() {

		String xmlString;
		if (Model.GAME.getPassword() == null) {
			xmlString = Message.requestHeader() + String.format("<joinGameRequest gameId='%s' name='%s'/></request>",
					Model.GAME.getGameID(), Model.PLAYER.getName());

		} else {
			xmlString = Message.requestHeader()
					+ String.format("<joinGameRequest gameId='%s' name='%s' password='%s'/></request>",
							Model.GAME.getGameID(), Model.PLAYER.getName(), Model.GAME.getPassword());
		}
		Message m = new Message(xmlString);
		Model.serverAccess.sendRequest(m);
	}
}
