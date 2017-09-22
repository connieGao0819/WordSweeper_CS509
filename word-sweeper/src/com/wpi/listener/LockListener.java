package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wpi.client.controller.requestController.LockGameController;
import com.wpi.models.Model;
/**
 * lock the game. 
 * @author haozhezhang
 *
 */
public class LockListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(Model.PLAYER.isManager()){
			new LockGameController().process();
			JOptionPane.showMessageDialog(null,  "LOCK GAME SUCCESS", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(null,  "sorry! you are not manager", "Warning", JOptionPane.WARNING_MESSAGE);

		}
	}
}
