package com.client.api.wrappers;


public class Item {
    private int id, stackSize;
    private int slot;

    public Item(int id, int stackSize, int slot) {
        this.id = id;
        this.stackSize = stackSize;
        this.slot = slot;
    }


    public int getId() {
        return id;
    }


    public int getStackSize() {
        return stackSize;
    }


    public int getSlot() {
        return slot;
    }

}