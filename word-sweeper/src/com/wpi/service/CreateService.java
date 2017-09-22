package com.wpi.service;

import java.util.ArrayList;
import java.util.List;

import com.wpi.client.controller.requestController.CreateGameController;
import com.wpi.client.controller.responseController.BoardResponseController;
import com.wpi.client.controller.responseController.SampleClientMessageHandler;
import com.wpi.client.model.ServerAccess;
import com.wpi.layout.GameLayout;
import com.wpi.models.Board;
import com.wpi.models.Cell;
import com.wpi.models.Game;
import com.wpi.models.Model;
import com.wpi.models.Player;
import com.wpi.xml.Message;

public class CreateService {

/**
 * Create a new game.
 * @param name
 * @param password
 */
	public void createGame(String name, String password){
		
		Player player = new Player(name);
		player.setAsManager(true);
		Game game = new Game(password);
		Model.GAME = game;
		Model.PLAYER = player;
		Model.status = 0;
		new CreateGameController().process();
		try{
			for(;;){
				Thread.sleep(10);
				if(Model.status==1)
					break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Model.homeLayout.frame.setVisible(false);
		Model.gameLayout.setLayout();
		Model.gameLayout.addListener();
	
}
}
