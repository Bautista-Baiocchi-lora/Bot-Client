package com.client.api.wrappers;

import com.client.data.Constants;
import com.client.reflection.Int;

public class OtherItem {
	private final Object node;

	public OtherItem(final Object node) {

		this.node = node;
	}

	public int getId() {
		return Int.getInstance().getInt(Constants.itemClass, Constants.itemID, node);
	}

}
