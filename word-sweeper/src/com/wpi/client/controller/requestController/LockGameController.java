package com.wpi.client.controller.requestController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

/**
 * When the player clicks "lock" button, a lockGameRequest will be sent to the
 * server.
 * <p>
 * The {@link #process()} makes a lockGameRequest in XML format, and send it to
 * the server.
 * 
 * @author Jiani Gao,Haozhe Zhang
 *
 */
public class LockGameController {

	public LockGameController() {
	}

	/** Make a lockGameRequest in XML format, and send it to the server. */
	public void process() {

		String xmlString = Message.requestHeader()
				+ String.format("<lockGameRequest gameId='%s'/></request>", Model.GAME.getGameID());

		Message m = new Message(xmlString);
		Model.serverAccess.sendRequest(m);
	}
}
