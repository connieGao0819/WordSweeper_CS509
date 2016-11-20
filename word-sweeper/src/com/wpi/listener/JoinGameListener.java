package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.wpi.layout.JoinGameLayout;
import com.wpi.layout.PracGameLayout;

public class JoinGameListener implements ActionListener{

    private JFrame frame;
    
    public JoinGameListener(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JoinGameLayout gameLayout = new JoinGameLayout();
        gameLayout.setLayout();
        gameLayout.addListener();
        frame.setVisible(false);
    }

}
