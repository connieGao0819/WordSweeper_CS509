package com.wpi.client.controller.requestController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

/**
 * When the player clicks "quit" button, an exitGameRequest will be sent to the
 * server.
 * <p>
 * The {@link #process()} makes an exitGameRequest in XML format, and send it to
 * the server.
 * 
 * @author HanBao
 *
 */
public class ExitGameController {


	public ExitGameController() {
	}

	/** Make an exitGameRequest in XML format, and send it to the server. */
	public void process() {

		String xmlString = Message.requestHeader() + String.format("<exitGameRequest name='%s' gameId='%s'/></request>",
				Model.PLAYER.getName(), Model.GAME.getGameID());

		Message m = new Message(xmlString);
		Model.serverAccess.sendRequest(m);
	}
}
