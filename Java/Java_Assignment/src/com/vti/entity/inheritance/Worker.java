package com.vti.entity.inheritance;

public class Worker extends Staff {
	public Worker(String fullName, int age, Gender gender, String address, int level) {
		super(fullName, age, gender, address);
		this.level = level;
	}

	private int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return super.toString() + "\nLeve: " + getLevel();
	}
}
