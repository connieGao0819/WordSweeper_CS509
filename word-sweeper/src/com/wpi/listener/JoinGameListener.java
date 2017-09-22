package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.wpi.layout.GameLayout;
import com.wpi.layout.HomeLayout;
import com.wpi.models.Model;

/**
 * When press the button join, jump into this part and show the place for users to input gameID,player name and password. 
 * @author haozhezhang
 *
 */
public class JoinGameListener implements ActionListener{

    private HomeLayout layout;
    
    public JoinGameListener(HomeLayout layout){
        this.layout = layout;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	layout.nameField.setText("");
    	layout.passwordField.setText("");
    	layout.gameIDField.setText("");
		layout.gameIDLabel.setVisible(true);
		layout.passwordLabel.setVisible(true);
		layout.gameIDField.setVisible(true);
		layout.passwordField.setVisible(true);
		layout.joinButton.setVisible(true);
		layout.nameLabel.setVisible(true);
		layout.nameField.setVisible(true);
		layout.createButton.setVisible(false);
    }

}
