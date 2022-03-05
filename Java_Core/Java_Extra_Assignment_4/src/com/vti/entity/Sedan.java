package com.vti.entity;

public class Sedan extends Car {

	private double length;

	@Override
	public double getSalePrice() {
		if (length > 20) {
			return regularPrice - (regularPrice / 5);
		} else {
			return regularPrice - (regularPrice / 10);
		}
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Sedan(int maxSpeed, double regularPrice, String color, double length) {
		super(maxSpeed, regularPrice, color);
		this.length = length;
	}

	@Override
	public String toString() {
		return "Sedan [length=" + length + "]";
	}

}
