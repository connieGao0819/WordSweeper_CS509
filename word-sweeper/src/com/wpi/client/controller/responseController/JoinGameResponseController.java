package com.wpi.client.controller.responseController;

import javax.swing.JOptionPane;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.wpi.models.Model;
import com.wpi.xml.Message;


public class JoinGameResponseController extends ControllerChain {

	@Override
	public boolean process(Message response) {

		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("joinGameResponse")) {
			return next.process(response);
		}

		if (response.contents.getAttributes().getNamedItem("success").getNodeValue().equals("false")) {
			Model.status = 4;
			String reason = response.contents.getAttributes().getNamedItem("reason").getNodeValue();
			JOptionPane.showMessageDialog(null, reason, "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		} else{
			Model.status = 3;
			Model.existedGame = true;
		}
		System.out.println(response.toString());
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		String gameId = map.getNamedItem("gameId").getNodeValue();
		Model.GAME.setGameID(gameId);

		return true;
	}

}
