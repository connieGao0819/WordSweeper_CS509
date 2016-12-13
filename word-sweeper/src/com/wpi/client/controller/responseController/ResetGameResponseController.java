package com.wpi.client.controller.responseController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

public class ResetGameResponseController extends ControllerChain {


	public ResetGameResponseController() {
		super();
	}

	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("resetGameResponse")) {
			return next.process(response);
		}

		// app.getResponseArea().append(response.toString() + "\n");
		Model.BOARD.clearChosenCells();
		Model.PLAYER.resetPlayerScore();
		return true;
	}
}
