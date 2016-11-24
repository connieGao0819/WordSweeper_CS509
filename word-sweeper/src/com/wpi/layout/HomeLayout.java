package com.wpi.layout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.wpi.listener.CreateGameListener;
import com.wpi.listener.JoinGameListener;
import com.wpi.listener.MouseMoveListener;
import com.wpi.listener.PracticeGameListener;

import com.wpi.models.Model;
import com.wpi.client_src.ServerAccess;
import com.wpi.controller.CreateGameController;
import com.wpi.controller.JoinGameRequestController;

public class HomeLayout {
    private JFrame frame;
    private JButton newGameButton;
    private JButton joinGameButton;
    private JButton pracGameButton;
    private JLabel titleLabel;
    private String password;
    private String name;
    private String gameID;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel gameIDLabel;
    private JTextField passwordField;
    private JTextField nameField;
    private JTextField gameIDField;
    private JLabel label;
    private JButton createButton;
    private JButton joinButton;
    
    public final Model model;
	ServerAccess serverAccess;
    
    
    public HomeLayout(Model model){
    	this.model = model;
        frame = new JFrame();
        newGameButton = new JButton();
        joinGameButton = new JButton();
        pracGameButton = new JButton();
        titleLabel = new JLabel();
        nameLabel = new JLabel();
        passwordLabel = new JLabel();
        gameIDLabel = new JLabel();
        passwordField = new JTextField();
        nameField = new JTextField();
        gameIDField = new JTextField();
        createButton = new JButton();
        joinButton = new JButton();
        
        label = new JLabel();
        
      
        
    }
    
    public void setLayout(){
        int width = 600, height = 400;
        int x = 100, y = 100;
        x = (Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2;
        y = (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2;
        frame.setTitle("Word Sweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, width, height);
        frame.setLayout(null);
        titleLabel.setText("Welcome to WordSweeper");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 20));
        titleLabel.setBounds(100, 0, 300, 80);
        newGameButton.setText("CREATE GAME");
        newGameButton.setBounds(60, 100, 140, 30);
        newGameButton.addMouseListener(new MouseMoveListener(label){		
			public void mousePressed(MouseEvent e) {			
				nameLabel.setVisible(true);
				passwordLabel.setVisible(true);
				nameField.setVisible(true);
				passwordField.setVisible(true);
				createButton.setVisible(true);
				gameIDLabel.setVisible(false);
				gameIDField.setVisible(false);
				joinButton.setVisible(false);
			}
		});

        joinGameButton.setText("JOIN GAME");
        joinGameButton.setBounds(60, 150, 140, 30);
        joinGameButton.addMouseListener(new MouseMoveListener(label){		
			public void mousePressed(MouseEvent e) {			
				gameIDLabel.setVisible(true);
				passwordLabel.setVisible(true);
				gameIDField.setVisible(true);
				passwordField.setVisible(true);
				joinButton.setVisible(true);
			    nameLabel.setVisible(true);
			    nameField.setVisible(true);
			    createButton.setVisible(false);
			}
		});
        pracGameButton.setText("PRACTICE GAME");
        pracGameButton.setBounds(60, 200, 140, 30);
        nameLabel.setText("USER NAME:");
        nameLabel.setBounds(220, 120, 100, 30);
        nameLabel.setFont(new Font("Lucida Bright",Font.ITALIC,15));
        nameLabel.setVisible(false);
        gameIDLabel.setText("GAME ID:");
        gameIDLabel.setBounds(220, 160, 100, 30);
        gameIDLabel.setFont(new Font("Lucida Bright",Font.ITALIC,15));
        gameIDLabel.setVisible(false);
        passwordLabel.setText("PASSWORD:");
        passwordLabel.setBounds(220, 200, 100, 30);
        passwordLabel.setFont(new Font("Lucida Bright",Font.ITALIC,15));
        passwordLabel.setVisible(false);
        nameField.setBounds(320, 120, 150, 25);
        nameField.setVisible(false);
        gameIDField.setBounds(320, 160, 150, 25);
        gameIDField.setVisible(false);
        passwordField.setBounds(320, 200, 150, 25);
        passwordField.setVisible(false);
        createButton.setText("CREATE");
        createButton.setBounds(320, 250, 80, 30);
        createButton.setVisible(false);
        createButton.addMouseListener(new MouseMoveListener(label){
        	public boolean noName(){
				name = nameField.getText();
				if(name.length() == 0){
					JOptionPane.showMessageDialog(frame, "name cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
					nameField.requestFocus();
					
					return true;
				}
				return false;
        }
        	public void mousePressed(MouseEvent e) {			
				if(!noName()){
					createButton.addActionListener(new CreateGameListener(frame));
					//new CreateGameController(HomeLayout.this, model).process();
					//HomeLayout.this.disableInputs();
				}
			}
        });

	

        joinButton.setText("JOIN");
        joinButton.setBounds(320, 250, 80, 30);
        joinButton.setVisible(false);
        joinButton.addMouseListener(new MouseMoveListener(label){
        public boolean noNameGameID(){
			name = nameField.getText();
			gameID = gameIDField.getText();
			if(name.length() == 0){
				JOptionPane.showMessageDialog(frame, "name cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
				nameField.requestFocus();
				
				return true;
			}else if(gameID.length() == 0){
				JOptionPane.showMessageDialog(frame, "Game ID cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
				nameField.requestFocus();
				return true;
			}
			return false;
    }
    	public void mousePressed(MouseEvent e) {			
			if(!noNameGameID()){
				joinButton.addActionListener(new JoinGameListener(frame));
				//new CreateGameController(HomeLayout.this, model).process();
				//HomeLayout.this.disableInputs();
			}
		}
    });

        
        
        
        frame.add(nameLabel);
        frame.add(gameIDLabel);
        frame.add(passwordLabel);
        frame.add(nameField);
        frame.add(gameIDField);
        frame.add(passwordField);
        frame.add(createButton);
        frame.add(joinButton);
        frame.add(titleLabel);
        frame.add(newGameButton);
        frame.add(pracGameButton);
        frame.add(joinGameButton);
        frame.setVisible(true);
    }
    
    public void addListener(){
        this.pracGameButton.addActionListener(new PracticeGameListener(this.frame));
        this.createButton.addActionListener(new CreateGameListener(this.frame));
        this.joinButton.addActionListener(new JoinGameListener(this.frame));
    }
    public String getPassword(){
    	return password;
    }
    public String getName(){
    	return name;
    }
    public String getGameID(){
    	return gameID;
    }
    public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	public ServerAccess getServerAccess() {
		return serverAccess;
	}
}
