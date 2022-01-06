package com.vti.entity;

public class Truck extends Vehicle {

	private int weight;

	@Override
	public double getSalePrice() {
		if (weight > 2000) {
			return regularPrice - (regularPrice / 10);
		} else {
			return regularPrice - (regularPrice / 20);
		}
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Truck(int maxSpeed, double regularPrice, String color, int weight) {
		super(maxSpeed, regularPrice, color);
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Truck [weight=" + weight + "]";
	}

}
