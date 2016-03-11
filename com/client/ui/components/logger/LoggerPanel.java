package com.client.ui.components.logger;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class LoggerPanel extends JPanel {
	private final JScrollPane scrollPane;

	public LoggerPanel(final Logger logger) {
		scrollPane = new JScrollPane(logger, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
	}

}
