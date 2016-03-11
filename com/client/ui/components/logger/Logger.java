package com.client.ui.components.logger;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class Logger extends JTextArea {
	private static JTextArea logArea;

	public static void write(final String str) {
		logArea.append("[N/A]   " + str + "\n");
	}

	public static void write(final String str, final LogType type) {
		logArea.append("[" + type.getType() + "]   " + str + "\n");
	}

	public static void writeException(final String str) {
		logArea.append("[N/A][EXCEPTION]   " + str + "\n");
	}

	public static void writeException(final String str, final LogType type) {
		logArea.append("[" + type.getType() + "][EXCEPTION]   " + str + "\n");
	}

	public static void writeWarning(final String str) {
		logArea.append("[N/A][WARNING]   " + str + "\n");
	}

	public static void writeWarning(final String str, final LogType type) {
		logArea.append("[" + type.getType() + "][WARNING]   " + str + "\n");
	}

	public Logger() {
		super(8, 5);
		logArea = this;
		setEditable(false);
		setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		setLineWrap(true);
		final DefaultCaret caret = (DefaultCaret) getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}

}
