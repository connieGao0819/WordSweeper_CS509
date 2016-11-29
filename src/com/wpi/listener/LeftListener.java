package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wpi.models.Model;

public class LeftListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(Model.BOARD.getLeft()>0){
			//向服务器发送上移请求
			Model.BOARD.setLeft(Model.BOARD.getLeft()-1);
		}
		else{
			JOptionPane.showMessageDialog(null,  "cannot left", "Warning", JOptionPane.WARNING_MESSAGE);

		}
	}

}
