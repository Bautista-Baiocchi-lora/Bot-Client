package com.client.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.client.ui.components.ScriptSelector;

public class ScriptSelectorUI extends JFrame {

	public ScriptSelectorUI() {
		setTitle("Script Selector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new ScriptSelector(), BorderLayout.CENTER);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

}
