package com.wpi.listener;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wpi.client.controller.requestController.ExitGameController;
/**
 * Quit the game. 
 * @author haozhezhang
 *
 */
public class QuitListener implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new ExitGameController().process();
	}
	

}
