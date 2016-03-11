package com.client.ui.components.logger;

import javax.swing.JTextArea;

public class Logger extends JTextArea {
	private static Logger instance;

	public static void write(final String str) {
		instance.append("[Bot] \t" + str + "\n");
		instance.setCaretPosition(instance.getDocument().getLength());
	}

	public static void writeException(final String str) {
		instance.append("[Bot][Exception] \t" + str + "\n");
		instance.setCaretPosition(instance.getDocument().getLength());
	}

	public Logger() {
		instance = this;
	}

	public Logger getInstance() {
		return instance == null ? instance = new Logger() : instance;
	}

}
