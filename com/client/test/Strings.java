package com.client.test;

import java.lang.reflect.Field;

import com.client.core.Client;
import com.client.data.Variables;

public class Strings {

	public static Strings instance;

	public static Strings getInstance() {
		if (instance == null) {
			instance = new Strings();
		}
		return instance;
	}

	private final Client client = Variables.getEngine().getClient();

	public Strings() {
		instance = this;
	}

	public String getString(final String clazz, final String field, final Object obj) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);

			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().equals(String.class)) {
						return (String) f.get(obj);
					}
				}
			}
		} catch (final Exception e) {

		}

		return null;
	}

	public String[] getStringArray(final String clazz, final String field, final Object obj) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			final Field f = c.getDeclaredField(field);
			f.setAccessible(true);
			return (String[]) f.get(obj);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
