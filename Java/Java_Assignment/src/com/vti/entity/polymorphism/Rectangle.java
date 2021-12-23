package com.vti.entity.polymorphism;

public class Rectangle implements IRectangle{
	protected float length;
	protected float width;
	
	public Rectangle(float length, float width) {
		this.length = length;
		this.width = width;
	}
	@Override
	public float calculatePerimeter() {
		System.out.println("The perimeter of the rectangle is:");
		return (this.length + this.width);
	}
	@Override
	public float calculateArea() {
		System.out.println("The area of the rectangle is:");
		return (this.length * this.width);
	}
	
}
