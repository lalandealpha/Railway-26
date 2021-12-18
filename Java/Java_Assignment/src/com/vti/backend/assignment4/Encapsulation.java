package com.vti.backend.assignment4;

import com.vti.entity.encapsulation.question1.Student;

public class Encapsulation {
	
	public void Question1() {
		Student student1 = new Student("Ardelis Lewisham", "Alabama");
		Student student2 = new Student("Kathy Branno", "Hawaii");
		Student student3 = new Student("Claribel Wanjek", "Indiana");
		Student student4 = new Student("Fonsie Bayldon", "Michigan");
		
		student1.setMark(6.7f);
		student2.setMark(5.0f);
		student3.setMark(3.9f);
		student4.setMark(7.5f);
		
		student1.addMark(2.2f);
		student2.addMark(0.8f);
		
		System.out.println("-------Question 1-------");
		Student[] students = { student1, student2, student3, student4 };
		for (Student s : students) {
			System.out.println(s.toString() + "\n");
		}	
	}
	
	public void Question2() {
		System.out.println("-------Question 2-------");
		System.out.println("Create 3 classes in com.vti.entity.encapsulation.question2");
	}
}

