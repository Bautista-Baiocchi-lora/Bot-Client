package com.client.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import com.client.core.Client;
import com.client.data.Variables;

public class Int {

	public static Int instance;

	public static Int getInstance() {
		if (instance == null) {
			instance = new Int();
		}
		return instance;
	}

	private final Client client = Variables.getEngine().getClient();

	public Int() {
		instance = this;
	}

	public int[][] get2DIntArray(final String clazz, final String field, final Object obj) {
		try {

			final Class<?> c = client.getClient().getClass();
			for (final Field f : c.getDeclaredFields()) {
				if (f != null) {
					f.setAccessible(true);
					if (f.getName().equals(field)) {
						if (f.getType().toString().equals("class [[I")) {
							return (int[][]) f.get(obj);
						}
					}
				}
			}
		} catch (final Exception e) {

		}

		return null;
	}

	public int getFromIntArray(final String clazz, final String field, final Object obj,
			final int index) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().toString().equals("class [I")) {
						final Object arr = f.get(obj);
						final int cmd = (int) Array.get(arr, index);
						return cmd;
					}
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int getInt(final String clazz, final String field, final Object obj) {
		try {

			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);

			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().equals(int.class)) {
						return (int) f.get(obj);
					}
				}
			}
		} catch (final Exception e) {

		}
		return 0;
	}

	public int[] getIntArray(final String clazz, final String field, final Object obj) {
		try {

			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				if (f != null) {
					f.setAccessible(true);
					if (f.getName().equals(field)) {
						if (f.getType().toString().equals("class [I")) {
							return (int[]) f.get(obj);
						}
					}
				}
			}

		} catch (final Exception e) {

		}

		return null;
	}

	public void setInt(final String clazz, final String field, final Object obj, final int intf) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().equals(int.class)) {
						f.set(obj, intf);
						;
					}
				}
			}
		} catch (final Exception e) {

		}
	}

	public void setIntArray(final String clazz, final String field, final Object obj,
			final int index, final int value) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().toString().equals("class [I")) {
						final Object arr = f.get(obj);
						Array.set(arr, 1, value);

					}
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}

	}
}
