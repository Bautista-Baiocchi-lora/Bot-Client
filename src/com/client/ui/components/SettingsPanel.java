package com.client.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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

import com.client.core.Client;
import com.client.core.Engine;
import com.client.data.Constants;
import com.client.test.Int;
import com.client.test.ReflectionShit;
import com.client.ui.BotUI;
import com.client.ui.ScriptSelectorUI;

public class SettingsPanel extends JPanel implements ActionListener, ItemListener{
	private SettingsPanel instance;
	private final JLabel colorLabel, titleLabel, dialogLabel, loggerLabel;
	private final JComboBox colorComboBox;
	private final JButton save, clearCache, network, randoms, reflectionExplorer;
	private final JToggleButton logger, dialog;
	private final GridBagConstraints constraints;
	Client client = Engine.client; //For testing loader
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
		clearCache = new JButton("Clear Cache");
		network = new JButton("Network");
		randoms = new JButton("Randoms");
		loggerLabel = new JLabel("Logger:");
		logger = new JToggleButton("On");
		reflectionExplorer = new JButton("<html><center>Reflection Explorer");
		dialogLabel = new JLabel("Dialog");
		dialog = new JToggleButton("On");
		save = new JButton("Save");
		setUpListeners();
		fillPanel();
	}

	private void addComponent(int x, int y, JComponent comp) {
		constraints.gridx = x;
		constraints.gridy = y;
		comp.setPreferredSize(new Dimension(60, 14));
		add(comp, constraints);
	}
	private final void setUpListeners() {
		randoms.addActionListener(this);
		colorComboBox.addItemListener(this);;

	}
	private final void fillPanel() {
		addComponent(0, 7, dialogLabel);
		addComponent(1, 7, dialog);
		addComponent(0, 1, colorLabel);
		addComponent(1, 1, colorComboBox);
		addComponent(0, 5, loggerLabel);
		addComponent(1, 5, logger);
		constraints.gridwidth = 2;
		addComponent(0, 0, titleLabel);
		addComponent(0, 2, clearCache);
		addComponent(0, 3, network);
		addComponent(0, 4, randoms);
		addComponent(0, 6, reflectionExplorer);
		addComponent(0, 8, save);
	}

	public SettingsPanel getInstance() {
		return instance == null ? instance = new SettingsPanel() : instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command.toLowerCase()) {
			case "randoms":
				//Grabbing openInterfaceID - for testing -
				eLogger.write(""+Int.getInstance().getInt(Constants.mainClass, "A", Engine.client));
			
				
				break;

	}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == 1) {
			String command = e.getItem().toString();
			switch (command.toLowerCase()) {
				case "black":
				// GROUND WORK FOR COLOR CHANGE//
				System.out.println("Setting color - black");
				break;
					
		}
	}
}

}
