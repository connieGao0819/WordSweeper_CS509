package com.wpi.client.controller.requestController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

/**
 * When the player clicks "submit" button, a findWordRequest will be sent to the
 * server.
 * <p>
 * The {@link #process()} makes a findWordRequest in XML format, and send it to
 * the server.
 * 
 * @author Jiani Gao,Haozhe Zhang
 *
 */
public class FindWordController {

	public FindWordController() {
	}

	/** Make a findWordRequest in XML format, and send it to the server. */
	public void process() {

		String chosenCellsInfoXMLString = Model.BOARD.getChosenCellsXMLString();

		String xmlString = Message.requestHeader()
				+ String.format("<findWordRequest gameId='%s' name='%s' word='%s'>", Model.GAME.getGameID(),
						Model.PLAYER.getName(), Model.WORD.getSpell())
				+ chosenCellsInfoXMLString + "</findWordRequest></request>";
		System.out.println(xmlString);
		Message m = new Message(xmlString);
		Model.serverAccess.sendRequest(m);
	}
}
