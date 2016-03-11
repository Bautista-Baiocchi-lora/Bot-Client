package com.client.ui.components.logger;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class LoggerPanel extends JScrollPane {
	private LoggerPanel instance;
	private final Logger logger;
	private final JScrollPane scrollPane;

	public LoggerPanel(final Logger logger) {
		instance = this;
		this.logger = logger;
		scrollPane = new JScrollPane(logger, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		logger.setEditable(false);
		logger.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		setLayout(new BorderLayout());
		fillPanel();
	}

	private void fillPanel() {
		add(scrollPane, BorderLayout.PAGE_START);
	}

	public LoggerPanel getInstance() {
		return instance == null ? instance = new LoggerPanel(new Logger()) : instance;
	}

}
