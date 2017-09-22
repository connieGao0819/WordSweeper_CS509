package com.wpi.client.controller.requestController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

/**
 * When the player clicks "reset" button, a resetGameRequest will be sent to the
 * server.
 * <p>
 * The {@link #process()} makes a resetGameRequest in XML format, and send it to
 * the server.
 * 
 * @author Jiani Gao,Haozhe Zhang
 *
 */
public class ResetGameController {


	public ResetGameController() {
	}

	/** Make a resetGameRequest in XML format, and send it to the server. */
	public void process() {

		String xmlString = Message.requestHeader()
				+ String.format("<resetGameRequest gameId='%s'/></request>", Model.GAME.getGameID());

		Message m = new Message(xmlString);
		Model.serverAccess.sendRequest(m);
	}
}
