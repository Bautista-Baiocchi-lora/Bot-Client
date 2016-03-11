package com.client.ui.components.sidebar.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPanel extends JPanel {
	private AboutPanel instance;
	private final JLabel titleLabel;

	public AboutPanel() {
		instance = this;
		setLayout(new GridLayout(0, 1));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		titleLabel = new JLabel("About");
		add(titleLabel);
	}

	public AboutPanel getInstance() {
		return instance == null ? instance = new AboutPanel() : instance;
	}

}
