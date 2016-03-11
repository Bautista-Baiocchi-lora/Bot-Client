package com.client.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.client.core.Client;
import com.client.data.Variables;
import com.client.ui.components.logger.Logger;

public class Objects {

	public static Objects instance;

	public static Objects getInstance() {
		if (instance == null) {
			instance = new Objects();
		}
		return instance;
	}

	public static Object getItem(final int i) {
		try {
			final Client client = Variables.getEngine().getClient();
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(""); // Constants.getItemDef
			for (final Method m : c.getDeclaredMethods()) {
				if (m != null) {
					if (m.getName().equals("")) { // Constants.getForID
						m.setAccessible(true);
						m.invoke(client.getClient(), i);

					}
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	private final Client client = Variables.getEngine().getClient();

	public Objects() {
		instance = this;
	}

	public Object[][] get2DObjectArray(final String clazz, final String field, final Object obj,
			final String clazz2) {
		try {

			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().toString().equals("class [[L" + clazz2 + ";")) {
						return (Object[][]) f.get(obj);
					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object[][][] get3DObjectArray(final String clazz, final String field, final Object obj,
			final String clazz2) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().toString().equals("class [[[L" + clazz2 + ";")) {

						return (Object[][][]) f.get(obj);

					}
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getGameComponent() {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass("");// com.ikovps.client.
			for (final Field m : c.getDeclaredFields()) {
				if (m.getName().equals("")) {
					{// Constants.getGameComponent
						Logger.write("GameComponet Grabbed");
						m.setAccessible(true);
						return m.get(client.getClient());
					}
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getObject(final String clazz, final String field, final Object obj,
			final String clazz2) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().toString().equals("class " + clazz2)) {
						return f.get(obj);

					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getObjectAccessor(final String clazz, final String field, final Object obj) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			final Field f = c.getDeclaredField(field);
			f.setAccessible(true);
			return f.get(obj);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object[] getObjectArray(final String clazz, final String field, final Object obj,
			final String clazz2) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().toString().equals("class [L" + clazz2 + ";")) {
						return (Object[]) f.get(obj);
					}

				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getScene(final String clazz, final String field, final Object obj,
			final String clazz2) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				if (f.getName().equals(field)) {
					if (f.getType().toString().equals("class " + clazz2)) {
						return f.get(obj);
					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void walkTo(final String clazz, final String field, final Object obj,
			final int clickType, final int sizeX, final int sizeY,
			final int startX, final int startY, final int destX, final int destY, final int type,
			final int face, final boolean arbitrary,
			final int rotation) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(clazz);
			final Method m = c.getDeclaredMethod(field);
			m.setAccessible(true);
			m.invoke(obj, clickType, sizeX, sizeY, startX, startY, destX, destY, type, face,
					arbitrary, rotation);
		} catch (final Exception e) {
			Logger.writeException(e.toString());
		}

	}
}
