package com.client.api.wrappers;

import com.client.data.Constants;
import com.client.test.Objects;

public class Ground {
    private Object node;

    public Ground(Object node) {

        this.node = node;
    }

    public Object[] getInteractiveObjects() {
        return Objects.getInstance().getObjectArray(Constants.groundClass, Constants.interactiveObjects, node, Constants.interactiveObjectsClass);
    }


}
