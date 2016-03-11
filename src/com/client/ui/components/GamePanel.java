package com.client.ui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.client.ui.components.logger.Logger;
import com.client.ui.components.logger.LoggerPane;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private GamePanel instance;
	private LoggerPane pane;

	public GamePanel(LoggerPane pane) {
		instance = this;
		this.pane = pane;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(765, 645));
		fillPanel();
	}

	private void fillPanel() {
		this.add(pane, BorderLayout.SOUTH);
	}

	public GamePanel getInstance() {
		return instance == null ? instance = new GamePanel(new LoggerPane(new Logger())) : instance;
	}

}
