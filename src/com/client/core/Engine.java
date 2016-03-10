package com.client.core;

import com.client.ui.BotUI;

public class Engine {
	private static Engine instance;
	private static BotUI frame;

	public Engine() {
		if (instance == null) {
			instance = this;
			initiateFrame();
		}
	}

	private void initiateFrame() {
		frame = new BotUI();
		frame.setVisible(true);
	}

	public static BotUI getBotFrame() {
		return frame;
	}

}
