package com.client.api.wrappers;

import com.client.data.Constants;
import com.client.reflection.Int;

public class SceneObjectTile {
    private Object node;

    public SceneObjectTile(Object node) {

        this.node = node;
    }

    public int getHash() {
        return Int.getInstance().getInt(Constants.interactiveObjectsClass, Constants.getObjectHash, node);

    }

    public int getId() {
        return Int.getInstance().getInt(Constants.interactiveObjectsClass, Constants.getObjectId, node);

    }
}
