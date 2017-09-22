package com.wpi.listener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.wpi.layout.CellLabel;
import com.wpi.layout.GameLayout;
import com.wpi.layout.PracticeLayout;
import com.wpi.models.Model;
/**
 * The operation and the function of the operation of the mouse.
 * @author haozhezhang
 *
 */
public class MouseMoveListener implements MouseListener{
    
    private CellLabel label = null;
    private GameLayout game = null;
    
    public MouseMoveListener(CellLabel label, GameLayout game){
        this.label = label;
        this.game = game;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        PracticeLayout.ISPRESSED = true;
        this.label.setBackground(Color.gray);
        Model.BOARD.getChosenCells().add(this.label.getCell());
        game.getMyScore().setText(String.valueOf(Model.BOARD.getChosenLettersScore()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        PracticeLayout.ISPRESSED = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
      
        if(PracticeLayout.ISPRESSED){
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
