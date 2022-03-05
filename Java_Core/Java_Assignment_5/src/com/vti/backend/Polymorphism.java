package com.vti.backend;

import com.vti.entity.polymorphism.Rectangle;
import com.vti.entity.polymorphism.Square;
import com.vti.entity.polymorphism.Student;

public class Polymorphism {
	Student[] students = new Student[10];

	public Polymorphism() {
		students[0] = new Student(1, "Ardelis Lewisham", 1);
		students[1] = new Student(2, "Kathy Branno", 1);
		students[2] = new Student(3, "Claribel Wanjek", 3);
		students[3] = new Student(4, "Fonsie Bayldon", 2);
		students[4] = new Student(5, "Pernell Twiddell", 3);
		students[5] = new Student(6, "Ardelis Lewisham", 2);
		students[6] = new Student(7, "Emlen Canton", 1);
		students[7] = new Student(8, "Ardelis Lewisham", 2);
		students[8] = new Student(9, "Rolf Philipot", 3);
		students[9] = new Student(10, "Olive Vaar", 2);
	}

	public void Question1a() {
		System.out.println("-------Question 1a-------");
		System.out.println("Init 10 students in 3 groups.");
	}

	public void Question1b() {
		System.out.println("-------Question 1b-------");
		for (Student s : students) {
			s.rollUp();
		}
	}

	public void Question1c() {
		System.out.println("-------Question 1c-------");
		for (Student s : students) {
			if (s.getGroup() == 1) {
				s.study();
			}
		}
	}

	public void Question1d() {
		System.out.println("-------Question 1d-------");
		for (Student s : students) {
			if (s.getGroup() == 2) {
				s.cleanUp();
			}
		}
	}

	public void Question3() {
		System.out.println("-------Question 3-------");
		Rectangle rectangle = new Rectangle(16.7f, 10.4f);
		System.out.println(rectangle.calculatePerimeter());
		System.out.println(rectangle.calculateArea());

		Square square = new Square(13.3f, 13.3f);
		System.out.println(square.calculatePerimeter());
		System.out.println(square.calculateArea());
	}
}
