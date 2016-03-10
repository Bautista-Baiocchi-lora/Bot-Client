package com.client.ui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.client.core.Engine;
import com.client.data.Variables;

public class SideBar extends JPanel implements ActionListener {
	private Engine engine;
	private SideBar sideBar;
	private final JButton hide, settings, run, debug, about;
	private JPanel currentPanel;

	public SideBar() {
		sideBar = this;

		hide = new JButton();
		hide.setActionCommand("hide");

		settings = new JButton();
		settings.setActionCommand("settings");

		run = new JButton();
		run.setActionCommand("run");

		about = new JButton();
		about.setActionCommand("about");

		debug = new JButton();
		debug.setActionCommand("debug");

		setLayout(new GridLayout(0, 1));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setUpListeners();
		setImages();
		fillPanel();
		setPreferredSize(new Dimension(50, 100));
	}

	public SideBar getInstance() {
		return sideBar != null ? sideBar : new SideBar();
	}

	private final void setUpListeners() {
		hide.addActionListener(this);
		run.addActionListener(this);
		debug.addActionListener(this);
		settings.addActionListener(this);
		about.addActionListener(this);
	}

	private final void setImages() {
		settings.setIcon(getImageIcon("com/client/ui/images/settings.png"));
		settings.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
		debug.setIcon(getImageIcon("com/client/ui/images/debug.png"));
		debug.setBorder(BorderFactory.createEmptyBorder());
		debug.setContentAreaFilled(false);
		run.setIcon(getImageIcon("com/client/ui/images/run.png"));
		run.setBorder(BorderFactory.createEmptyBorder());
		run.setContentAreaFilled(false);
		about.setIcon(getImageIcon("com/client/ui/images/about.png"));
		about.setBorder(BorderFactory.createEmptyBorder());
		about.setContentAreaFilled(false);
		hide.setIcon(getImageIcon("com/client/ui/images/hide.png"));
		hide.setBorder(BorderFactory.createEmptyBorder());
		hide.setContentAreaFilled(false);
	}

	private final void fillPanel() {
		add(hide);
		hide.setVisible(false);
		add(run);
		add(debug);
		add(settings);
		add(about);
	}

	private ImageIcon getImageIcon(String path) {
		URL resource = getClass().getClassLoader()
				.getResource(path);
		if (resource != null) {
			return new ImageIcon(resource);
		}
		return null;
	}

	private final void switchPanel(JPanel panel) {
		JFrame frame = Variables.getEngine().getBotFrame();
		if (currentPanel != null) {
			if (!currentPanel.equals(panel)) {
				frame.remove(currentPanel);
			}
		}
		currentPanel = panel;
		frame.add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
			case "settings":
				switchPanel(new SettingsPanel());
				hide.setVisible(true);
				break;
			case "hide":
				Variables.getEngine().getBotFrame().remove(currentPanel);
				currentPanel = null;
				hide.setVisible(false);
				break;
			case "run":
				switchPanel(new RunPanel());
				hide.setVisible(true);
				break;
			case "debug":
				switchPanel(new DebugPanel());
				hide.setVisible(true);
				break;
			case "about":
				switchPanel(new AboutPanel());
				hide.setVisible(true);
				break;
			default:
				System.out.println("Invalid input");
				break;
		}
		Variables.getEngine().getBotFrame().revalidate();
		Variables.getEngine().getBotFrame().pack();
		Variables.getEngine().getBotFrame().repaint();
	}
}
