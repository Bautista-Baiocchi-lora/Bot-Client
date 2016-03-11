//package com.client.api.method;
//
//import java.awt.Point;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import com.client.api.utils.Filter;
//import com.client.api.wrappers.Item;
//import com.client.core.Client;
//import com.client.core.Engine;
//import com.client.data.Constants;
//import com.client.test.Objects;
//
//public class Inventory {
//	public static final int PARENT_INDEX = 69;
//	public static final int CHILD_INDEX = 1;
//    private static final Filter<Item> ALL_FILTER = new Filter<Item>() {
//
//        @Override
//        public boolean accept(Item i) {
//            return true;
//        }
//
//    };
//    public static Client client = Engine.client;
//
//    public static Item[] getItems() {
//        return getItems(ALL_FILTER);
//    }
//
//  
//    public static Item[] getItems(final int... ids) {
//        return getItems(new Filter<Item>() {
//
//            @Override
//            public boolean accept(Item e) {
//                for (int id : ids) {
//                    if (e.getId() == id) {
//                        return true;
//                    }
//                }
//                return false;
//            }
//
//        });
//    }
//
//    public static Object[][] getInterface() {
//     //   return Objects.getInstance().getObjectArray(clazz, field, obj, clazz2)
//    }
//
//    public static Item[] getItems(final Filter<Item> filter) {
//
//        Object inventory = getInterface()[69][1];
//        if (inventory == null) {
//            return null;
//        }
//        final Interface intf = new Interface(inventory);
//        final int[] items = intf.getItems();
//        final int[] stackSizes = intf.getStackSizes();
//        final ArrayList<Item> invItems = new ArrayList<>(28);
//        for (int i = 0; i < items.length; i++) {
//            final int itemId = items[i];
//            if (itemId < 1) {
//                continue;
//            }
//            final int stackSize = stackSizes[i];
//            final Item item = new Item(itemId, stackSize, i);
//            if (filter.accept(item)) {
//                invItems.add(item);
//            }
//        }
//        return invItems.toArray(new Item[invItems.size()]);
//    }
//
//    public static int getCount() {
//        return getCount(false);
//    }
//    public static Point getInventoryItemPoint(int slot) {
//        Random r = new Random();
//        int col = --slot % 4;
//        int row = slot / 4;
//        int x = 580 + col * 42 - 10 + r.nextInt(6);
//        int y = 219 + row * 35 + r.nextInt(6);
//        return new Point(x, y);
//    }
//    public static Point getInventoryItemDropPoint(int slot) {
//        Random r = new Random();
//        int col = --slot % 4;
//        int row = slot / 4;
//        int x = 580 + col * 42 - 10 + r.nextInt(6);
//        int y = 219 + row * 35 + r.nextInt(6);
//        return new Point(x, y+53);
//    }
//
//    public static int getCount(int... ids) {
//        return getCount(false, ids);
//    }
//
//
//    public static int getCount(final boolean includeStack) {
//        Object inventory = getInterface()[69][1];
//        if (inventory == null) {
//            return -1;
//        }
//        final Interface intf = new Interface(inventory);
//        int count = 0;
//        final int[] items = intf.getItems();
//        final int[] stackSizes = includeStack ? intf.getStackSizes() : null;
//        for (int i = 0; i < items.length; i++) {
//            if (items[i] > 0) {
//                count += includeStack ? stackSizes[i] : 1;
//            }
//        }
//        return count;
//    }
//
//    public static int getCount(final boolean includeStack, int... ids) {
//        Object inventory = getInterface()[69][1];
//        if (inventory == null) {
//            return -1;
//        }
//        final Interface intf = new Interface(inventory);
//        int count = 0;
//        final int[] items = intf.getItems();
//        final int[] stackSizes = includeStack ? intf.getStackSizes() : null;
//        for (int i = 0; i < items.length; i++) {
//            final int itemId = items[i];
//            if (itemId > 0) {
//                for (final int id : ids) {
//                    if (id == itemId) {
//                        count += includeStack ? stackSizes[i] : 1;
//                        break;
//                    }
//                }
//            }
//        }
//        return count;
//    }
//
//    public static boolean isFull() {
//        return Inventory.getCount() == 28;
//    }
//
//
//    public static boolean isEmpty() {
//        return Inventory.getCount() == 0;
//    }
//
//    public static boolean contains(int... id) {
//        return getCount(id) > 0;
//    }
//
//
//    public static Item getItem(int id) {
//        for (Item i : getItems(id)) {
//            if (i != null) {
//                return i;
//            }
//        }
//        return null;
//    }
//}
