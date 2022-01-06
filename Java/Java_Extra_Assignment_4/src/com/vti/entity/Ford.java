package com.vti.entity;

public class Ford extends Car {

	private int year;
	private int manufacturerDiscount;

	@Override
	public double getSalePrice() {
		return regularPrice - manufacturerDiscount;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getManufacturerDiscount() {
		return manufacturerDiscount;
	}

	public void setManufacturerDiscount(int manufacturerDiscount) {
		this.manufacturerDiscount = manufacturerDiscount;
	}

	public Ford(int maxSpeed, double regularPrice, String color, int year, int manufacturerDiscount) {
		super(maxSpeed, regularPrice, color);
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}

	@Override
	public String toString() {
		return "Ford [year=" + year + ", manufacturerDiscount=" + manufacturerDiscount + "]";
	}

}
