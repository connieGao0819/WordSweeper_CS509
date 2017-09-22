package com.wpi.client.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.wpi.client.controller.requestController.CreateGameController;
import com.wpi.layout.GameLayout;
import com.wpi.models.Game;
import com.wpi.models.Model;
import com.wpi.models.Player;
import com.wpi.server.controller.test.MockServerAccess;
import com.wpi.xml.Message;


public class TestCreateGameController {
	
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
	public void TestCreateGameProcess()
	{
		//test create game process without password
		String player_name = "player1";
		Model.PLAYER.setName(player_name);
		CreateGameController cgame=new CreateGameController();
		cgame.process();
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		assertEquals("createGameRequest", r.contents.getFirstChild().getLocalName());
		assertEquals(player_name, r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		
		//test create game process with password
		String password="abc";
		String name="player2";
		Model.PLAYER.setName(name);
		Model.GAME.setPassword(password);
		CreateGameController cgame2=new CreateGameController();
		cgame2.process();
		ArrayList<Message> reqs2 = mockServer.getAndClearMessages();
		assertTrue(reqs2.size() == 1);
		Message r2 = reqs2.get(0);
		assertEquals("createGameRequest", r2.contents.getFirstChild().getLocalName());
		assertEquals(name, r2.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals(password, r2.contents.getFirstChild().getAttributes().getNamedItem("password").getNodeValue());
	}
}
