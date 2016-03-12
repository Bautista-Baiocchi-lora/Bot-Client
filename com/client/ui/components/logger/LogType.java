package com.client.ui.components.logger;

public enum LogType {

	CLIENT("Client"), SCRIPT("Script"), DEBUG("Debug");

	private String type;

	LogType(final String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
