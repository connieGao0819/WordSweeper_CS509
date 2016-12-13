package com.wpi.client.controller.requestController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

/**
 * When the player clicks any direction button around the board, a
 * repositionBoardRequest will be sent to the server.
 * <p>
 * The {@link #process()} makes a repositionBoardRequest in XML format, and send
 * it to the server.
 * 
 * @author HanBao
 *
 */
public class RepositionBoardController {

	public RepositionBoardController() {
	}

	/**
	 * Make a repositionBoardRequest in XML format, and send it to the server.
	 */
	public void process() {

		String xmlString = Message.requestHeader()
				+ String.format("<repositionBoardRequest name='%s' gameId='%s'", Model.PLAYER.getName(),
						Model.GAME.getGameID())
				+ " rowChange='" + Model.BOARD.getRowChange() + "' colChange='"
				+ Model.BOARD.getColChange() + "'/></request>";

		Message m = new Message(xmlString);
		Model.serverAccess.sendRequest(m);
	}
}
