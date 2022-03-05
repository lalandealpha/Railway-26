package com.vti.entity;

public abstract class Vehicle {
	protected int maxSpeed;
	protected double regularPrice;
	protected String color;

	public abstract double getSalePrice();

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Vehicle(int maxSpeed, double regularPrice, String color) {
		super();
		this.maxSpeed = maxSpeed;
		this.regularPrice = regularPrice;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [maxSpeed=" + maxSpeed + ", regularPrice=" + regularPrice + ", color=" + color + "]";
	}

}
