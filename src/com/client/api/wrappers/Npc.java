package com.client.api.wrappers;

import com.client.data.Constants;
import com.client.test.Objects;

public class Npc extends Character {
    int index;
    private Object npc;

    public Npc(Object npc, int index) {
        super(npc, index);
        this.npc = npc;
        this.index = index;
    }


    public final NpcDef getDef() {
        return new NpcDef(Objects.getInstance().getObjectAccessor(Constants.npcClass, Constants.npcDef, npc));
    }
}
