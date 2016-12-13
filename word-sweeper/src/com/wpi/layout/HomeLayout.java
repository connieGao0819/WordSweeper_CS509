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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.wpi.client.model.ServerAccess;
import com.wpi.listener.CreateGameListener;
import com.wpi.listener.CreateListener;
import com.wpi.listener.JoinGameListener;
import com.wpi.listener.JoinListener;
import com.wpi.listener.MouseMoveListener;
import com.wpi.listener.PracticeGameListener;

import com.wpi.models.Model;

public class HomeLayout {
    public JFrame frame;
    private JButton newGameButton;
    private JButton joinGameButton;
    private JButton pracGameButton;
    private JLabel titleLabel;
    public JLabel nameLabel;
    public JLabel passwordLabel;
    public JLabel gameIDLabel;
    public JPasswordField passwordField;
    public JTextField nameField;
    public JTextField gameIDField;
    private JLabel label;
    public JButton createButton;
    public JButton joinButton;
    

    
    
    public HomeLayout(){
        frame = new JFrame();
        newGameButton = new JButton();
        joinGameButton = new JButton();
        pracGameButton = new JButton();
        titleLabel = new JLabel();
        nameLabel = new JLabel();
        passwordLabel = new JLabel();
        gameIDLabel = new JLabel();
        passwordField = new JPasswordField();
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

        joinGameButton.setText("JOIN GAME");
        joinGameButton.setBounds(60, 150, 140, 30);

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

        joinButton.setText("JOIN");
        joinButton.setBounds(320, 250, 80, 30);
        joinButton.setVisible(false);
   
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
        this.newGameButton.addActionListener(new CreateGameListener(this));
        this.joinGameButton.addActionListener(new JoinGameListener(this));
        this.joinButton.addActionListener(new JoinListener(this));
        this.createButton.addActionListener(new CreateListener(this));
    }

}
