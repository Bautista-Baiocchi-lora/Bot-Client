package com.client.api.locatable;

import com.client.api.method.Calculations;
import com.client.api.method.Game;

public final class Tile implements TileFlags {
    private int x;
    private int y;
    private int z;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public final int getX() {
        return x;
    }


    public final int getY() {
        return y;
    }


    public final int getRegionX() {
        return x - Game.getBaseX();
    }


    public final int getRegionY() {
        return y - Game.getBaseY();
    }


    public final int getPlane() {
        return z;
    }

    @Override
    public String toString() {
        return "Tile: [ X: " + getX() + ", Y: " + getY() + ", Z: " + getPlane() + "]";
    }

//    public void walkTo() {
//    Walking.walkTo(this);
//
//    }

    public final boolean isOnMinimap() {
        return distanceTo() < 13;
      }
  
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        final Tile t = (Tile) obj;
        return t.getX() == this.getX() && t.getY() == this.getY()
                && t.getPlane() == this.getPlane();
    }

    public final int distanceTo() {
        return (int) Calculations.distanceTo(this);
    }

}
