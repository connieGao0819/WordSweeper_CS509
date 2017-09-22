package com.wpi.client.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.wpi.client.controller.requestController.FindWordController;
import com.wpi.layout.GameLayout;
import com.wpi.models.Board;
import com.wpi.models.Cell;
import com.wpi.models.Game;
import com.wpi.models.Model;
import com.wpi.models.Player;
import com.wpi.server.controller.test.MockServerAccess;
import com.wpi.xml.Message;


public class TestFindWordController {
	MockServerAccess mockServer = new MockServerAccess("localhost");
	GameLayout gameLayout = new GameLayout();
	Player player = new Player("player1");
	Game game = new Game("game1","1");
	Board board = new Board();
	
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
		Model.BOARD = board;
		Model.gameLayout.setLayout();
		Model.gameLayout.addListener();
	}

	@Test
	public void TestFindWordProcess()
	{
		String player_name = "player1";
		String game_id = "exitGame";
		String wordContent="SO";


		Model.PLAYER.setName(player_name);
		Model.GAME.setGameID(game_id);
		Model.WORD.setSpell(wordContent);
		Cell cell1 = new Cell();
		cell1.setChosen(true);
		cell1.setCol(0);
		cell1.setRow(0);
		cell1.setLetter("S");
		Cell cell2 = new Cell();
		cell2.setChosen(true);
		cell2.setCol(1);
		cell2.setRow(0);
		cell2.setLetter("O");
		Model.BOARD.getChosenCells().add(cell1);
		Model.BOARD.getChosenCells().add(cell2);

		
		FindWordController fwc=new FindWordController();
		
		fwc.process();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		
		assertTrue(reqs.size() == 1);
		
		Message r = reqs.get(0);
		assertEquals("findWordRequest", r.contents.getFirstChild().getLocalName());
		assertEquals(player_name, r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals(game_id, r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals(wordContent,r.contents.getFirstChild().getAttributes().getNamedItem("word").getNodeValue());
	}
}
//end of TestFindWordController