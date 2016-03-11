package com.client.ui.components.sidebar.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.client.api.method.Game;
import com.client.api.method.Npcs;
import com.client.api.method.Players;
import com.client.api.wrappers.Npc;
import com.client.api.wrappers.Player;
import com.client.core.Client;
import com.client.core.Engine;
import com.client.data.Constants;
import com.client.test.Int;
import com.client.ui.components.logger.Logger;

public class DebugPanel extends JPanel implements ActionListener {
	private DebugPanel instance;
	private Thread actionThread;
	private final GridBagConstraints constraints;
	private final JButton interfaces, npcs, objects, groundItems, players, location, bank,
			inventory, actions, test;
	private Client client = Engine.client;
	boolean debugActions = false;
	int i = 0;
	public DebugPanel() {
		instance = this;

		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipady = 15;
		constraints.ipadx = 10;
		constraints.insets = new Insets(10, 0, 0, 0);

		interfaces = new JButton("Interface");
		npcs = new JButton("Npcs");
		objects = new JButton("Objects");
		groundItems = new JButton("Ground Items");
		players = new JButton("Players");
		location = new JButton("Location");
		bank = new JButton("Bank");
		inventory = new JButton("Inventory");
		actions = new JButton("Actions");
		test = new JButton("Test");

		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new GridLayout());
		setUpListeners();
		fillPanel();
	}

	private void addComponent(final int x, final int y, final JComponent comp) {
		constraints.gridx = x;
		constraints.gridy = y;
		comp.setPreferredSize(new Dimension(60, 14));
		add(comp, constraints);
	}

	private void fillPanel() {
		addComponent(0, 0, interfaces);
		addComponent(0, 1, npcs);
		addComponent(0, 2, objects);
		addComponent(0, 3, groundItems);
		addComponent(0, 4, players);
		addComponent(0, 5, location);
		addComponent(0, 6, bank);
		addComponent(0, 7, inventory);
		addComponent(0, 8, actions);
		addComponent(0, 9, test);
	}

	private void setUpListeners() {
		interfaces.addActionListener(this);
		npcs.addActionListener(this);
		objects.addActionListener(this);
		groundItems.addActionListener(this);
		players.addActionListener(this);
		location.addActionListener(this);
		bank.addActionListener(this);
		inventory.addActionListener(this);
		actions.addActionListener(this);
		test.addActionListener(this);
	}

	public DebugPanel getDebugPanel() {
		return instance == null ? instance = new DebugPanel() : instance;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
			case "Interface":
				Logger.write("Parent Interface: "+Game.getOpenInterfaceID());
				break;
			case "Npcs":
				for(Npc n : Npcs.getNpcs()) {
					if(n != null) {
						Logger.write("Name: "+n.getDef().getName() + " - "+n.getDef().getId() + " || Location: "+n.getLocation());
					}
				}
				break;
			case "Objects":
				break;
			case "Ground Items":
				break;
			case "Players":
				for(Player p : Players.getPlayers()) {
					if(p != null) {
						Logger.write("Name: "+p.getName()+" || Location: "+p.getLocation());
					}
				}
				break;
			case "Location":
				break;
			case "Bank":
				break;
			case "Inventory":
				break;
			case "Actions":
				break;
			case "Test":
				if(debugActions) {
			if (actionThread == null) {
				actionThread = new Thread() {
					public void run() {
						while (!actionThread.isInterrupted()) {
							// 27983909
							Logger.write("Action Listener Started!");
							while (!actionThread.isInterrupted()) {
								int id = Int.getInstance().getFromIntArray(Constants.mainClass, Constants.menuActionID,
										client.getClient(), 1);
								int cmd1 = Int.getInstance().getFromIntArray(Constants.mainClass,
										Constants.menuActionCmd1, client.getClient(), 1);
								int cmd2 = Int.getInstance().getFromIntArray(Constants.mainClass,
										Constants.menuActionCmd2, client.getClient(), 1);
								int cmd3 = Int.getInstance().getFromIntArray(Constants.mainClass,
										Constants.menuActionCmd3, client.getClient(), 1);
								int cmd4 = Int.getInstance().getFromIntArray(Constants.mainClass,
										Constants.menuActionCmd4, client.getClient(), 1);

								Logger.write("cmd1: " + cmd1 + " cmd2: " + cmd2 + " cmd3: " + cmd3 + " cmd4 :" + cmd4
										+ " id: " + id);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				};

				actionThread.start();
			} else {
				actionThread.interrupt();
				actionThread = null;
				Logger.write("Stopped the shit");
			}
				} else {
					
					final Npc[] n1 = Npcs.getNearest("Man");
					Npc n = null;
					if (n1.length > 0)
						n = n1[0];
					if(n != null) {
						Logger.write("Found: "+n.getDef().getName());
						n.interact(i);
						i++;
					}
				}
				break;
			default:
				Logger.writeWarning("Error in debug panel action listener.");
				break;
		}
	}

}
