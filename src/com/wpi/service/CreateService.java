package com.wpi.service;

import java.util.ArrayList;
import java.util.List;

import com.wpi.client_src.ServerAccess;
import com.wpi.controller.SampleClientMessageHandler;
import com.wpi.layout.GameLayout;
import com.wpi.models.Board;
import com.wpi.models.Cell;
import com.wpi.models.Game;
import com.wpi.models.Model;
import com.wpi.models.Player;
import com.wpi.xml.Message;

public class CreateService {

//该方法为创建一个新游戏
	public void createGame(String name, String password){
				
		//startAccess();//连接服务器
		//这里需要加入从服务器接收数据，testdata是测试数据，还需要接收房间id，起始坐标
		List<String> testData = new ArrayList<String>(){{add("a");add("b");
		add("c");add("d");add("e");add("f");add("j");add("h");add("i");
		add("g");add("k");add("l");add("m");add("n");add("o");add("p");
		}}; //测试数据
		Player player = new Player(name);  //与服务器联通后，生成一个玩家
		Game game = new Game("id", password); //id从服务器获得，游戏开始，保存当前游戏的id和密码
		Model.PLAYER = player; //player和game由model保存，在其他地方调用时，直接使用Model.xxx
		Model.GAME = game;
		CellsService cs = new CellsService(1,1);//处理cell的类，输入为board起始坐标，第一个参数是x坐标，第二个为y坐标，负责生成cell，每个cell记录了字母，位置，是否被选中，是否重复
		cs.setCellNum(testData);//将服务器的字母传入，调用该方法，初始化cell，设置他的字母和分数
		cs.setRepetition(1, 1);//该方法设置哪些cell是和其他用户重复，参数为其他用户Board的起始坐标，第一个参数是X坐标，第二个是y坐标，当有多个用户时，多次调用多方法即可，假设有3个用户，该方法调用两次，每次都传入其他用户Board的起始坐标
		List<Cell> cells = cs.getCells();//经过前边两步，cell已经全部设置好，直接调用get获得cell就好
		Board board = new Board(cells,1,1,7);//参数依次是cells，起始x坐标，起始y坐标，服务器端Board尺寸
		Model.BOARD = board;
		GameLayout gameLayout = new GameLayout();
		gameLayout.setLayout();
		gameLayout.addListener();
	}
	
	private void startAccess(){
 		if (!Message.configure("wordsweeper.xsd")) {
 			System.exit(0);
 		}
		Model.serverAccess = new ServerAccess(Model.IP, Model.PORT);
		if (!Model.serverAccess.connect(new SampleClientMessageHandler())) {
			System.out.println("Unable to connect to server (" + Model.IP + "). Exiting.");
			System.exit(0);
		}
		System.out.println("Connected to " + Model.IP);
	}
}
