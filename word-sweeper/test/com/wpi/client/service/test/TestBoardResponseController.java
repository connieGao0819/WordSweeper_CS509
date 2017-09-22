package com.wpi.client.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.wpi.client.controller.responseController.BoardResponseController;
import com.wpi.layout.GameLayout;
import com.wpi.models.Board;
import com.wpi.models.Game;
import com.wpi.models.Model;
import com.wpi.models.Player;
import com.wpi.server.controller.test.MockServerAccess;
import com.wpi.xml.Message;


public class TestBoardResponseController {

	MockServerAccess mockServer = new MockServerAccess("localhost");
	GameLayout gameLayout = new GameLayout();
	Player player = new Player("player1");
	Game game = new Game("game1","1");

	@Before
	public void set() {
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}
		Model.serverAccess = mockServer;
		Model.gameLayout = gameLayout;
		Model.GAME = game;
		Model.PLAYER = player;
		Model.gameLayout.setLayout();
		Model.gameLayout.addListener();
	}

	@Test
	public void testBoardResponseProcess() {
		String name1 = "player1", name2 = "player2";
		int col1 = 4, col2 = 2, row1 = 1, row2 = 2;
		String bonus = "4,3";
		String gameId = "game1";
		String managingUser = name2;
		String board1 = "A,F,E,R,K,S,O,E,R,O,I,E,R,P,O,R";
		String board2 = "E,C,D,R,F,T,G,O,M,I,G,E,R,P,R,T";
		String board11 = "AFERKSOEROIERPOR";
		String pos1 = col1 + "," + row1, pos2 = col2 + "," + row2;
		int score1 = 5, score2 = 10;
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response id=\"someMessageID\" success=\"true\">"
				+ "<boardResponse bonus=\"%s\" gameId=\"%s\" managingUser=\"%s\">"
				+ "<player board=\"%s\" name=\"%s\" position=\"%s\" score=\"%s\"/>"
				+ "<player board=\"%s\" name=\"%s\" position=\"%s\" score=\"%s\"/>" + "</boardResponse></response>";
		xml = String.format(xml, bonus, gameId, managingUser, board1, name1, pos1, score1, board2, name2, pos2, score2);

		Message m = new Message(xml);
		new BoardResponseController().process(m);

		assertTrue(Model.GAME.getPlayerPosition(name1).equals(pos1));
		assertTrue(Model.GAME.getPlayerPosition(name2).equals(pos2));
		assertTrue(Model.BOARD.getXbonus()==Integer.valueOf(bonus.split(",")[1]));
		assertTrue(Model.BOARD.getYbonus()==Integer.valueOf(bonus.split(",")[0]));
		assertEquals(Model.BOARD.getGlobalStartingCol(), col1);
		assertEquals(Model.BOARD.getGlobalStartingRow(), row1);

		assertTrue(Model.GAME.getPlayersInfoMap().containsKey(name1) && game.getPlayersInfoMap().get(name1) == score1);
		assertTrue(Model.GAME.getPlayersInfoMap().containsKey(name2) && game.getPlayersInfoMap().get(name2) == score2);
		assertTrue(Model.GAME.getPlayersInfoMap().size() == 2);

		assertTrue(Model.GAME.getPlayersBoardPositionMap().containsKey(name1)
				&& Model.GAME.getPlayersBoardPositionMap().get(name1).equals(pos1));
		assertTrue(Model.GAME.getPlayersBoardPositionMap().containsKey(name2)
				&& Model.GAME.getPlayersBoardPositionMap().get(name2).equals(pos2));
		assertTrue(Model.GAME.getPlayersBoardPositionMap().size() == 2);

		assertEquals(Model.GAME.getGameID(), gameId);
		assertEquals(Model.GAME.getManager(), name2);

		assertEquals(Model.PLAYER.getName(), name1);
		assertEquals(Model.PLAYER.getScore(), score1);
		assertFalse(Model.PLAYER.isManager());
	}

}
