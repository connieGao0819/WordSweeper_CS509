package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.wpi.client.controller.requestController.ResetGameController;
import com.wpi.models.Model;
import com.wpi.service.RandomLetter;
/**
 * When managing user press the button reset, jump into this part and reset the board . 
 * @author haozhezhang
 *
 */
public class ResetListener implements ActionListener{

    
    public ResetListener(){
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	if(!Model.PLAYER.isManager()){
			JOptionPane.showMessageDialog(null, "sorry! you are not manager", "Warning", JOptionPane.WARNING_MESSAGE);
    	}
    	else{
    		new ResetGameController().process();
    	}
    }

}
