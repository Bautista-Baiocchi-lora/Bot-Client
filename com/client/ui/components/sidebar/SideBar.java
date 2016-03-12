package com.client.ui.components.sidebar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.client.core.Engine;
import com.client.data.Variables;
import com.client.ui.components.Scroller;
import com.client.ui.components.sidebar.panels.AboutPanel;
import com.client.ui.components.sidebar.panels.DebugPanel;
import com.client.ui.components.sidebar.panels.RunPanel;
import com.client.ui.components.sidebar.panels.SettingsPanel;

public class SideBar extends JPanel implements ActionListener {
	private Engine engine;
	private final SideBar sideBar;
	private final GridBagConstraints constraints;
	private final JButton hide, settings, run, debug, about;
	private Scroller currentPane;

	public SideBar() {
		sideBar = this;

		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipady = 15;
		constraints.ipadx = 10;
		constraints.insets = new Insets(35, 0, 0, 0);

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

		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setUpListeners();
		setImages();
		fillPanel();
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final String command = e.getActionCommand();
		switch (command) {
			case "settings":
				switchPane(new Scroller(new SettingsPanel()));
				hide.setVisible(true);
				break;
			case "hide":
				Variables.getEngine().getBotFrame().remove(currentPane);
				currentPane = null;
				hide.setVisible(false);
				break;
			case "run":
				switchPane(new Scroller(new RunPanel()));
				hide.setVisible(true);
				break;
			case "debug":
				switchPane(new Scroller(new DebugPanel()));
				hide.setVisible(true);
				break;
			case "about":
				switchPane(new Scroller(new AboutPanel()));
				hide.setVisible(true);
				break;
			default:
				System.out.println("Invalid input");
				break;
		}
		Variables.getEngine().getBotFrame().pack();
	}

	private void addComponent(final int x, final int y, final JComponent comp) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(comp, constraints);
	}

	private final void fillPanel() {
		addComponent(0, 0, hide);
		hide.setVisible(false);
		addComponent(0, 1, run);
		addComponent(0, 2, debug);
		addComponent(0, 3, settings);
		addComponent(0, 4, about);
	}

	private ImageIcon getImageIcon(final String path) {
		final URL resource = getClass().getClassLoader()
				.getResource(path);
		if (resource != null) {
			return new ImageIcon(resource);
		}
		return null;
	}

	public SideBar getInstance() {
		return sideBar != null ? sideBar : new SideBar();
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

	private final void setUpListeners() {
		hide.addActionListener(this);
		run.addActionListener(this);
		debug.addActionListener(this);
		settings.addActionListener(this);
		about.addActionListener(this);
	}

	private final void switchPane(final Scroller pane) {
		final JFrame frame = Variables.getEngine().getBotFrame();
		if (currentPane != null) {
			if (!currentPane.equals(pane)) {
				frame.remove(currentPane);
			}
		}
		currentPane = pane;
		frame.add(pane, BorderLayout.CENTER);
	}
}
