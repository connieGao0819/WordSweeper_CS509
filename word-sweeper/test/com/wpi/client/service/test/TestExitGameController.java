package com.wpi.client.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.wpi.client.controller.requestController.ExitGameController;
import com.wpi.layout.GameLayout;
import com.wpi.models.Game;
import com.wpi.models.Model;
import com.wpi.models.Player;
import com.wpi.server.controller.test.MockServerAccess;
import com.wpi.xml.Message;



public class TestExitGameController {

	MockServerAccess mockServer = new MockServerAccess("localhost");
	GameLayout gameLayout = new GameLayout();
	Player player = new Player("player1");
	Game game = new Game("game1","1");
	
	@Before
	public void set()
	{
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		Model.serverAccess = mockServer;
		Model.gameLayout = gameLayout;
		Model.GAME = game;
		Model.PLAYER = player;
		Model.gameLayout.setLayout();
		Model.gameLayout.addListener();
	}

	@Test
	public void TestExitGameProcess(){

		// set up model info before actually process
		String player_name = "player1";
		String game_id = "exitGame";
		Model.PLAYER.setName(player_name);
		Model.GAME.setGameID(game_id);
		
		ExitGameController  exit1=new ExitGameController();
		// process
		exit1.process();
		
		// check server whether receiving correct message
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		
		// after getting messages, think of what to test
		//<-- 1. the number of messages should be 1, only one message is sent
		assertTrue(reqs.size() == 1);
		
		//<-- 2. the message label should be exitGameRequest
		//<--	we use get 0 because this is the first and only message should be received
		Message r = reqs.get(0);
		assertEquals("exitGameRequest", r.contents.getFirstChild().getLocalName());
		
		//<-- 3. the message label should have attribute name to be the same name which is set in the model
		assertEquals(player_name, r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		//<-- 4. the message label should have attribute gameId to be the same name which is set in the model
		assertEquals(game_id, r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
	}

}
