package com.client.api.method;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.client.api.utils.Filter;
import com.client.api.wrappers.Deque;
import com.client.api.wrappers.GroundItem;
import com.client.api.wrappers.Node;
import com.client.api.wrappers.OtherItem;


public class GroundItems {

    private static final Comparator<GroundItem> NEAREST_SORTER = new Comparator<GroundItem>() {

        @Override
        public int compare(GroundItem n1, GroundItem n2) {
            return n1.distanceTo() - n2.distanceTo();
        }

    };
    private static final Filter<GroundItem> ALL_FILTER = new Filter<GroundItem>() {

        @Override
        public boolean accept(GroundItem item) {
            return true;
        }

    };

    public final static GroundItem[] getGroundItems(
            final Filter<GroundItem> filter) {

        final ArrayList<GroundItem> items = new ArrayList<>();
        for (int x = 0; x < 104; x++) {
            for (int y = 0; y < 104; y++) {
                final GroundItem[] groundItemsAtTile = getGroundItemsAt(x, y);
                if (groundItemsAtTile != null) {
                    for (final GroundItem item : groundItemsAtTile) {
                        if (filter.accept(item)) {
                            items.add(item);
                        }
                    }
                }
            }
        }
        return items.toArray(new GroundItem[items.size()]);
    }


    public static final GroundItem[] getGroundItemsAt(final int x, final int y) {

        ArrayList<GroundItem> list = new ArrayList<>();
        final Object deque = Game.getGroundItems()[Game.getPlane()][x][y];
        Deque deq = new Deque(deque);
        if (deque == null) {
            return null;
        }


        final Object holder = deq.getHead();
        final Node hold = new Node(holder);
        Object curNode = hold.getNext();
        Node cur = new Node(curNode);


        while (curNode != null && curNode != holder && curNode != deq.getHead()) {
            Object groundItem = curNode;
            final OtherItem groundIt = new OtherItem(groundItem);
            list.add(new GroundItem(groundIt, x, y));
            curNode = cur.getNext();
            cur = new Node(curNode);


        }

        return list.toArray(new GroundItem[list.size()]);


    }

    public static final GroundItem[] getGroundItems() {
        return getGroundItems(ALL_FILTER);
    }


    public static final GroundItem[] getNearest(Filter<GroundItem> filter) {
        final GroundItem[] objects = getGroundItems(filter);
        Arrays.sort(objects, NEAREST_SORTER);
        return objects;
    }

    public static final GroundItem[] getNearest() {
        return getNearest(ALL_FILTER);
    }


    public static final GroundItem[] getNearest(final int... ids) {
        return getNearest(new Filter<GroundItem>() {

            @Override
            public boolean accept(GroundItem object) {
                for (final int id : ids) {
                    if (id == object.getId()) {
                        return true;
                    }
                }
                return false;
            }

        });
    }


}