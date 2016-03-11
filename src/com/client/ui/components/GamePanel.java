package com.client.ui.components;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel instance;
	private final Applet applet;

	public GamePanel(final Applet applet) {
		instance = this;
		this.applet = applet;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(765, 648));
		add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
	}

	public GamePanel getInstance() {
		return instance == null ? instance = new GamePanel(null) : instance;
	}

}
