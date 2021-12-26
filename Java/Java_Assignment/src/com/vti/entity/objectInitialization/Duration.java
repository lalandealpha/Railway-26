package com.vti.entity.objectInitialization;

public enum Duration {
	MINUTE15(15), MINUTE45(45), MINUTE60(60), MINUTE90(90);

	private int value;

	private Duration(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
