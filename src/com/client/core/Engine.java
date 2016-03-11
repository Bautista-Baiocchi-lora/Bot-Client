package com.client.core;

import javax.swing.SwingUtilities;

import com.client.ui.BotUI;
import com.client.ui.components.logger.Logger;

public class Engine {
	private Engine instance;
	private BotUI frame;
	public Client client;

	public Engine() {
		instance = this;
		initiateFrame();
	}

	public BotUI getBotFrame() {
		return frame;
	}

	public Client getClient() {
		return client;
	}

	public Engine getInstance() {
		return instance == null ? instance = new Engine() : instance;
	}

	private void initiateFrame() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					client = new Client();
					client.initiate();
					frame = new BotUI();
					frame.setVisible(true);
					Logger.write("We have sucessfully loaded all components.");
				}

			});

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
