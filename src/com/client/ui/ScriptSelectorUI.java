package com.client.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.client.ui.components.ScriptSelector;

public class ScriptSelectorUI extends JFrame {

	public ScriptSelectorUI() {
		setTitle("Script Selector");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new ScriptSelector(), BorderLayout.CENTER);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

}
