package com.client.api.method;

public class Menu {
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
		// Game.setMenuAction4(cmd4, index);
		Game.setMenuActionId(action, index);
		// Logger.write("1: "+cmd1+" 2: "+cmd2+" 3: "+cmd3+" 4: "+cmd4+" id: "+action);

		Game.doAction(index);
	}
}
