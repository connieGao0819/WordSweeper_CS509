package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wpi.client.controller.requestController.FindWordController;
import com.wpi.models.Model;
/**
 * When press the button submit, jump into this part and submit the word. 
 * @author haozhezhang
 *
 */
public class SubmitListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Model.WORD.setSpell(Model.BOARD.getWord());
		new FindWordController().process();
	}

}
