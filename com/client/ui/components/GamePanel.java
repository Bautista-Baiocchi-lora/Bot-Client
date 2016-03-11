package com.client.ui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.client.ui.components.logger.Logger;
import com.client.ui.components.logger.LoggerPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private GamePanel instance;
	private final LoggerPanel panel;

	public GamePanel(final LoggerPanel panel) {
		instance = this;
		this.panel = panel;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(765, 645));
		fillPanel();
	}

	private void fillPanel() {
		this.add(panel, BorderLayout.SOUTH);
	}

	public GamePanel getInstance() {
		return instance == null ? instance = new GamePanel(new LoggerPanel(new Logger()))
				: instance;
	}

}
