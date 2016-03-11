package com.client.ui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private GamePanel instance;

	public GamePanel() {
		instance = this;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(765, 500));
	}

	public GamePanel getInstance() {
		return instance == null ? instance = new GamePanel()
				: instance;
	}

}
