package com.client.reflection;

import java.lang.reflect.Field;

import com.client.core.Client;
import com.client.data.Variables;

public class Booleans {
	public static Booleans instance;

	public static Booleans getInstance() {
		if (instance == null) {
			instance = new Booleans();
		}
		return instance;
	}

	private final Client client = Variables.getEngine().getClient();

	public Booleans() {
		instance = this;
	}

	public boolean getBoolean(final String clazz, final String field, final Object obj) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().equals(boolean.class)) {
						return (boolean) f.get(obj);
					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
