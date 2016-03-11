package com.client.ui.components.logger;

import javax.swing.JScrollPane;

public class LoggerPane extends JScrollPane {

	public LoggerPane(Logger logger) {
		super(logger, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}

}
