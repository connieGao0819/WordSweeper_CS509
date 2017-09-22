package com.wpi.client.model;

import com.wpi.xml.Message;

public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(Message response);
}