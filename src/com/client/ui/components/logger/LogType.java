package com.client.ui.components.logger;

public enum LogType {

	CLINET("Client"), SCRIPT("Script");

	private String type;

	LogType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
