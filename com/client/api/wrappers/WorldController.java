package com.client.api.wrappers;


import com.client.data.Constants;
import com.client.test.Objects;

public class WorldController {
    private Object node;

    public WorldController(Object node) {

        this.node = node;
    }

    public Object[][][] getGroundArray() {
        return Objects.getInstance().get3DObjectArray(Constants.worldControllerClass, Constants.worldGroundArray, node, Constants.groundClass);
    }


}
