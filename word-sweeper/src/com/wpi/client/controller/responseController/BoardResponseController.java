package com.wpi.client.controller.responseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.wpi.layout.GameLayout;
import com.wpi.models.Board;
import com.wpi.models.Cell;
import com.wpi.models.Model;
import com.wpi.service.CellsService;
import com.wpi.xml.Message;


/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT.
 * This will never be returned to a client to tell him that HE has the model
 * locked (that is job of LockResponse).
 * @author haozhezhang,Jiani Gao
 */
public class BoardResponseController extends ControllerChain {

//	private boolean flag;
	private CellsService cs=null;

	public BoardResponseController() {
		super();
//		this.flag = false;
	}

	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("boardResponse")) {
			return next.process(response);
		}
		Model.existedGame = true;
		// this refers to the outer node of the Message DOM (in this case,
		// updateResponse).
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		String gameId = map.getNamedItem("gameId").getNodeValue();
		Model.GAME.setGameID(gameId);
		String managingUser = map.getNamedItem("managingUser").getNodeValue();
		Model.GAME.setManager(managingUser);
		String bonusCell = map.getNamedItem("bonus").getNodeValue();
		if(managingUser.equals(Model.PLAYER.getName())){
			Model.PLAYER.setAsManager(true);
		}
		NodeList list = boardResponse.getChildNodes();
		String[] loca = bonusCell.split(",");
		int xbonus = Integer.valueOf(loca[1]);
		int ybonus = Integer.valueOf(loca[0]);
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			String pname = n.getAttributes().getNamedItem("name").getNodeValue();
			String boardInfo = n.getAttributes().getNamedItem("board").getNodeValue();
			String plocation = n.getAttributes().getNamedItem("position").getNodeValue();
			String[] corRowArray = plocation.split(",");
			Integer globalStartingCol = Integer.valueOf(String.valueOf(corRowArray[0]));
			Integer globalStartingRow = Integer.valueOf(String.valueOf(corRowArray[1]));
			Integer score = Integer.valueOf(n.getAttributes().getNamedItem("score").getNodeValue());
			Model.GAME.addPlayerScore(pname, score);
			Model.GAME.addPlayerPosition(pname, plocation);
			if (list.getLength() == 1){
				String[] letters = boardInfo.split(",");
				cs = new CellsService(globalStartingRow, globalStartingCol, xbonus, ybonus);
		        cs.setCellNum(letters);
				List<Cell> cells = cs.getCells();
				Board board = new Board(cells, globalStartingRow, globalStartingCol, 7, xbonus, ybonus);
				Model.BOARD = board;
				Model.PLAYER.setName(pname);
				Model.PLAYER.setScore(score);
				Model.BOARD.setXbonus(xbonus);
				Model.BOARD.setYbonus(ybonus);
			}
			else if (pname.equals(Model.PLAYER.getName())) {
				String[] letters = boardInfo.split(",");
				cs = new CellsService(globalStartingRow, globalStartingCol, xbonus, ybonus);
		        cs.setCellNum(letters);
				List<Cell> cells = cs.getCells();
				Board board = new Board(cells, globalStartingRow, globalStartingCol, 7, xbonus, ybonus);
				Model.BOARD = board;
				Model.PLAYER.setName(pname);
				Model.PLAYER.setScore(score);
				Model.BOARD.setXbonus(xbonus);
				Model.BOARD.setYbonus(ybonus);
			}

		}
		for(String key : Model.GAME.getPlayersBoardPositionMap().keySet()){
			if(!Model.PLAYER.getName().equals(key)){
				String[] uloca = Model.GAME.getPlayersBoardPositionMap().get(key).split(",");
				int x = Integer.valueOf(uloca[1]);
				int y = Integer.valueOf(uloca[0]);
				cs.setRepetition(x, y);
			}
		}
		Model.status=1;
		Model.gameLayout.setScoreLabel();
		Model.gameLayout.setCellLabel();
		return true;
	}

}
