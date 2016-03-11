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

	private void downloadJar() {
		try {
			final File file = new File(
					getPublicCache() + "Client" + File.separator + Constants.jarName);
			try {
				file.getParentFile().mkdirs();
			} catch (final Exception ignore) {
				ignore.printStackTrace();
			}
			final BufferedInputStream input = new BufferedInputStream(
					new URL(Constants.jarUrl).openStream());
			final BufferedOutputStream output = new BufferedOutputStream(
					new FileOutputStream(file));
			int bytesRead = 0;
			while ((bytesRead = input.read()) != -1) {
				output.write(bytesRead);
			}
			input.close();
			output.close();
		} catch (final Exception ignore) {
			ignore.printStackTrace();
		}
	}

	public Applet getApplet() {
		try {
			classLoader = getClassLoader();
			if (classLoader != null) {
				final Class<?> client = classLoader.loadClass(Constants.mainClass);
				final Object instance = client.newInstance();
				applet = (Applet) instance;
				applet.setStub(new Stub());
				return applet;
			}
		} catch (final Exception ignore) {
			ignore.printStackTrace();
		}
		return null;
	}

	public String getCacheName() {
		return "BottingClient"; // will create a directory in user.home under this name (Will
								// contain the .jar for server, and other shit for later"

	}

	public URLClassLoader getClassLoader() {
		try {
			final URLClassLoader classLoader = new URLClassLoader(new URL[] {
					new File(getPublicCache() + "Client" + File.separator + Constants.jarName)
							.toURI().toURL() });
			classLoader.loadClass(Constants.mainClass);
			return classLoader;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getClient() {
		return clientInstance;
	}

	public String getPublicCache() {
		final String home = System.getProperty("user.home");
		final String path = home + File.separator + getCacheName() + File.separator;
		new File(path).mkdirs();
		return path;
	}

	public void initiate() {
	File f = new File(
			getPublicCache() + "Client" + File.separator + Constants.jarName);
		if (isInitialized) {
			return;
		}
		try {
			if(f.exists() && !f.isDirectory()) {
			//WE CAN CHECK FOR CLIENT UPDATE HERE ALSO
			System.out.println("Loading client from cache.");
			
			} else {
			downloadJar();	
			}
			isInitialized = true;
		} catch (final Exception ignore) {
			ignore.printStackTrace();
		}
	}

	public boolean isIsInitialized() {
		return isInitialized;
	}

	public void setClassLoader(final URLClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public void setClientInstance(final Object clientInstance) {
		this.clientInstance = clientInstance;
	}

}
