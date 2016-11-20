package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.wpi.layout.HomeLayout;
import com.wpi.layout.PracGameLayout;
import com.wpi.models.Model;

public class QuitListener implements ActionListener{

	    private JFrame frame;
	    private Model model;
	    
	    public QuitListener(JFrame frame){
	        this.frame = frame;
	    }
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // TODO Auto-generated method stub
	        HomeLayout homeLayout = new HomeLayout(model);
	        homeLayout.setLayout();
	        homeLayout.addListener();
	        frame.setVisible(false);
	    }

	}

