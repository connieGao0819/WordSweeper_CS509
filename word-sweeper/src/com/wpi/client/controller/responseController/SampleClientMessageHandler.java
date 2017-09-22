package com.wpi.client.controller.responseController;

import com.wpi.client.model.IMessageHandler;
import com.wpi.xml.Message;

/**
 * Sample implementation of a protocol handler to respond to messages received from the server.
 * You should follow this template when designing YOUR message handler.
 * 
 * Note: This one does nothing more than dump the XML message into the client window. Nothing that special.
 * @author haozhezhang,Jiani Gao
 */
public class SampleClientMessageHandler implements IMessageHandler {

	
	// by default is the empty handler...
	ControllerChain chain = new EmptyHandler();
	
	/**
	 * Register new controller chain as occuring before existing chain.
	 */
	public void registerHandler(ControllerChain handler) {
		handler.next = chain;
		chain = handler;
	}
	
	public SampleClientMessageHandler() {
	}
	
	@Override
	public void process(Message response) {
		chain.process(response);
	}

}
