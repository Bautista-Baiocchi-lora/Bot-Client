package com.client.ui.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private GamePanel instance;

	public GamePanel() {
		instance = this;
		setPreferredSize(new Dimension(500, 350));
	}

	public GamePanel getInstance() {
		return instance == null ? instance = new GamePanel() : instance;
	}

}
