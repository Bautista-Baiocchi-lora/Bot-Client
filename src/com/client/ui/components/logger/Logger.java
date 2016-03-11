package com.client.ui.components.logger;

import javax.swing.JTextArea;

public class Logger  {
	public static JTextArea logArea;
	
	public static void write(final String str) {
		logArea.append("[Bot] \t" + str + "\n");
		logArea.setCaretPosition(logArea.getDocument().getLength());
	}

	public static void writeException(final String str) {
		logArea.append("[Bot][EXCEPTION] \t" + str + "\n");
		logArea.setCaretPosition(logArea.getDocument().getLength());
	}

	public static void writeWarning(final String str) {
		logArea.append("[Bot][WARNING] \t" + str + "\n");
		logArea.setCaretPosition(logArea.getDocument().getLength());
	}

	public Logger(JTextArea logArea) {
		Logger.logArea = logArea;
	}



}
