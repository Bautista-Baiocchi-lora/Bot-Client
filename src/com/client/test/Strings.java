package com.client.test;

import java.lang.reflect.Field;

import com.client.core.Client;
import com.client.core.Engine;

public class Strings {

	private Client client = Engine.client;
	
	public static Strings instance;
	
	public Strings() {
		instance = this;
	}
	
	

    public String[] getStringArray(String clazz, String field, Object obj) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);
            Field f = c.getDeclaredField(field);
            f.setAccessible(true);
            return (String[]) f.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getString(String clazz, String field, Object obj) {
        try {
            ClassLoader cl = client.classLoader;
            Class<?> c = cl.loadClass(clazz);

            for(Field f : c.getDeclaredFields()) {
            	f.setAccessible(true);
            	if(f.getName().equals(field)) {
            	if(f.getType().equals(String.class)) {
            		return (String) f.get(obj);
            	}
            	}
            }
        } catch (Exception e) {

        }


        return null;
    }
	
	
	 public static Strings getInstance() {
	        if (instance == null) {
	            instance = new Strings();
	        }
	        return instance;
	    }
	
}
