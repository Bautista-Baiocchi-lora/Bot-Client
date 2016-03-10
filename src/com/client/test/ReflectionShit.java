package com.client.test;

import java.lang.reflect.Field;

import com.client.core.Client;
import com.client.core.Engine;


public class ReflectionShit {
    public static int getInt(String clazz, String field, Object obj) {
        try {
            Client client = Engine.client;
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
}
