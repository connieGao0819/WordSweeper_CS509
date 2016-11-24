package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.wpi.controller.JoinGameRequestController;
import com.wpi.layout.GameLayout;
import com.wpi.layout.HomeLayout;
import com.wpi.models.Model;


public class JoinGameListener implements ActionListener{

    private JFrame frame;
    private HomeLayout app;
    private Model model;
    
    public JoinGameListener(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        GameLayout gameLayout = new GameLayout();
        gameLayout.setLayout();
        gameLayout.addListener();
        gameLayout.playerSpecial();
        frame.setVisible(false);
        new JoinGameRequestController(app, model).process();
    }

}
