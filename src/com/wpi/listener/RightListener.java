package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wpi.models.Model;

public class RightListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(Model.BOARD.getRight()>0){
			//向服务器发送上移请求
			Model.BOARD.setRight(Model.BOARD.getRight()-1);
		}
		else{
			JOptionPane.showMessageDialog(null,  "cannot right", "Warning", JOptionPane.WARNING_MESSAGE);

		}
	}

}
