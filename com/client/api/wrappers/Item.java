package com.client.api.wrappers;

public class Item {
	private final int id, stackSize;
	private final int slot;

	public Item(final int id, final int stackSize, final int slot) {
		this.id = id;
		this.stackSize = stackSize;
		this.slot = slot;
	}

	public int getId() {
		return id;
	}

	public int getSlot() {
		return slot;
	}

	public int getStackSize() {
		return stackSize;
	}

}