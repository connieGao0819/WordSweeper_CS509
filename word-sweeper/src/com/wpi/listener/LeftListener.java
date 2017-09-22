package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wpi.client.controller.requestController.RepositionBoardController;
import com.wpi.models.Model;
/**
 * When press the button left, jump into this part and set the board left. 
 * @author haozhezhang
 *
 */
public class LeftListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if(Model.BOARD.getLeft()>0){
//			//向服务器发送上移请求
//			Model.BOARD.setLeft(Model.BOARD.getLeft()-1);
//			Model.BOARD.setRight(Model.BOARD.getRight()+1);
//		}
//		else{
//			JOptionPane.showMessageDialog(null,  "cannot left", "Warning", JOptionPane.WARNING_MESSAGE);
//
//		}
		Model.BOARD.setRowChange(0);
		Model.BOARD.setColChange(-1);
		new RepositionBoardController().process();
	}

}
