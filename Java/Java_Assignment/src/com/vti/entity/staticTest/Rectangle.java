package com.vti.entity.staticTest;

public class Rectangle extends Shape implements IRectangle {
	private float length;
	private float width;
	public static int countRec = 0;

	public Rectangle(float length, float width) throws Exception {
		if (Rectangle.countRec + Circle.countCir < Shape.maximumNumber) {
			this.length = length;
			this.width = width;
			countRec++;
		}
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getwidth() {
		return width;
	}

	public void setwidth(float width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}

	@Override
	public float calculatePerimeter() {
		return this.length + this.width;
	}

	@Override
	public float calculateArea() {
		return this.length * this.width;
	}

}
