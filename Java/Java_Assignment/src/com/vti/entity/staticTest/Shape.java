package com.vti.entity.staticTest;

public abstract class Shape {
	public static final int maximumNumber = 5;
	public static int count = 0;

	public Shape() throws Exception {
		if (count < maximumNumber && Rectangle.countRec + Circle.countCir < maximumNumber) {
			count++;
		} else {
			throw new Exception("Maximum number of shapes: " + maximumNumber);
		}
	}

}
