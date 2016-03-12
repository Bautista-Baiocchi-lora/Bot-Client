package com.client.api.wrappers;

import com.client.data.Constants;
import com.client.reflection.Objects;

public class Npc extends Character {
	int index;
	private final Object npc;

	public Npc(final Object npc, final int index) {
		super(npc, index);
		this.npc = npc;
		this.index = index;
	}

	public final NpcDef getDef() {
		return new NpcDef(
				Objects.getInstance().getObjectAccessor(Constants.npcClass, Constants.npcDef, npc));
	}
}
