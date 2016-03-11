package com.client.ui;

import java.applet.Applet;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import com.client.data.Variables;
import com.client.ui.components.GamePanel;
import com.client.ui.components.SideBar;
import com.client.ui.components.logger.Logger;

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
		gamePanel = new GamePanel(getApplet());
		logger = new Logger();
		setResizable(false);
		setLocationRelativeTo(null);
		fillFrame();
		pack();
	}

	private final void fillFrame() {
		add(sideBar, BorderLayout.EAST);
		add(gamePanel, BorderLayout.WEST);
		add(logger, BorderLayout.PAGE_END);
	}

	private Applet getApplet() {
		final Applet applet = Variables.getEngine().getClient().getApplet();
		if (applet != null) {
			if (Variables.getEngine().getClient().getClient() == null) {
				Variables.getEngine().getClient().setClientInstance(applet);
			}
			return applet;
		}
		JOptionPane.showMessageDialog(this, "Could not open new tab.");
		return null;
	}

	public BotUI getInstance() {
		return instance == null ? instance = new BotUI() : instance;
	}
}
