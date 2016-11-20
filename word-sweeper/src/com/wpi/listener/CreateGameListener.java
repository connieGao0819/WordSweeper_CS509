package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.wpi.layout.CreateGameLayout;
import com.wpi.layout.HomeLayout;
import com.wpi.layout.PracGameLayout;

public class CreateGameListener implements ActionListener{

    private JFrame frame;
    //private HomeLayout homelayout;
    //private String username=homelayout.getName();
	//private String password1 = homelayout.getPassword();
    
    public CreateGameListener(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        
    	String str=JOptionPane.showInputDialog("username");
    	if(str==""){
    		JOptionPane.showMessageDialog(null, "Must input a username!");
    	}else{
    		 str=JOptionPane.showInputDialog("password");}
    	//username=str;
    	//password1=str;
        CreateGameLayout gameLayout = new CreateGameLayout();
        gameLayout.setLayout();
        gameLayout.addListener();
        frame.setVisible(false);
    }

}

