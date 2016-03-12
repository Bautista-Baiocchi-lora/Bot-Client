package com.client.api.wrappers;


import com.client.data.Constants;
import com.client.reflection.Objects;

public class Node {
    private Object node;

    public Node(Object node) {

        this.node = node;
    }

    public Object getNext() {
        return Objects.getInstance().getObjectAccessor(Constants.nodeClass, Constants.next, node);
    }


}
