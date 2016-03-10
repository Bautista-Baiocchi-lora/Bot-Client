package com.client.ui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.client.data.Variables;
import com.client.ui.components.GamePanel;
import com.client.ui.components.Logger;
import com.client.ui.components.SideBar;

public class BotUI extends JFrame {
	private static BotUI instance;
	private final SideBar sideBar;
	private final GamePanel gamePanel;
	private final Logger logger;

	public BotUI() {
		if (instance != null) {
			throw new IllegalStateException("Frame already created.");
		}
		instance = this;
		setTitle("Botting Client");
		setIconImage(new ImageIcon(
				getClass().getClassLoader().getResource("com/client/ui/images/icon.png"))
						.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Variables.getClientColor());
		sideBar = new SideBar();
		gamePanel = new GamePanel();
		logger = new Logger();
		fillFrame();
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
	}

	private final void fillFrame() {
		add(sideBar, BorderLayout.EAST);
		add(gamePanel, BorderLayout.WEST);
		add(logger, BorderLayout.PAGE_END);
	}

	public static BotUI getInstance() {
		return instance == null ? instance = new BotUI() : instance;
	}
}
