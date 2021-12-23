package com.vti.entity.polymorphism;

public class Square extends Rectangle {

	public Square(float length, float width) {
		super(length, width);
		
	}
	
	@Override
	public float calculatePerimeter() {
		System.out.println("The perimeter of the square is:");
		return (this.length + this.width);
	}
	@Override
	public float calculateArea() {
		System.out.println("The area of the square is:");
		return (this.length * this.width);
	}
}
