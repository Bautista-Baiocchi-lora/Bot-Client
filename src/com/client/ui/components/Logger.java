package com.client.ui.components;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class Logger extends JPanel {
	private Logger instance;
	private DefaultListModel<String> model;
	private JList<String> list;

	public Logger() {
		instance = this;
		setLayout(new BorderLayout());
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		model.addElement("Client started");
		fillPanel();
	}

	private void fillPanel() {
		add(list, BorderLayout.CENTER);
	}

	public Logger getInstance() {
		return instance == null ? instance = new Logger() : instance;
	}

}
