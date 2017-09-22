package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wpi.client.controller.requestController.RepositionBoardController;
import com.wpi.models.Model;
/**
 * When press the button up, jump into this part and set the board up. 
 * @author haozhezhang
 *
 */
public class UpListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Model.BOARD.setRowChange(-1);
		Model.BOARD.setColChange(0);
		new RepositionBoardController().process();

	}
	

}
