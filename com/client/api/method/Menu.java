package com.client.api.method;


import com.client.api.wrappers.GroundItem;
import com.client.api.wrappers.SceneObject;
import com.client.ui.components.logger.Logger;

public class Menu {
	
	public static final int ACTION_TAKE_ITEM = 234;
	
	
	public static void interact(final com.client.api.wrappers.Character character, final int actionIndex) {
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

	//244 1107-516-
	
	
	
	public static void interact(SceneObject object, int actionIndex) {
		int actionId = 900;
		switch (actionIndex) {
		case 1:
			actionId = 900;
			break;
		case 2:
			actionId = 516;
			break;
		case 3:
			actionId = 1107;
			break;
		case 4:
			actionId = 1226;
			break;
		}
		sendAction(actionId, object.getHash(), object.getRegionX(), object.getRegionY(), object.getId(), 1);
	}
	
	public static void interact(GroundItem item, int action) {
		int actionId = 652;
		switch (action) {
		case 0:
			actionId = 652;
			break;
		case 1:
			actionId = 567;
			break;
		case 2:
			actionId = 234;
			break;
		case 3:
			actionId = 244;
			break;
		case 4:
			actionId = 213;
			break;
		}
		sendAction(actionId, item.getId(), item.getRegionX(), item.getRegionY());
	}

	public static void take(GroundItem item) {
		sendAction(ACTION_TAKE_ITEM, item.getId(), item.getRegionX(), item.getRegionY());
	}

	public static void sendAction(final int action, final int cmd1, final int cmd2, final int cmd3) {
		sendAction(action, cmd1, cmd2, cmd3, 1);
	}

	public static void sendAction(final int action, final int cmd1, final int cmd2, final int cmd3, final int index) {
		sendAction(action, cmd1, cmd2, cmd3, 0, index);
	}

	public static void sendAction(final int action, final int cmd1, final int cmd2, final int cmd3, final int cmd4,
			final int index) {

		Game.setMenuAction1(cmd1, index);

		Game.setMenuAction2(cmd2, index);
		Game.setMenuAction3(cmd3, index);
		Game.setMenuAction4(cmd4, index);
		Game.setMenuActionId(action, index);
		Logger.write("1: " + cmd1 + " 2: " + cmd2 + " 3: " + cmd3 + " 4: " + cmd4 + " id: " + action);

		Game.doAction(index);
	}
}
