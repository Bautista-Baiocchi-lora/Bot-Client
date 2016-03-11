package com.client.api.method;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.client.api.utils.Filter;
import com.client.api.wrappers.Npc;
import com.client.core.Client;
import com.client.core.Engine;
import com.client.data.Constants;
import com.client.test.Objects;

public class Npcs {
	   public static Client client = Engine.client;
    private static final Comparator<Npc> NEAREST_SORTER = new Comparator<Npc>() {
     
        @Override
        public int compare(Npc n1, Npc n2) {
            return n1.distanceTo() - n2.distanceTo();
        }

    };
    private static final Filter<Npc> ALL_FILTER = new Filter<Npc>() {

        @Override
        public boolean accept(Npc n) {
            return true;
        }

    };

    public static Object[] getNpcArray() {
    	return Objects.getInstance().getObjectArray(Constants.mainClass, Constants.npcArray, client.getClient(), Constants.npcClass);
}

    public static final Npc[] getNpcs(final Filter<Npc> filter) {

        ArrayList<Npc> npcList = new ArrayList<>();
        Object[] oNpcs = getNpcArray();
        for (int i = 0; i < oNpcs.length; i++) {
            if (oNpcs[i] == null) {
                continue;
            }
            
            final Npc npc = new Npc(oNpcs[i], i);
            if (filter.accept(npc)) {
                npcList.add(npc);
            }
        }
        return npcList.toArray(new Npc[npcList.size()]);
    }

    public static final Npc[] getNpcs() {
        return getNpcs(ALL_FILTER);
    }

    public static final Npc[] getNearest(final Filter<Npc> filter) {
        final Npc[] npcs = getNpcs(filter);
        Arrays.sort(npcs, NEAREST_SORTER);
        return npcs;
    }

    public static final Npc[] getNearest(final int... ids) {
        final Npc[] npcs = getNpcs(new Filter<Npc>() {

            @Override
            public boolean accept(Npc npc) {
                for (final int id : ids) {
                    if (id == npc.getDef().getId()) {
                        return true;
                    }
                }
                return false;
            }

        });
        Arrays.sort(npcs, NEAREST_SORTER);
        return npcs;
    }

    public static final Npc[] getNearest(final String... names) {
        final Npc[] npcs = getNpcs(new Filter<Npc>() {

            @Override
            public boolean accept(Npc npc) {
                for (final String name : names) {
                	if(npc != null) {
                    if (npc.getDef().getName().toLowerCase().equals(name.toLowerCase())) {
                        return true;
                    }
                    }
                }
                return false;
            }

        });
        Arrays.sort(npcs, NEAREST_SORTER);
        return npcs;
    }

    public static final Npc[] getNearest() {
        return getNearest(ALL_FILTER);
    }
}
