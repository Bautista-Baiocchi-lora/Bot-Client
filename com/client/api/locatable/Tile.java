package com.client.api.locatable;

import com.client.api.method.Calculations;
import com.client.api.method.Game;

public final class Tile implements TileFlags {
	private final int x;
	private final int y;
	private int z;

	public Tile(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public Tile(final int x, final int y, final int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public final int distanceTo() {
		return (int) Calculations.distanceTo(this);
	}

	@Override
	public boolean equals(final Object obj) {
		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		final Tile t = (Tile) obj;
		return (t.getX() == getX()) && (t.getY() == getY())
				&& (t.getPlane() == getPlane());
	}

	public final int getPlane() {
		return z;
	}

	public final int getRegionX() {
		return x - Game.getBaseX();
	}

	public final int getRegionY() {
		return y - Game.getBaseY();
	}

	public final int getX() {
		return x;
	}

	// public void walkTo() {
	// Walking.walkTo(this);
	//
	// }

	public final int getY() {
		return y;
	}

	public final boolean isOnMinimap() {
		return distanceTo() < 13;
	}

	@Override
	public String toString() {
		return "Tile: [ X: " + getX() + ", Y: " + getY() + ", Z: " + getPlane() + "]";
	}

}
