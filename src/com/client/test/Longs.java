package com.client.test;

import java.lang.reflect.Field;

import com.client.core.Client;
import com.client.core.Engine;

public class Longs {
	private Client client = Engine.client;
	
	public static Longs instance;
	
	
	public Longs() {
		instance = this;
	}
	
	   public long getLong(String clazz, String field, Object obj) {
	        try {
	            ClassLoader cl = client.classLoader;
	            Class<?> c = cl.loadClass(clazz);
	            Field f = c.getDeclaredField(field);
	            f.setAccessible(true);
	            return (long) f.get(obj);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	
	
	 public static Longs getInstance() {
	        if (instance == null) {
	            instance = new Longs();
	        }
	        return instance;
	    }
}
