package com.wpi.client.controller.responseController;

import com.wpi.xml.Message;

public class ConnectResponseController extends ControllerChain {

	public ConnectResponseController() {
		super();
	}

	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("connectResponse")) {
			return next.process(response);
		}

		// app.getResponseArea().append(response.toString() + "\n");
		return true;
	}

}
