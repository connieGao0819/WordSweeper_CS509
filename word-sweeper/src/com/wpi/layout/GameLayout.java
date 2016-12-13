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
import javax.swing.text.html.HTMLDocument.Iterator;

import com.wpi.client.model.ServerAccess;
import com.wpi.listener.ClearListener;
import com.wpi.listener.DownListener;
import com.wpi.listener.ExitListener;
import com.wpi.listener.LeftListener;
import com.wpi.listener.LockListener;
import com.wpi.listener.MouseMoveListener;
import com.wpi.listener.QuitListener;
import com.wpi.listener.ResetListener;
import com.wpi.listener.RightListener;
import com.wpi.listener.SubmitListener;
import com.wpi.listener.UpListener;
import com.wpi.models.Cell;
import com.wpi.models.Model;
import com.wpi.service.RandomLetter;

public class GameLayout {
    public JFrame frame = null;
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
    private JLabel managerLabel = null;
    private CellLabel[] letterLabel = null;
	private JLabel myScoreLabel;
	private JLabel myScore;
	private JLabel gameIDLabel;
	private JLabel playersNamesLabel;
	private JLabel playersScoresLabel;
	private JLabel lockedLabel;
	private JPanel viewPanel;
    
    
    private MouseMoveListener mouseListener = null;
    private QuitListener quitListener = null;
    private ClearListener clearListener = null;
    private ResetListener resetListener = null;
    private LockListener lockListener = null;
    private UpListener upListener = null;
    private DownListener downListener = null;
    private LeftListener leftListener = null;
    private RightListener rightListener = null;
    private SubmitListener submitListener = null;
   
    
    public static boolean ISPRESSED = false;
    
    
    public GameLayout(){
        frame = new JFrame();
        panel = new JPanel(new GridLayout(4,4,2,2));
        viewPanel = new JPanel(new GridLayout(0,2,2,2));
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
        managerLabel = new JLabel();
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
        clearListener = new ClearListener();
        resetListener = new ResetListener();
        upListener = new UpListener();
        downListener = new DownListener();
        leftListener = new LeftListener();
        rightListener = new RightListener();
        lockListener = new LockListener();
        submitListener = new SubmitListener();
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
        submitButton.setBounds(100, 280, 80, 30);
        lockButton.setText("LOCK");
        lockButton.setBounds(280, 190, 100, 30);
        lockedLabel.setBounds(500, 55, 50, 28);
        gameIDLabel.setText(Model.GAME.getGameID());
        gameIDLabel.setBounds(420, 20, 65, 30);
        myScore.setText("0");
        myScore.setBounds(500, 20, 65, 30);
		//
//		playersScoresLabel.setBounds(520, 75, 50, 28);
		upButton.setText("UP");
		upButton.setBounds(90, 245, 100, 30);
		downButton.setText("DOWN");
		downButton.setBounds(90, 315, 100, 30);
		leftButton.setText("LEFT");
		leftButton.setBounds(20, 280, 70, 30);
		rightButton.setText("RIGHT");
		rightButton.setBounds(190, 280, 70, 30);        
        
        frame.add(rightButton);
        frame.add(leftButton);
        frame.add(downButton);
        frame.add(upButton);
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
        frame.add(viewPanel);
        frame.setVisible(true);
    }
    
    public void playerSpecial(){
    	resetButton.setVisible(false);
    	lockButton.setVisible(false);
    	
    }
    
    public void setScoreLabel(){
    	viewPanel.removeAll();
		playersNamesLabel.setText("name");
		playersScoresLabel.setText("Score");
		viewPanel.setBounds(420, 80, 200, 200);
		viewPanel.add(playersNamesLabel);
		viewPanel.add(playersScoresLabel);
		for(String key : Model.GAME.getPlayersInfoMap().keySet()){
			JLabel nameLabel = new JLabel(key);
			JLabel scoreLabel = new JLabel(Model.GAME.getPlayersInfoMap().get(key)+"");
			viewPanel.add(nameLabel);
			viewPanel.add(scoreLabel);
		}
        viewPanel.validate();
        viewPanel.repaint();
        if(Model.PLAYER.isManager()){
        	managerLabel.setText("MANAGER");
        	managerLabel.setHorizontalAlignment(SwingConstants.LEFT);
        	managerLabel.setBounds(420, 60, 70, 20);
        	frame.add(managerLabel);
            frame.validate();
            frame.repaint();
        }

    }
    
    public void setCellLabel(){
    	panel.removeAll();
        for(int i=0; i < 16; i++){
            //letterLabel[i].setText(letters[i]);
        	letterLabel[i].setBackground(null);
            letterLabel[i].setBorder(BorderFactory.createLineBorder(Color.black));
            letterLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            letterLabel[i].setCell(Model.BOARD.getCells().get(i));
            if(Model.BOARD.getCells().get(i).isRepetition()){
            	letterLabel[i].setBackground(Color.CYAN);
            }
            if(Model.BOARD.getCells().get(i).isBonus()){
            	letterLabel[i].setBackground(Color.green);
            }
            letterLabel[i].setText(Model.BOARD.getCells().get(i).getLetter());
            letterLabel[i].setOpaque(true);
            panel.add(letterLabel[i]);
        }
        myScore.setText("0");
        panel.validate();
        panel.repaint();
    }
  
    
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
        lockButton.addActionListener(lockListener);
        submitButton.addActionListener(submitListener);
    }
    
    public JLabel getMyScore(){
    	return this.myScore;
    }
}
