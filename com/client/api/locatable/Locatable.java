package com.client.api.locatable;


public interface Locatable {

    public Tile getLocation();

    public int getRegionX();

    public int getRegionY();

    public int distanceTo();


}
