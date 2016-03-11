package com.client.api.wrappers;

import com.client.api.method.Npcs;
import com.client.api.method.Players;
import com.client.data.Constants;
import com.client.test.Int;
import com.client.test.Strings;

public class Player extends Character {
    int index;
    private Object player;

    public Player(Object player, int index) {
        super(player, index);
        this.player = player;
        this.index = index;
    }

    public int getCombatLevel() {
        return Int.instance.getInt(Constants.playerClass, Constants.playerLevel, player);
    }

    public String getName() {
        return Strings.getInstance().getString(Constants.playerClass, Constants.playerName, player);
    }
    
    public int[] getEquipment() {
    	return Int.getInstance().getIntArray(Constants.playerClass, Constants.playerEquipment, player);
    }
    public boolean isUnderAttack() {
		for(Npc n : Npcs.getNpcs()) {
			if(n != null) {
				if(n.getInteractingCharacter() != null) {
					if(n.getInteractingCharacter().equals(Players.myPlayer())) {
						if(Players.myPlayer().getInteractingCharacter() != null) {
							if(Players.myPlayer().getInteractingCharacter().equals(n)) {
								return true;
							}
						}

					}
				}
			}
		}
		return false;
	}
    public String getInteractingName() {
		for(Npc n : Npcs.getNpcs()) {
			if(n != null) {
				if(n.getInteractingCharacter() != null) {
					if(n.getInteractingCharacter().equals(Players.myPlayer())) {
						return n.getDef().getName();
					}
				}
			}
		}
		return null;
	}
}