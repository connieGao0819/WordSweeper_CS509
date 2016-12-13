package com.wpi.client.controller.responseController;

import com.wpi.models.Model;
import com.wpi.xml.Message;

public class ExitGameResponseController extends ControllerChain {


	public ExitGameResponseController() {
		super();
	}

	@Override
	public boolean process(Message response) {

		System.out.println("Response::" + response.toString());

		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("exitGameResponse")) {
			return next.process(response);
		}
		Model.existedGame = false;
		System.exit(0);
		return true;
	}
}
