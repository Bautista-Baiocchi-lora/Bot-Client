package com.client.api.method;

import java.lang.reflect.Method;

import com.client.core.Client;
import com.client.data.Constants;
import com.client.data.Variables;
import com.client.test.Int;

public class Game {

	public static Client client = Variables.getEngine().getClient();
	public static String main = Constants.mainClass;
	public static Object clientObj = Variables.getEngine().getClient().getClient();

	public static void doAction(final int i) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(Constants.mainClass);
			for (final Method m : c.getDeclaredMethods()) {
				if (m != null) {
					if (m.getName().equals(Constants.doAction)) {
						// if(m.getParameterCount() == 1) {
						// System.out.println("TEST");
						m.setAccessible(true);
						m.invoke(clientObj, i);
						// }
					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	public static int getOpenInterfaceID() {
		return Int.getInstance().getInt(main, Constants.openInterfaceID, clientObj);
	}

	public static void setMenuAction1(final int value, final int index) {
		Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionCmd1, clientObj,
				index, value);
	}

	public static void setMenuAction2(final int value, final int index) {
		Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionCmd2, clientObj,
				index, value);
	}

	public static void setMenuAction3(final int value, final int index) {
		Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionCmd3, clientObj,
				index, value);
	}

	public static void setMenuAction4(final int value, final int index) {
		Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionCmd4, clientObj,
				index, value);
	}

	public static void setMenuActionId(final int value, final int index) {
		Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionID, clientObj, index,
				value);
	}
}
