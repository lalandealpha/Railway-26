package com.vti.entity.staticTest;

public class Circle extends Shape implements ICircle {
	public static final float pi = 3.14f;
	private float radius;

	public Circle(float radius) throws Exception {
			this.radius = radius;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	@Override
	public float calculateCircumference() {
		return radius * 2 * pi;
	}

	@Override
	public float calculateArea() {
		return radius * radius * pi;
	}

}
