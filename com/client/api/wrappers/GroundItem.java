package com.client.api.wrappers;



import com.client.api.locatable.Locatable;
import com.client.api.locatable.Tile;
import com.client.api.method.Game;

public class GroundItem implements Locatable {
    private OtherItem accessor;
    private int x;
    private int y;

    public GroundItem(OtherItem accessor, final int x,
                      final int y) {

        this.accessor = accessor;
        this.x = x;
        this.y = y;
    }


    @Override
    public Tile getLocation() {

        return new Tile(Game.getBaseX() + getRegionX(),
                Game.getBaseY() + getRegionY(), Game.getPlane());
    }


    @Override
    public int getRegionX() {
        return x;
    }


    @Override
    public int getRegionY() {
        return y;
    }


    @Override
    public int distanceTo() {
        return 0;
    }


    public int getId() {

        return this.accessor.getId();
    }	


//    public void interact(int actionIndex) {
//        Menu.interact(this, actionIndex);
//    }
//
//    public void take() {
//        Menu.take(this);
//    }


}