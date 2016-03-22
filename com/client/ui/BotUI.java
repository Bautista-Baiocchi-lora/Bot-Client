package com.client.ui;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import com.client.core.Engine;
import com.client.data.Variables;
import com.client.ui.components.GamePanel;
import com.client.ui.components.logger.Logger;
import com.client.ui.components.logger.LoggerPanel;
import com.client.ui.components.sidebar.SideBar;

public class BotUI extends JFrame implements WindowListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected boolean focused;
	private BotUI instance;
	private final SideBar sideBar;
	private final GamePanel gamePanel;
	private final LoggerPanel loggerPanel;

	public BotUI() {
		if (instance != null) {
			throw new IllegalStateException("Frame already created.");
		}
		instance = this;
		setTitle("El Maestro & Ethan's Reflection Client");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		loggerPanel = new LoggerPanel(new Logger());
		setResizable(false);
		setLocationRelativeTo(null);
		confirmOnClose();
		fillFrame();
		pack();
		addApplet();
		System.out.println(gamePanel.getSize().getWidth());
		System.out.println(gamePanel.getSize().getHeight());
	}

	private void addApplet() {
		final Applet applet = Engine.client.getApplet();
		if (applet != null) {
			gamePanel.add(applet, "Center");
			if (Engine.client.getClient() == null) {
				Engine.client.setClientInstance(applet);
			}
			applet.init();
			applet.start();
		} else {
			JOptionPane.showMessageDialog(this, "Could not open new tab.");
		}
	}

	private final void fillFrame() {
		add(loggerPanel, BorderLayout.PAGE_END);
		add(sideBar, BorderLayout.LINE_END);
		add(gamePanel, BorderLayout.LINE_START);
	}

	public BotUI getInstance() {
		return instance == null ? instance = new BotUI() : instance;
	}

	public void confirmOnClose() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(new JLabel("", JLabel.CENTER),
						"Are you sure you want to close the client?");
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
