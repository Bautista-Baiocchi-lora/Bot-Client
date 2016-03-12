package com.client.api.wrappers;

import com.client.data.Constants;
import com.client.reflection.Longs;
import com.client.reflection.Strings;

public class NpcDef {
	private final Object npcdef;

	public NpcDef(final Object npcdef) {

		this.npcdef = npcdef;
	}

	public int getId() {
		return (int) Longs.getInstance().getLong(Constants.npcDefClass, Constants.getNpcID, npcdef);
	}

	public String getName() {
		return Strings.getInstance().getString(Constants.npcDefClass, Constants.getNpcName, npcdef);
	}
}
