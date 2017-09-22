package com.wpi.client.controller.responseController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

public class LockGameResponseController extends ControllerChain {


	public LockGameResponseController() {
		super();
	}

	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("lockGameResponse")) {
			return next.process(response);
		}

		// app.getResponseArea().append(response.toString() + "\n");
		Model.GAME.setLocked(true);
		return true;
	}

}
