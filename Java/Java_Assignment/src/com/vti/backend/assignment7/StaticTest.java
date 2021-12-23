package com.vti.backend.assignment7;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.staticTest.Student;

public class StaticTest {
	
	List<Student> students;
	
	public StaticTest() {
		students = new ArrayList<>();
		System.out.println("Create 1st student account");
		students.add(new Student());
		System.out.println("Create 2nd student account");
		students.add(new Student());
		System.out.println("Create 3rd student account");
		students.add(new Student());
	}
	
	public void Question1() {
		System.out.println("-------Question 1-------");
		System.out.println("Students created successfully!");
		for (Student s : students) {
			System.out.println(s.toString() + "\n");
		}
	}
	
	public void Question2() {
		System.out.println("-------Question 2-------");
		for (Student s : students) {
			Student.contributeMoney(100f);
		}
		students.get(0).buySnack(50f);
		students.get(1).buyBread(20f);
		students.get(2).buySupply(150f);
		for (Student s : students) {
			Student.contributeMoney(50f);
		}
		
	}
	

}
