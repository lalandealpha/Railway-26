package com.vti.backend.assignment8;

import com.vti.entity.generic.Student;

public class Generic {
	
	public void Question1() {
		System.out.println("-------Question 1-------");
		Student<Integer> student1 = new Student<>(1, "Nguyen Thanh Luan");
		Student<Float> student2 = new Student<>(2f, "Nguyen The An");
		Student<Double> student3 = new Student<>(3d, "Le Thi Lich");
	}
	
	public void Question2() {
		System.out.println("-------Question 2-------");
		Student<Integer> student1 = new Student<>(1, "Nguyen Thanh Luan");
		student1.print(1, 2);
		student1.print("Testing generic for methods", "Testing generic for methods...");
	}
}
