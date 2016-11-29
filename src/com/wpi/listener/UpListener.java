package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wpi.models.Model;

public class UpListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(Model.BOARD.getUp()>0){
			//向服务器发送上移请求
			Model.BOARD.setUp(Model.BOARD.getUp()-1);
		}
		else{
			JOptionPane.showMessageDialog(null,  "cannot up", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
	

}
