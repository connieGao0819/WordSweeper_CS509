package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.wpi.layout.GameLayout;
import com.wpi.layout.HomeLayout;
import com.wpi.models.Board;
import com.wpi.models.Cell;
import com.wpi.models.Game;
import com.wpi.models.Model;
import com.wpi.models.Player;
import com.wpi.service.CellsService;
import com.wpi.service.CreateService;

public class CreateListener implements ActionListener{

	private HomeLayout layout;
	
	public CreateListener(HomeLayout layout){
		this.layout = layout;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String name = "";
		String password = "";
		name = layout.nameField.getText();
		password = layout.passwordField.getText();
		if (name.length()==0){
			JOptionPane.showMessageDialog(layout.frame, "name cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		else{
			CreateService create = new CreateService();
			create.createGame(name, password);		
		}
	}

}
