package com.wpi.layout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.wpi.client_src.ServerAccess;
import com.wpi.controller.LockGameRequestController;
import com.wpi.controller.ResetGameRequestController;
import com.wpi.listener.ClearListener;
import com.wpi.listener.DownListener;
import com.wpi.listener.ExitListener;
import com.wpi.listener.LeftListener;
import com.wpi.listener.MouseMoveListener;
import com.wpi.listener.QuitListener;
import com.wpi.listener.ResetListener;
import com.wpi.listener.RightListener;
import com.wpi.listener.UpListener;
import com.wpi.models.Cell;
import com.wpi.models.Model;
import com.wpi.service.RandomLetter;

public class GameLayout {
    private JFrame frame = null;
    private JPanel panel = null;
    private JButton resetButton = null;
    private JButton clearButton = null;
    private JButton quitButton = null;
    private JButton submitButton = null;
    private JButton lockButton = null;
    private JButton upButton = null;
    private JButton downButton = null;
    private JButton leftButton = null;
    private JButton rightButton = null;
    
    private JLabel titleLabel = null;
    private CellLabel[] letterLabel = null;
	private JLabel myScoreLabel;
	private JLabel myScore;
	private JLabel gameIDLabel;
	private JLabel playersNamesLabel;
	private JLabel playersScoresLabel;
	private JLabel lockedLabel;
	
    
    
    private MouseMoveListener mouseListener = null;
    private QuitListener quitListener = null;
    private ClearListener clearListener = null;
    private ResetListener resetListener = null;
    private UpListener upListener = null;
    private DownListener downListener = null;
    private LeftListener leftListener = null;
    private RightListener rightListener = null;
    //private LockListener lockListener = null;
    //private SubmitListener submitListener = null;
   
    
    public static boolean ISPRESSED = false;
    
    
    public GameLayout(){
        frame = new JFrame();
        panel = new JPanel(new GridLayout(4,4,2,2));
        resetButton = new JButton();
        clearButton = new JButton();
        quitButton = new JButton();
        submitButton = new JButton();
        lockButton = new JButton();
        titleLabel = new JLabel();
        letterLabel = new CellLabel[16];
        gameIDLabel = new JLabel();
        myScoreLabel = new JLabel();
        playersNamesLabel = new JLabel();
        playersScoresLabel = new JLabel();
        myScore = new JLabel();
        lockedLabel = new JLabel();
        upButton = new JButton();
        downButton = new JButton();
        leftButton = new JButton();
        rightButton = new JButton();
        
        
        
        //randomLetter = new RandomLetter();
        for(int i=0; i<16; i++){
            letterLabel[i] = new CellLabel();
        }
        
        quitListener = new QuitListener();
        clearListener = new ClearListener(letterLabel);
        resetListener = new ResetListener(letterLabel);
        upListener = new UpListener();
        downListener = new DownListener();
        leftListener = new LeftListener();
        rightListener = new RightListener();
        //submitListener = new SubmitListener();
        //lockListener = new LockListener();
        
    }
    
    
    
    public void setLayout(){
        int width = 650, height = 400;
        int x = 100, y = 100;
        //String[] letters = this.randomLetter.getRandomLetter(letterLabel.length);
        x = (Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2;
        y = (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2;
        frame.setTitle("Word Sweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, width, height);
        frame.setLayout(null);
        titleLabel.setText("Word Sweeper");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 20));
        titleLabel.setBounds(180, 0, 250, 80);
        panel.setBounds(50, 60, 180, 180);
        resetButton.setBounds(280, 80, 100, 30);
        resetButton.setText("RESET");
        clearButton.setBounds(280, 135, 100, 30);
        clearButton.setText("CLEAR");
        quitButton.setBounds(280, 245, 100, 30);
        quitButton.setText("QUIT");
        submitButton.setText("SUBMIT");
        submitButton.setBounds(90, 245, 100, 30);
        lockButton.setText("LOCK");
        lockButton.setBounds(280, 190, 100, 30);
        lockedLabel.setBounds(500, 55, 50, 28);
        gameIDLabel.setText("");
        gameIDLabel.setBounds(500, 20, 65, 28);
        myScoreLabel = new JLabel(Model.PLAYER.getName());
		myScoreLabel.setBounds(400, 75, 65, 28);
		myScore = new JLabel(String.valueOf(Model.PLAYER.getScore()));
		myScore.setBounds(480, 80, 120, 21);
		myScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		playersNamesLabel.setText("name");
		playersNamesLabel.setBounds(420, 110, 50, 28);
		playersScoresLabel.setText("Score");
		playersScoresLabel.setBounds(520, 110, 50, 28);
		upButton.setText("UP");
		upButton.setBounds(120, 280, 50, 30);
		downButton.setText("DOWN");
		downButton.setBounds(110, 320, 70, 30);
		leftButton.setText("LEFT");
		leftButton.setBounds(30, 300, 70, 30);
		rightButton.setText("RIGHT");
		rightButton.setBounds(200, 300, 80, 30);
		
		//playersInfoArea.setText(model.getGame().getPlayersListByScore());
        
        
        
        /**add label**/
        for(int i=0; i < 16; i++){
            //letterLabel[i].setText(letters[i]);
            letterLabel[i].setBorder(BorderFactory.createLineBorder(Color.black));
            letterLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            letterLabel[i].setCell(Model.BOARD.getCells().get(i));
            if(Model.BOARD.getCells().get(i).isRepetition()){
            	letterLabel[i].setBackground(Color.BLUE);
            }
            letterLabel[i].setText(Model.BOARD.getCells().get(i).getLetter());
            letterLabel[i].setOpaque(true);
            panel.add(letterLabel[i]);
        }
        
        frame.add(rightButton);
        frame.add(leftButton);
        frame.add(downButton);
        frame.add(upButton);
        frame.add(playersScoresLabel);
        frame.add(playersNamesLabel);
        frame.add(myScore);
        frame.add(myScoreLabel);
        frame.add(gameIDLabel);
        frame.add(titleLabel);
        frame.add(panel);
        frame.add(resetButton);
        frame.add(clearButton);
        frame.add(quitButton);
        frame.add(submitButton);
        frame.add(lockButton);
        frame.setVisible(true);
    }
    
    public void playerSpecial(){
    	resetButton.setVisible(false);
    	lockButton.setVisible(false);
    	
    }
    /*public void updateGameInfoBoard() {
		gameIDLabel.setText(model.getGame().getGameID());
		myScore.setText(String.valueOf(model.getPlayer().getScore()));
		playersInfoArea.setText(model.getGame().getPlayersListByName());
		administratorNameLabel.setText(model.getGame().getManagingUser());
		if ( model.getGame().getManagingUser().equals(model.getPlayer().getName())) {// model.getPlayer().isManager()
			lockButton.setEnabled(true);
			resetButton.setEnabled(true);
			resetButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//gameLockResetLabel.setText("Game has been RESET!");
					new ResetGameRequestController(gamelayout, model).process();
					// updateGameInfoBoard();
					resetButton.setEnabled(false);
					resetButton.setEnabled(true);
				}
			});

			lockButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//gameLockResetLabel.setText("Game has been Locked!");
					new LockGameRequestController(gamelayout, model).process();
					lockButton.setEnabled(false);
				}
			});

		}

		if (model.getGame().isLocked()) {
			lockedLabel.setText("Locked!");;
			lockButton.setEnabled(false);
		}
    }*/
    
  
    
    public void addListener(){
        for(int i=0; i<letterLabel.length; i++){
            mouseListener = new MouseMoveListener(letterLabel[i], this);
            letterLabel[i].addMouseListener(mouseListener);
        }
        
        
        quitButton.addActionListener(quitListener);
        resetButton.addActionListener(resetListener);
        clearButton.addActionListener(clearListener);
        upButton.addActionListener(upListener);
        downButton.addActionListener(downListener);
        leftButton.addActionListener(leftListener);
        rightButton.addActionListener(rightListener);
        //lockButton.addActionListener(lockListener);
        //submitButton.addActionListener(submitListener);
    }
    
    public JLabel getMyScore(){
    	return this.myScore;
    }
}
