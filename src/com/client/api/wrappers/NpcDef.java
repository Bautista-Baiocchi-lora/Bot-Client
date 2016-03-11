package com.client.api.wrappers;

import com.client.data.Constants;
import com.client.test.Longs;
import com.client.test.Strings;

public class NpcDef {
    private Object npcdef;

    public NpcDef(Object npcdef) {

        this.npcdef = npcdef;
    }

    public String getName() {
        return Strings.getInstance().getString(Constants.npcDefClass, Constants.getNpcName, npcdef);
    }

    public int getId() {
        return (int) Longs.getInstance().getLong(Constants.npcDefClass, Constants.getNpcID, npcdef);
    }
}
