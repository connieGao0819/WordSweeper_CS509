package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.wpi.controller.CreateGameController;
import com.wpi.layout.GameLayout;
import com.wpi.layout.HomeLayout;
import com.wpi.models.Model;

public class CreateGameListener implements ActionListener{

    private JFrame frame;
    private Model model;
    private HomeLayout app;
 
    public CreateGameListener(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        GameLayout gameLayout = new GameLayout();
        gameLayout.setLayout();
        gameLayout.addListener();
        frame.setVisible(false);
        new CreateGameController(app, model).process();
    }

}

