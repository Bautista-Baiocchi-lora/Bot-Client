package com.client.test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import com.client.core.Client;
import com.client.core.Engine;

public class Int {
	
	private Client client = Engine.client;
	
	public static Int instance;
	
	
	public Int() {
		instance = this;
	}
	
    public int getInt(String clazz, String field, Object obj) {
        try {
          
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
   
            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            	if(f.getType().equals(int.class)) {
            		return (int) f.get(obj);
            	}
            	}
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public void setInt(String clazz, String field, Object obj, int intf) {
        try {
         
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
   
            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            	if(f.getType().equals(int.class)) {
            		f.set(obj, intf);;
            	}
            	}
            }
        } catch (Exception e) {

        }
    }


    public int[] getIntArray(String clazz, String field, Object obj) {
        try {
          
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            for(Field f : c.getDeclaredFields()) {
            	if(f != null) {
            		f.setAccessible(true);
            		if(f.getName().equals(field)) {
            			if(f.getType().toString().equals("class [I")) {
            		            return (int[]) f.get(obj);
            			}
            		}
            	}
            }
 
        } catch (Exception e) {

        }


        return null;
    }
   
    public int[][] get2DIntArray(String clazz, String field, Object obj) {
        try {
           
            Class<?> c = client.getClient().getClass();
            for(Field f : c.getDeclaredFields()) {
            	if(f != null) {
            		f.setAccessible(true);
            		if(f.getName().equals(field)) {
            			if(f.getType().toString().equals("class [[I")) {
            		            return (int[][]) f.get(obj);
            			}
            		}
            	}
            }
        } catch (Exception e) {

        }


        return null;
    }
    public int getFromIntArray(String clazz, String field, Object obj, int index) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            		if(f.getType().toString().equals("class [I")) {
            		     Object arr = f.get(obj);
            	          int cmd = (int) Array.get(arr, 1);
            	           return cmd;
            		}
            	}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		return -1;
    }
    public void setIntArray(String clazz, String field, Object obj, int index, int value) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            		if(f.getType().toString().equals("class [I")) {
            		     Object arr = f.get(obj);
            	            Array.set(arr, 1, value);
            	           
            		}
            	}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static Int getInstance() {
        if (instance == null) {
            instance = new Int();
        }
        return instance;
    }
}
