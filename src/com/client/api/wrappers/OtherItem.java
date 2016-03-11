package com.client.api.wrappers;


import com.client.data.Constants;
import com.client.test.Int;

public class OtherItem {
    private Object node;

    public OtherItem(Object node) {

        this.node = node;
    }

    public int getId() {
        return Int.getInstance().getInt(Constants.itemClass, Constants.itemID, node);
    }


}
