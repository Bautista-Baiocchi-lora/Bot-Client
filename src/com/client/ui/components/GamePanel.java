package com.client.ui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GamePanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel instance;
	public JTextArea logArea;
	private JScrollPane scroll;

	public GamePanel() {
		instance = this;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(765, 645));
		
		logArea = new JTextArea(8, 5);
		scroll = new JScrollPane(logArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		logArea.setEditable(false);
		logArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		fillPanel();

	}
	private void fillPanel() {
		this.add(scroll, BorderLayout.SOUTH);
	}


	public GamePanel getInstance() {
		return instance == null ? instance = new GamePanel() : instance;
	}

}
