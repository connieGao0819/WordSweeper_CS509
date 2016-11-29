package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.wpi.layout.PracGameLayout;

public class PracticeGameListener implements ActionListener{

    private JFrame frame;
    
    public PracticeGameListener(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        PracGameLayout gameLayout = new PracGameLayout();
        gameLayout.setLayout();
        gameLayout.addListener();
        frame.setVisible(false);
    }

}
