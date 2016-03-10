package com.client.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.client.core.Client;
import com.client.core.Engine;
import com.client.ui.components.eLogger;

public class Objects {

	private Client client = Engine.client;
	
	public static Objects instance;
	
	public Objects() {
		instance = this;
	}
	
	
	public Object[][][] get3DObjectArray(String clazz, String field, Object obj, String clazz2) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            		if(f.getType().toString().equals("class [[[L"+ clazz2 + ";")) {
            		
                      return (Object[][][]) f.get(obj);

            		}
            	}
            	}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Object[] getObjectArray(String clazz, String field, Object obj, String clazz2) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            		if(f.getType().toString().equals("class [L"+ clazz2 + ";")) {
            			return (Object[]) f.get(obj);
            		}
            	
            	
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Object getObject(String clazz, String field, Object obj, String clazz2) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            		if(f.getType().toString().equals("class "+ clazz2)) {
            			return (Object) f.get(obj);

            		}
            	}
            	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Object[][] get2DObjectArray(String clazz, String field, Object obj, String clazz2) {
        try {
          
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            		if(f.getType().toString().equals("class [[L"+ clazz2 + ";")) {
            			return (Object[][]) f.get(obj);
            		}
            		}
            	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Object getItem(int i) {
        try {
            Client client = Engine.client;
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(""); // Constants.getItemDef
            for (Method m : c.getDeclaredMethods()) {
                if (m != null) {
                    if (m.getName().equals("")) { // Constants.getForID
                        m.setAccessible(true);
                        m.invoke(client.getClient(), i);

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;

    }
    public Object getObjectAccessor(String clazz, String field, Object obj) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            Field f = c.getDeclaredField(field);
            f.setAccessible(true);
            return (Object) f.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Object getScene(String clazz, String field, Object obj, String clazz2) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            		if(f.getType().toString().equals("class "+ clazz2)) {
                        return (Object) f.get(obj);
            		}
            		}
            	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void walkTo(String clazz, String field, Object obj, int clickType, int sizeX, int sizeY, int startX, int startY, int destX, int destY, int type, int face, boolean arbitrary, int rotation) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            Method m = c.getDeclaredMethod(field);
            m.setAccessible(true);
            m.invoke(obj, clickType, sizeX, sizeY, startX, startY, destX, destY, type, face, arbitrary, rotation);
        } catch (Exception e) {
            eLogger.writeException(e.toString());
        }

    }


    public Object getGameComponent() {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass("");//com.ikovps.client.
            for(Field m : c.getDeclaredFields()) {
            	if(m.getName().equals("")) {{//Constants.getGameComponent
            		eLogger.write("GameComponet Grabbed");
            		m.setAccessible(true);
            		return (Object) m.get(client.getClient());
            	}
            	}
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Objects getInstance() {
        if (instance == null) {
            instance = new Objects();
        }
        return instance;
    }
}
