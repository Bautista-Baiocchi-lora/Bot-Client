package com.client.data;

import java.awt.Color;

import com.client.core.Engine;

public class Variables {
	private static Engine engine;
	private static Color clientColor = Color.RED;

	public static Color getClientColor() {
		return clientColor;
	}

	public static Engine getEngine() {
		return engine;
	}

	public static void setClientColor(final Color color) {
		clientColor = color;
	}

	public static void setEngine(final Engine i) {
		engine = i;
	}

}
