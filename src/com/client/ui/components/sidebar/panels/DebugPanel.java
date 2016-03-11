package com.client.ui.components.sidebar.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.client.ui.components.logger.Logger;

public class DebugPanel extends JPanel implements ActionListener {
	private DebugPanel instance;
	private final GridBagConstraints constraints;
	private final JButton interfaces, npcs, objects, groundItems, players, location, bank,
			inventory, actions, test;

	public DebugPanel() {
		instance = this;

		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipady = 15;
		constraints.ipadx = 10;
		constraints.insets = new Insets(10, 0, 0, 0);

		interfaces = new JButton("Interface");
		npcs = new JButton("Npcs");
		objects = new JButton("Objects");
		groundItems = new JButton("Ground Items");
		players = new JButton("Players");
		location = new JButton("Location");
		bank = new JButton("Bank");
		inventory = new JButton("Inventory");
		actions = new JButton("Actions");
		test = new JButton("Test");

		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new GridLayout());
		setUpListeners();
		fillPanel();
	}

	private void addComponent(final int x, final int y, final JComponent comp) {
		constraints.gridx = x;
		constraints.gridy = y;
		comp.setPreferredSize(new Dimension(60, 14));
		add(comp, constraints);
	}

	private void fillPanel() {
		addComponent(0, 0, interfaces);
		addComponent(0, 1, npcs);
		addComponent(0, 2, objects);
		addComponent(0, 3, groundItems);
		addComponent(0, 4, players);
		addComponent(0, 5, location);
		addComponent(0, 6, bank);
		addComponent(0, 7, inventory);
		addComponent(0, 8, actions);
		addComponent(0, 9, test);
	}

	private void setUpListeners() {
		interfaces.addActionListener(this);
		npcs.addActionListener(this);
		objects.addActionListener(this);
		groundItems.addActionListener(this);
		players.addActionListener(this);
		location.addActionListener(this);
		bank.addActionListener(this);
		inventory.addActionListener(this);
		actions.addActionListener(this);
		test.addActionListener(this);
	}

	public DebugPanel getDebugPanel() {
		return instance == null ? instance = new DebugPanel() : instance;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
			case "Interface":

				break;
			case "Npcs":
				break;
			case "Objects":
				break;
			case "Ground Items":
				break;
			case "Players":
				break;
			case "Location":
				break;
			case "Bank":
				break;
			case "Inventory":
				break;
			case "Actions":
				break;
			case "Test":
				break;
			default:
				Logger.writeWarning("Error in debug panel action listener.");
				break;
		}
	}

}
