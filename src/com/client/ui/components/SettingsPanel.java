package com.client.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import com.client.api.method.Menu;
import com.client.data.Constants;

public class SettingsPanel extends JPanel implements ActionListener, ItemListener {
	private SettingsPanel instance;
	private final JLabel colorLabel, titleLabel, loggerLabel;
	private final JComboBox colorComboBox;
	private final JButton save;
	private final JToggleButton logger;
	private final GridBagConstraints constraints;
	private Thread getAction;

	public SettingsPanel() {
		instance = this;

		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipady = 15;
		constraints.ipadx = 10;
		constraints.insets = new Insets(10, 0, 0, 0);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		titleLabel = new JLabel("Settings", SwingConstants.CENTER);
		colorLabel = new JLabel("Client Color:");
		colorComboBox = new JComboBox(Constants.CLIENT_COLOR_OPTIONS);
		loggerLabel = new JLabel("Logger:");
		logger = new JToggleButton("On");
		save = new JButton("Save");
		setUpListeners();
		fillPanel();
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final String command = e.getActionCommand();
		switch (command.toLowerCase()) {
			case "randoms":

				Menu.sendAction(315, 554, 2, 1167);
				break;

		}

	}

	private void addComponent(final int x, final int y, final JComponent comp) {
		constraints.gridx = x;
		constraints.gridy = y;
		comp.setPreferredSize(new Dimension(60, 14));
		add(comp, constraints);
	}

	private final void fillPanel() {
		addComponent(0, 1, colorLabel);
		addComponent(1, 1, colorComboBox);
		addComponent(0, 2, loggerLabel);
		addComponent(1, 2, logger);
		constraints.gridwidth = 2;
		addComponent(0, 0, titleLabel);
		addComponent(0, 3, save);
	}

	public SettingsPanel getInstance() {
		return instance == null ? instance = new SettingsPanel() : instance;
	}

	@Override
	public void itemStateChanged(final ItemEvent e) {
		if (e.getStateChange() == 1) {
			final String command = e.getItem().toString();
			switch (command.toLowerCase()) {
				case "black":
					// GROUND WORK FOR COLOR CHANGE//
					System.out.println("Setting color - black");
					break;

			}
		}
	}

	private final void setUpListeners() {
		colorComboBox.addItemListener(this);
		;

	}

}
