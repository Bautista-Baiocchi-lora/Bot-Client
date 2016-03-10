package com.client.core;



import javax.swing.SwingUtilities;


import com.client.ui.BotUI;
import com.client.ui.components.GamePanel;
import com.client.ui.components.eLogger;



public class Engine {
	private static Engine instance;
	private static BotUI frame;
	public static Client client;
	public Engine() {
		if (instance == null) {
			instance = this;
		
			initiateFrame();
		}
	}

	private void initiateFrame() {
		try {
			   SwingUtilities.invokeAndWait(new Runnable() {
		            public void run() {    	 
		                client = new Client();               
		                client.init();
		                frame = new BotUI();
		        		frame.setVisible(true);
		        		new eLogger(GamePanel.getLogArea());
		                eLogger.write("We have sucessfully loaded all components.");

		            }

		        });

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
   

	public static BotUI getBotFrame() {
		return frame;
	}

}
