package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.wpi.controller.CreateGameController;
import com.wpi.layout.GameLayout;
import com.wpi.layout.HomeLayout;
import com.wpi.models.Model;

public class CreateGameListener implements ActionListener{

    private HomeLayout layout;
 
    public CreateGameListener(HomeLayout layout){
        this.layout = layout;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	layout.nameField.setText("");
    	layout.gameIDField.setText("");
    	layout.passwordField.setText("");
    	layout.nameLabel.setVisible(true);
    	layout.passwordLabel.setVisible(true);
    	layout.nameField.setVisible(true);
    	layout.passwordField.setVisible(true);
    	layout.createButton.setVisible(true);
    	layout.gameIDLabel.setVisible(false);
    	layout.gameIDField.setVisible(false);
    	layout.joinButton.setVisible(false);
    }

}

