package com.client.api.wrappers;

import com.client.data.Constants;
import com.client.test.Int;

public class SceneObjectTile {
    private Object node;

    public SceneObjectTile(Object node) {

        this.node = node;
    }

    public int getHash() {
        return Int.getInstance().getInt(Constants.interactiveObjectsClass, Constants.getHash, node);

    }
    
}
