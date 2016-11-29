package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wpi.layout.HomeLayout;

public class JoinListener implements ActionListener {

	private HomeLayout layout;
	
	public JoinListener(HomeLayout layout){
		this.layout = layout;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = "";
		String id = "";
		String password = "";
		name = layout.nameField.getText();
		id = layout.gameIDField.getText();
		password = layout.passwordField.getText();
		if (name.length()==0){
			JOptionPane.showMessageDialog(layout.frame, "name cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		else if (id.length()==0){
			JOptionPane.showMessageDialog(layout.frame,  "Game ID cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		else if (password.length()==0){
			JOptionPane.showMessageDialog(layout.frame,  "password cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		
	}

}
