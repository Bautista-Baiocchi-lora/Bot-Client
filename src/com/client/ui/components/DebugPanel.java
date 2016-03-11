package com.client.ui.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DebugPanel extends JPanel {
	private DebugPanel instance;

	public DebugPanel() {
		instance = this;
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new GridLayout(1, 0));
	}

	public DebugPanel getDebugPanel() {
		return instance == null ? instance = new DebugPanel() : instance;

	}

}
