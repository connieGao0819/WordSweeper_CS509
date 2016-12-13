package com.wpi.client.controller.responseController;

import com.wpi.xml.Message;

public final class EmptyHandler extends ControllerChain {

	@Override
	public boolean process(Message response) {
		System.err.println("Not Handled:" + response);
		return true;
	}

}
