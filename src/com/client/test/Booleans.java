package com.client.test;

import java.lang.reflect.Field;

import com.client.core.Client;
import com.client.core.Engine;

public class Booleans {
private Client client = Engine.client;
	
	public static Booleans instance;
	
	
	public Booleans() {
		instance = this;
	}
	
	
	  public boolean getBoolean(String clazz, String field, Object obj) {
	        try {
	           
	            ClassLoader cl = client.classLoader;
	            Class<?> c = cl.loadClass(clazz);
	            for(Field f : c.getDeclaredFields()) {
	            	f.setAccessible(true);
	            	if(f.getName().equals(field)) {
	            	if(f.getType().equals(boolean.class)) {
	            		return (boolean) f.get(obj);
	            	}
	            	}
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	

    public static Booleans getInstance() {
        if (instance == null) {
            instance = new Booleans();
        }
        return instance;
    }
}
