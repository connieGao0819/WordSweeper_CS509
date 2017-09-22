package com.wpi.client.controller.responseController;

import javax.swing.JOptionPane;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.wpi.models.Model;
import com.wpi.xml.Message;
/**
 * An exit game response information should be received once a player is trying to exit the game.
 * This handles the exit game response information
 * 
 * The {@link #process(Message)}} updates the isWaitingResponse and existedGame information in entity classes, and returns the boundary from game GUI to the login GUI.
 * 
 * @author haozhezhang，Jiani Gao
 *
 */

public class FindWordResponseController extends ControllerChain {


	public FindWordResponseController() {
		super();
	}

	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("findWordResponse")) {
			return next.process(response);
		}
		if (response.contents.getAttributes().getNamedItem("success").getNodeValue().equals("false")) {
			Model.WORD.setScore(0);
			String reason = response.contents.getAttributes().getNamedItem("reason").getNodeValue();
			JOptionPane.showMessageDialog(null, reason, "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();

		String gameId = map.getNamedItem("gameId").getNodeValue();
		String score = map.getNamedItem("score").getNodeValue();
		String pname = map.getNamedItem("name").getNodeValue();

		// app.getResponseArea().append("Board Message received for game:" +
		// boardResponse.toString() + "\n");
		Model.WORD.setScore(Integer.valueOf(score));
		JOptionPane.showMessageDialog(null, "Good Job", "Warning", JOptionPane.WARNING_MESSAGE);
		return true;
	}
}
