package com.client.ui;

import java.applet.Applet;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import com.client.core.Engine;
import com.client.data.Variables;
import com.client.ui.components.GamePanel;
import com.client.ui.components.logger.Logger;
import com.client.ui.components.sidebar.SideBar;

public class BotUI extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected boolean focused;
	private BotUI instance;
	private final SideBar sideBar;
	private final GamePanel gamePanel;
	private final Logger logger;

	public BotUI() {
		if (instance != null) {
			throw new IllegalStateException("Frame already created.");
		}
		instance = this;
		setTitle("El Maestro & Ethan's Botting Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout());
		getContentPane().setBackground(Variables.getClientColor());
		sideBar = new SideBar();
		gamePanel = new GamePanel();
		logger = new Logger();
		setResizable(false);
		setLocationRelativeTo(null);
		fillFrame();
		pack();
		openNewTab();
	}

	private final void fillFrame() {
		add(sideBar, BorderLayout.EAST);
		add(gamePanel, BorderLayout.WEST);
		add(logger, BorderLayout.PAGE_END);
	}
	 private void openNewTab() {
		 
	        Applet applet = Engine.client.getApplet();

	        if (applet != null) {
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(applet, "Center");
	            gamePanel.add(panel);
	            if (Engine.client.getClient() == null) {
	            	Engine.client.setClientInstance(applet);
	            }
        
	            applet.init();
	            applet.start();
	    
	         
	        } else {
	            JOptionPane.showMessageDialog(this, "Could not open new tab.");
	        }
	    }
	

	public BotUI getInstance() {
		return instance == null ? instance = new BotUI() : instance;
	}
}
