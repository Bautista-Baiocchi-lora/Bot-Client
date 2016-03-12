package com.client.api.wrappers;

import com.client.api.locatable.Tile;
import com.client.api.method.Calculations;
import com.client.api.method.Game;
import com.client.api.method.Menu;
import com.client.api.method.Npcs;
import com.client.api.method.Players;
import com.client.data.Constants;
import com.client.reflection.Int;

public class Character {
	private final Object character;
	private final int index;

	public Character(final Object character, final int index) {
		this.character = character;
		this.index = index;
	}

	public int distanceTo() {
		return (int) Calculations.distanceTo(getLocation());
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Character other = (Character) obj;
		if (character == null) {
			if (other.character != null) {
				return false;
			}
		} else if (!character.equals(other.character)) {
			return false;
		}
		if (index != other.index) {
			return false;
		}
		return true;
	}

	public int getAnimation() {
		return Int.getInstance().getInt(Constants.characterClass, Constants.animation, character);
	}

	public int getIndex() {
		return index;
	}

	public final Character getInteractingCharacter() {
		int index = Int.getInstance().getInt(Constants.characterClass,
				Constants.interactingCharacter, character);
		if ((index != -1) && (index < 32768)) {
			final Object[] oNpcs = Npcs.getNpcArray();
			return new Npc(oNpcs[index], index);
		} else if (index >= 32768) {
			index -= 32768;
			try {
				final Object[] oPlayers = Players.getPlayerArray();
				if (oPlayers[index] == null) {
					return Players.myPlayer();
				}
				return new Player(oPlayers[index], index);
			} catch (final Throwable t) {
				return Players.myPlayer();
			}
		}
		return null;
	}

	public Tile getLocation() {
		return new Tile(Game.getBaseX() + getX(), Game.getBaseY() + getY(), Game.getPlane());
	}

	public int getLoopCycleStatus() {
		return Int.getInstance().getInt(Constants.characterClass, Constants.loopCycleStatus,
				character);
	}

	public int getX() {
		return Int.getInstance().getInt(Constants.characterClass, Constants.absX, character) >> 7;
	}

	public int getY() {
		return Int.getInstance().getInt(Constants.characterClass, Constants.absY, character) >> 7;
	}

	public void interact(final int i) {
		Menu.interact(this, i);
	}

	public boolean isInCombat() {
		return getLoopCycleStatus() > Game.getLoopCycle();
	}

	public boolean isWalking() {
		return Int.getInstance().getInt(Constants.characterClass, Constants.smallXYIndex,
				character) != 0;
	}

}
