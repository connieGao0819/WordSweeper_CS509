package com.wpi.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wpi.client.controller.requestController.JoinGameController;
import com.wpi.layout.GameLayout;
import com.wpi.layout.HomeLayout;
import com.wpi.models.Game;
import com.wpi.models.Model;
import com.wpi.models.Player;
/**
 * Send the input message to the server. 
 * @author haozhezhang
 *
 */
public class JoinListener implements ActionListener {

	private HomeLayout layout;

	public JoinListener(HomeLayout layout) {
		this.layout = layout;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = "";
		String id = "";
		String password = "";
		name = layout.nameField.getText();
		id = layout.gameIDField.getText();
		password = layout.passwordField.getText();
		if (name.length() == 0) {
			JOptionPane.showMessageDialog(layout.frame, "name cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
		} else if (id.length() == 0) {
			JOptionPane.showMessageDialog(layout.frame, "Game ID cannot be empty", "Warning",
					JOptionPane.WARNING_MESSAGE);
		} else {
			Game game = new Game(id, password);
			Player player = new Player(name);
			Model.GAME = game;
			Model.PLAYER = player;
			Model.status = 0;
			new JoinGameController().process();
			try {
				while (Model.status == 0) {
					Thread.sleep(10);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (Model.status == 4) {
				JOptionPane.showMessageDialog(layout.frame, "JOIN GAME FAIL", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				Model.homeLayout.frame.setVisible(false);
				Model.gameLayout.setLayout();
				Model.gameLayout.addListener();
			}
		}
	}
}
