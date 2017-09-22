package com.wpi.models;

import com.wpi.client.model.ServerAccess;
import com.wpi.layout.GameLayout;
import com.wpi.layout.HomeLayout;
/**
 * Model entity class, which plays a role as a manager of entity.  
 * 
 * @author Haozhe Zhang,Jiani Gao
 *
 */
public class Model {
		
		public static Word WORD=new Word() ;
		public static GameLayout gameLayout;
		public static HomeLayout homeLayout;
		public static Game GAME;
		public static Board BOARD;
		public static Player PLAYER;
		public static ServerAccess serverAccess;
		public static String IP = "localhost";
		public static int PORT = 11425; 
		public static boolean existedGame = false;
		public static int status = 0;//1:create succ;2:create fail
		                           //3:join succ; 4:join fail

	   	


		

}
