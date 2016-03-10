// THIS WILL NEED TO BE RE-PACKAGED FOR CORRECT LOCATION //


package com.client.core;

import java.applet.Applet;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLClassLoader;

import com.client.data.Constants;
import com.client.data.Stub;

public class Client {
    public URLClassLoader classLoader;
    private Object clientInstance;
    private Applet applet;
    private boolean isInitialized;
 
    public Client() {

    }

    public void init() {
        if (isInitialized) {
            return;
        }
        try {
            downloadJar();
            isInitialized = true;
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public boolean isIsInitialized() {
        return isInitialized;
    }

    public void downloadJar() {
        try {
            File file = new File(getPublicCache() + "Client" + File.separator + Constants.jarName);
            try {
                file.getParentFile().mkdirs();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
            BufferedInputStream input = new BufferedInputStream(
                    new URL(Constants.jarUrl).openStream());
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file));
            int bytesRead = 0;
            while ((bytesRead = input.read()) != -1) {
                output.write(bytesRead);
            }
            input.close();
            output.close();
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public URLClassLoader getClassLoader() {
        try {
            URLClassLoader classLoader = new URLClassLoader(new URL[]{
                    new File(getPublicCache() + "Client" + File.separator + Constants.jarName).toURI().toURL()});
            classLoader.loadClass(Constants.mainClass);
            return classLoader;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setClassLoader(URLClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public String getPublicCache() {
        String home = System.getProperty("user.home");
        String path = home + File.separator + getCacheName() + File.separator;
        new File(path).mkdirs();
        return path;
    }

    public String getCacheName() {
        return "BottingClient"; //will create a directory in user.home under this name (Will contain the .jar for server, and other shit for later"
 
    }

    public Applet getApplet() {
        try {
            classLoader = getClassLoader();

            if (classLoader != null) {
                Class<?> client = classLoader.loadClass(Constants.mainClass);
       
                Object instance = client.newInstance();
                applet = (Applet) instance;
                applet.setStub(new Stub());
                return applet;
            }
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
        return null;
    }


    public Object getClient() {
        return this.clientInstance;
    }

    
    public void setClientInstance(Object clientInstance) {
        this.clientInstance = clientInstance;
    }
 
}
