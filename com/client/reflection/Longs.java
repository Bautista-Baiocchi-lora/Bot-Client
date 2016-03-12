package com.client.reflection;

import java.lang.reflect.Field;

import com.client.core.Client;
import com.client.data.Variables;

public class Longs {
	public static Longs instance;

	public static Longs getInstance() {
		if (instance == null) {
			instance = new Longs();
		}
		return instance;
	}

	private final Client client = Variables.getEngine().getClient();

	public Longs() {
		instance = this;
	}

	public long getLong(final String clazz, final String field, final Object obj) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			final Field f = c.getDeclaredField(field);
			f.setAccessible(true);
			return (long) f.get(obj);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
