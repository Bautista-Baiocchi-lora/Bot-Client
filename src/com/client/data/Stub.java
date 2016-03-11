package com.client.data;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

public final class Stub
		implements AppletStub {
	private final Hashtable<String, String> a = new Hashtable<String, String>();

	public Stub() {
		a.put("worldid", "1");
		a.put("portoff", "0");
		a.put("version", "474");

	}

	@Override
	public final void appletResize(final int paramInt1, final int paramInt2) {
	}

	@Override
	public final AppletContext getAppletContext() {
		return null;
	}

	@Override
	public final URL getCodeBase() {
		try {
			return new URL("http://www.soulsplit3.com");
		} catch (final MalformedURLException localMalformedURLException) {
			throw new RuntimeException();
		}
	}

	@Override
	public final URL getDocumentBase() {
		return getCodeBase();
	}

	@Override
	public final String getParameter(final String paramString) {
		return a.get(paramString);
	}

	@Override
	public final boolean isActive() {
		return true;
	}
}
