package com.client.api.method;

import com.client.ui.components.logger.Logger;

public class Menu {
	public static void interact(final com.client.api.wrappers.Character character,
			final int actionIndex) {
		int actionId = 20;
		switch (actionIndex) {
			case 0:
				actionId = 20;
				break;
			case 1:
				actionId = 412;
				break;
			case 2:
				actionId = 225;
				break;
			case 3:
				actionId = 965;
				break;
			case 4:
				actionId = 478;
				break;
		}
		sendAction(actionId, character.getIndex(), 0, 0);
	}

	public static void sendAction(final int action, final int cmd1, final int cmd2,
			final int cmd3) {
		sendAction(action, cmd1, cmd2, cmd3, 1);
	}

	public static void sendAction(final int action, final int cmd1, final int cmd2, final int cmd3,
			final int index) {
		sendAction(action, cmd1, cmd2, cmd3, 0, index);
	}

	public static void sendAction(final int action, final int cmd1, final int cmd2, final int cmd3,
			final int cmd4, final int index) {

		Game.setMenuAction1(cmd1, index);

		Game.setMenuAction2(cmd2, index);
		Game.setMenuAction3(cmd3, index);
		Game.setMenuAction4(cmd4, index);
		Game.setMenuActionId(action, index);
		Logger.write(
				"1: " + cmd1 + " 2: " + cmd2 + " 3: " + cmd3 + " 4: " + cmd4 + " id: " + action);

		Game.doAction(index);
	}
}
