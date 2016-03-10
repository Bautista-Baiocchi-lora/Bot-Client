package com.client.ui.components;

import javax.swing.*;

public class eLogger {

    static JTextArea logArea;

    public eLogger(JTextArea logArea) {
        eLogger.logArea = logArea;
    }

    public static void write(String str) {
        logArea.append("[Bot] \t" + str + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    public static void writeException(String str) {
        logArea.append("[Bot][Exception] \t" + str + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    public static void setText(String str) {
        logArea.setText(str);
    }
}