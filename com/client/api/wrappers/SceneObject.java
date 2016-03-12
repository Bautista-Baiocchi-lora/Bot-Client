package com.client.api.wrappers;

import com.client.api.locatable.Locatable;
import com.client.api.locatable.Tile;
import com.client.api.method.Calculations;
import com.client.api.method.Game;

public class SceneObject implements Locatable {

	public static final int TYPE_INTERACTIVE = 4; // object5

	public SceneObjectTile accessor;
	private int type;

	public SceneObject(SceneObjectTile accessor) {
		this.accessor = accessor;

	}

	public final int getHash() {
		return accessor.getHash();
	}

	public final int getId() {
		return accessor.getHash() >> 14 & 0x7FFF;
	}

//	public void interact(int actionIndex) {
//		Menu.interact(this, actionIndex);
//	}


	public final Tile getLocation() {
		return new Tile(Game.getBaseX() + getRegionX(), Game.getBaseY() + getRegionY());
	}


	public final int getRegionX() {
		return accessor.getHash() & 0x7f;
	}

	public final int getRegionY() {
		return accessor.getHash() >> 7 & 0x7f;
	}

	public final int getType() {
		return type;
	}

	public final int distanceTo() {
		return (int) Calculations.distanceTo(getLocation());
	}

	@Override
	public String toString() {
		return String.format("[X: %d, Y: %d]", getRegionX(), getRegionY());
	}

}