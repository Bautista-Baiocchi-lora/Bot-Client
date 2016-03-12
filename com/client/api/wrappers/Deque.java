package com.client.api.wrappers;

import com.client.data.Constants;
import com.client.reflection.Objects;

public class Deque {
    private Object deque;

    public Deque(Object deque) {

        this.deque = deque;
    }

    public Object getHead() {
        return Objects.getInstance().getObjectAccessor(Constants.dequeClass, Constants.head, deque);
    }


}
