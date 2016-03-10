package com.client.data;

import java.awt.Color;

import com.client.core.Engine;

public class Variables {
	private static Engine engine;
	private static Color clientColor = Color.RED;

	public static Color getClientColor() {
		return clientColor;
	}

	public static void setClientColor(Color color) {
		clientColor = color;
	}

	public static Engine getEngine() {
		return engine;
	}

	public static void setEngine(Engine i) {
		engine = i;
	}

}
