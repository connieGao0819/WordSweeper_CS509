package com.wpi.listener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.wpi.layout.CellLabel;
import com.wpi.layout.GameLayout;
import com.wpi.layout.PracGameLayout;
import com.wpi.models.Model;

public class MouseMoveListener implements MouseListener{
    
    private CellLabel label = null;
    private GameLayout game = null;
    private PracGameLayout prac = null;
    
    public MouseMoveListener(CellLabel label, GameLayout game){
        this.label = label;
        this.game = game;
    }
    
    public MouseMoveListener(CellLabel label, PracGameLayout prac){
        this.label = label;
        this.prac = prac;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        PracGameLayout.ISPRESSED = true;
       // System.out.println(this.press);
        this.label.setBackground(Color.gray);
        Model.BOARD.getChosenCells().add(this.label.getCell());
        game.getMyScore().setText(String.valueOf(Model.BOARD.getChosenLettersScore()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
       // System.out.println(this.press);
        PracGameLayout.ISPRESSED = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println(this.press);
        if(PracGameLayout.ISPRESSED){
            this.label.setBackground(Color.gray);
            Model.BOARD.getChosenCells().add(this.label.getCell());
            game.getMyScore().setText(String.valueOf(Model.BOARD.getChosenLettersScore()));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

}
