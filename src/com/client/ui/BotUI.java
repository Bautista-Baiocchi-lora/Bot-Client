package com.client.ui;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.client.core.Client;
import com.client.core.Engine;
import com.client.data.Variables;
import com.client.ui.components.GamePanel;
import com.client.ui.components.Logger;
import com.client.ui.components.SideBar;

public class BotUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean focused;
	private static BotUI instance;
	private final SideBar sideBar;
	private final GamePanel gamePanel;
	private final Logger logger;


	public BotUI() {
		if (instance != null) {
			throw new IllegalStateException("Frame already created.");
		}
		instance = this;
		setTitle("El Maestro & Ethan's Botting Client");
		setIconImage(new ImageIcon(
				getClass().getClassLoader().getResource("com/client/ui/images/icon.png"))
						.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
        setLayout(new BorderLayout());
		getContentPane().setBackground(Variables.getClientColor());
		   
		sideBar = new SideBar();
		gamePanel = new GamePanel();
		logger = new Logger();
		fillFrame();
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		openNewTab();
	}


	private final void fillFrame() {
		add(sideBar, BorderLayout.EAST);
		add(gamePanel, BorderLayout.WEST);

		add(logger, BorderLayout.PAGE_END);
	}
	   private void openNewTab() {
		   //ripped from my botclient//
		    
	        Engine.client = new Client();
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


	public static BotUI getInstance() {
		return instance == null ? instance = new BotUI() : instance;
	}
}
