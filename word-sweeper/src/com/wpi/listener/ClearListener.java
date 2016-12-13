package com.wpi.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import com.wpi.layout.CellLabel;
import com.wpi.models.Model;

public class ClearListener implements ActionListener{
    
//    private CellLabel[] labels;
    
    public ClearListener(){
//        this.label=labels;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	Model.gameLayout.setCellLabel();
    	Model.BOARD.clearChosenCells();
    }
}
