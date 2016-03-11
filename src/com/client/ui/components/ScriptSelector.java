package com.client.ui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;

public class ScriptSelector extends JPanel {
	private GridBagConstraints constraints;
	private final JButton start;
	private final JTree tree;

	public ScriptSelector() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(400, 300));
		tree = new JTree();
		start = new JButton("Start");
		fillPanel();
	}

	private void fillPanel() {
		add(tree, BorderLayout.PAGE_START);
		add(start, BorderLayout.PAGE_END);
	}

}
