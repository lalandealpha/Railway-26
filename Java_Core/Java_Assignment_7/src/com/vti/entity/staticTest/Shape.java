package com.vti.entity.staticTest;

public abstract class Shape {
	public static final int maximumNumber = 5;
	public static int count = 0;

	public Shape() throws Exception {
		if (count >= maximumNumber) {
			throw new Exception("Maximum number of shapes: " + maximumNumber);
		} 
		count++;
	}

}
