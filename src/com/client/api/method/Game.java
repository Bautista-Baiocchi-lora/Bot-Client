package com.client.api.method;


import java.lang.reflect.Method;


import com.client.core.Client;
import com.client.core.Engine;
import com.client.data.Constants;
import com.client.test.Int;

public class Game {
	
	public static Client client = Engine.client;
	public static String main = Constants.mainClass;
	public static Object clientObj = Engine.client.getClient();
	
	
	
	public static int getOpenInterfaceID() {
		return Int.getInstance().getInt(main, Constants.openInterfaceID, clientObj);
	}
    public static void setMenuAction1(int value, int index) {
        Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionCmd1, clientObj, index, value);
    }

    public static void setMenuAction2(int value, int index) {
        Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionCmd2, clientObj, index, value);
    }

    public static void setMenuAction3(int value, int index) {
        Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionCmd3, clientObj, index, value);
    }
    public static void setMenuAction4(int value, int index) {
        Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionCmd4, clientObj, index, value);
    }
    public static void setMenuActionId(int value, int index) {
        Int.getInstance().setIntArray(Constants.mainClass, Constants.menuActionID, clientObj, index, value);
    }
    
    
    
    public static void doAction(int i) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(Constants.mainClass);

            for (Method m : c.getDeclaredMethods()) {
                if (m != null) {
                    if (m.getName().equals(Constants.doAction)) {
                    	if(m.getParameterCount() == 1) {
                    	//System.out.println("TEST");
                        m.setAccessible(true);
                        m.invoke(clientObj, i);
                    }
                }
                }
            }
        } catch (Exception e) {
          //  e.printStackTrace();
        }

    }
}
