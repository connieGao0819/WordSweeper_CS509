package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wpi.models.Model;

public class DownListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(Model.BOARD.getDown()>0){
			//向服务器发送下移请求
			Model.BOARD.setDown((Model.BOARD.getDown()-1));
		}
		else{
			JOptionPane.showMessageDialog(null,  "cannot down", "Warning", JOptionPane.WARNING_MESSAGE);

		}
	}

}
