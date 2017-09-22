package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
/**
 * When press the button exit, exit the game. 
 * @author haozhezhang
 *
 */
public class ExitListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(null, "Exiting the Game");
        System.exit(0);
    }

}
