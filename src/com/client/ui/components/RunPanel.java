package com.client.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.client.ui.ScriptSelectorUI;

public class RunPanel extends JPanel implements ActionListener {
	private RunPanel instance;
	private final JButton run, stop, pause, directory;
	private final JLabel titleLabel;
	private GridBagConstraints constraints;

	public RunPanel() {
		instance = this;

		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipady = 15;
		constraints.insets = new Insets(10, 0, 0, 0);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		titleLabel = new JLabel("Scripts", SwingConstants.CENTER);
		run = new JButton("Run Script");
		stop = new JButton("Stop Script");
		stop.setEnabled(false);
		pause = new JButton("Pause Script");
		pause.setEnabled(false);
		directory = new JButton("Script Directory");

		setUpListeners();
		fillPanel();
	}

	private void addComponent(int x, int y, JComponent comp) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(comp, constraints);
	}

	private final void fillPanel() {
		addComponent(0, 0, titleLabel);
		addComponent(0, 1, run);
		addComponent(0, 2, stop);
		addComponent(0, 3, pause);
		addComponent(0, 4, directory);
	}

	private final void setUpListeners() {
		run.addActionListener(this);
		pause.addActionListener(this);
		stop.addActionListener(this);
		directory.addActionListener(this);
	}

	public RunPanel getInstance() {
		return instance == null ? instance = new RunPanel() : instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command.toLowerCase()) {
			case "run script":
				new ScriptSelectorUI();
				break;
			case "stop script":

				break;
			case "pause script":

				break;
			case "directory":

				break;
			default:
				System.out.println("Invalid input.");
				break;
		}

	}

}
