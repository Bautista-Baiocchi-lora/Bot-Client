package com.client.ui.components.sidebar.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.client.api.method.Game;
import com.client.api.method.GroundItems;
import com.client.api.method.Inventory;
import com.client.api.method.Npcs;
import com.client.api.method.Players;
import com.client.api.method.SceneObjects;
import com.client.api.wrappers.GroundItem;
import com.client.api.wrappers.Item;
import com.client.api.wrappers.Npc;
import com.client.api.wrappers.Player;
import com.client.api.wrappers.SceneObject;
import com.client.core.Client;
import com.client.core.Engine;
import com.client.data.Constants;
import com.client.reflection.Int;
import com.client.ui.components.logger.LogType;
import com.client.ui.components.logger.Logger;

public class DebugPanel extends JPanel implements ActionListener {
	private DebugPanel instance;
	private Thread actionThread;
	private final GridBagConstraints constraints;
	private final JButton interfaces, npcs, objects, groundItems, players, location, bank, inventory, actions, test;
	private final JLabel titleLabel;
	private final Client client = Engine.client;
	public DebugPanel() {
		instance = this;

		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipady = 15;
		constraints.ipadx = 10;
		constraints.insets = new Insets(15, 0, 0, 0);

		titleLabel = new JLabel("Debug", SwingConstants.CENTER);
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
		setLayout(new GridBagLayout());
		setUpListeners();
		fillPanel();
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final String command = e.getActionCommand();
		switch (command) {
		case "Interface":
			Logger.write("Parent Interface: " + Game.getOpenInterfaceID(), LogType.DEBUG);
			break;
		case "Npcs":
			for (final Npc n : Npcs.getNpcs()) {
				if (n != null) {
					Logger.write("Npc Name: " + n.getDef().getName() + " || ID: " + n.getDef().getId() + " || "
							+ n.getLocation() + " || Disctance: " + n.distanceTo(), LogType.DEBUG);
				}
			}
			break;
		case "Objects":
			Logger.write("Objects with a distance less than 15 tiles.", LogType.DEBUG);
			for (final SceneObject s : SceneObjects.getSceneObjects()) {
				if (s != null) {
					if (s.distanceTo() < 15) {
						Logger.write("Object ID: " + s.getId() + " || " + s.getLocation() + " || Distance: "
								+ s.distanceTo(), LogType.DEBUG);
					}
				}
			}
			break;
		case "Ground Items":
			for (final GroundItem g : GroundItems.getGroundItems()) {
				if (g != null) {
					Logger.write("GroundItem ID: " + g.getId() + " || " + g.getLocation() + " || " + g.distanceTo());
				}
			}
			break;
		case "Players":
			for (final Player p : Players.getPlayers()) {
				if (p != null) {
					Logger.write("Player Name: " + p.getName() + " || " + p.getLocation() + " || Distance: "
							+ p.distanceTo(), LogType.DEBUG);
				}
			}
			break;
		case "Location":
			Logger.write("" + Players.myPlayer().getLocation(), LogType.DEBUG);
			break;
		case "Bank":
			
			break;
		case "Inventory":
			Logger.write("Inventory Count: " + Inventory.getCount(), LogType.DEBUG);
			for (final Item i : Inventory.getItems()) {
				if (i != null) {
					Logger.write("Item: " + i.getId() + " || Count: " + i.getStackSize() + " || Slot: " + i.getSlot(),
							LogType.DEBUG);
				}
			}
			break;
		case "Actions":
			if (actionThread == null) {
				actionThread = new Thread() {
					@Override
					public void run() {
						
						while (!actionThread.isInterrupted()) {
							Logger.write("Action Listener Started!", LogType.CLIENT);
							while (!actionThread.isInterrupted()) {
								final int id = Int.getInstance().getFromIntArray(Constants.mainClass,
										Constants.menuActionID, client.getClient(), 1);
								final int cmd1 = Int.getInstance().getFromIntArray(Constants.mainClass,
										Constants.menuActionCmd1, client.getClient(), 1);
								final int cmd2 = Int.getInstance().getFromIntArray(Constants.mainClass,
										Constants.menuActionCmd2, client.getClient(), 1);
								final int cmd3 = Int.getInstance().getFromIntArray(Constants.mainClass,
										Constants.menuActionCmd3, client.getClient(), 1);
								final int cmd4 = Int.getInstance().getFromIntArray(Constants.mainClass,
										Constants.menuActionCmd4, client.getClient(), 1);

								Logger.write("ID: " + id + " || Action #1: " + cmd1 + " || Action #2: " + cmd2
										+ " || Action #3: " + cmd3 + " || Action #4:" + cmd4, LogType.DEBUG);
								try {
									Thread.sleep(500);
								} catch (final InterruptedException e) {
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
				Logger.write("Action Listener Stopped.", LogType.CLIENT);
			}
			break;
		case "Test":

			for (final SceneObject s : SceneObjects.getSceneObjects()) {
				if(s.getId() == 4875)
				if (s != null) {
					if (s.distanceTo() < 15) {
						Logger.write("Found Stall: "+s.getId(), LogType.SCRIPT);
						s.interact(1);
					}
				}
			}

			break;
		default:
			Logger.writeWarning("Error in debug panel action listener.");
			break;
		}
	}

	private void addComponent(final int x, final int y, final JComponent comp) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(comp, constraints);
	}

	private void fillPanel() {
		addComponent(0, 0, titleLabel);
		addComponent(0, 1, npcs);
		addComponent(0, 2, objects);
		addComponent(0, 3, groundItems);
		addComponent(0, 4, players);
		addComponent(0, 5, location);
		addComponent(0, 6, bank);
		addComponent(0, 7, inventory);
		addComponent(0, 8, actions);
		addComponent(0, 9, test);
		addComponent(0, 10, interfaces);
	}

	public DebugPanel getDebugPanel() {
		return instance == null ? instance = new DebugPanel() : instance;

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

}
