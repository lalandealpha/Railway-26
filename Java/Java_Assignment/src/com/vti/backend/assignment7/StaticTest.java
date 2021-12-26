package com.vti.backend.assignment7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.utils.ScannerUtils;
import com.vti.entity.staticTest.Circle;
import com.vti.entity.staticTest.PrimaryStudent;
import com.vti.entity.staticTest.Rectangle;
import com.vti.entity.staticTest.SecondaryStudent;
import com.vti.entity.staticTest.Shape;
import com.vti.entity.staticTest.Student;

public class StaticTest {
	
	List<Student> students;
	List<Shape> shapes;
	
	public StaticTest() {

	}
	
	public void Question1() {
		System.out.println("-------Question 1-------");
		students = new ArrayList<>();
		System.out.println("Create the 1st student account");
		students.add(new Student());
		System.out.println("Create the 2nd student account");
		students.add(new Student());
		System.out.println("Create the 3rd student account");
		students.add(new Student());
		System.out.println("Students created successfully!");
		for (Student s : students) {
			System.out.println(s.toString() + "\n");
		}
	}
	
	public void Question2() {
		System.out.println("-------Question 2-------");
		students = new ArrayList<>();
		System.out.println("Create the 1st student account");
		students.add(new Student());
		System.out.println("Create the 2nd student account");
		students.add(new Student());
		System.out.println("Create the 3rd student account");
		students.add(new Student());
		System.out.println("Students created successfully!");
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
	
	public void Question4() {
		System.out.println("-------Question 4-------");
	}
	
	public void Question5() {
		System.out.println("--------Question 5-------");
		students = new ArrayList<>();
		System.out.println("Create 1st student account");
		students.add(new Student());
		System.out.println("Create 2nd student account");
		students.add(new Student());
		System.out.println("Create 3rd student account");
		students.add(new Student());
		System.out.println("Students created successfully!");
		System.out.println("There is/are " + Student.count + " student(s) account created successfully!");
		System.out.println(SecondaryStudent.count);
	}

	public void Question6() {
		students = new ArrayList<>();
		System.out.println("Create the 1st student account");
		students.add(new PrimaryStudent());
		System.out.println("Create the 2nd student account");
		students.add(new PrimaryStudent());
		System.out.println("Create the 3rd student account");
		students.add(new SecondaryStudent());
		System.out.println("Create the 4th student account");
		students.add(new SecondaryStudent());
		System.out.println("Create the 5th student account");
		students.add(new SecondaryStudent());
		System.out.println("Create the 6th student account");
		students.add(new SecondaryStudent());
		
		
		System.out.println(Student.count + " Student(s) account created successfully!");
		System.out.println(PrimaryStudent.countps + " Primary student(s) account created.");
		System.out.println(SecondaryStudent.countss + " Secondary student(s) account created.");
	}

	public void Question7() {
		students = new ArrayList<>();
		students.add(new PrimaryStudent());
		students.add(new SecondaryStudent());
		SecondaryStudent s3 = new SecondaryStudent();
		SecondaryStudent s4 = new SecondaryStudent();
		SecondaryStudent s5 = new SecondaryStudent();
		PrimaryStudent s6 = new PrimaryStudent();
		PrimaryStudent s7 = new PrimaryStudent();
		PrimaryStudent s8 = new PrimaryStudent();
		PrimaryStudent s9 = new PrimaryStudent();
		PrimaryStudent s10 = new PrimaryStudent();
		SecondaryStudent s11 = new SecondaryStudent();
		PrimaryStudent s12 = new PrimaryStudent();
	
		System.out.println("Number of Primary students created successfully: " + PrimaryStudent.countps);
		System.out.println("Number of Secondary students created successfully: " + SecondaryStudent.countss);
		System.out.println("Number of students created successfully: " + Student.count);
	}
	
	public void Question8() throws Exception {
		shapes = new ArrayList<>();
		shapes.add(new Rectangle(30f, 22f));
		shapes.add(new Circle(13f));
		Rectangle shape3 = new Rectangle(12f, 5f);
		Circle shape4 = new Circle(22f);
		Circle shape5 = new Circle(15f);
		Rectangle shape6 = new Rectangle(25f, 7f);
		
		System.out.println("Number of rectangles created successfully: " + Rectangle.countRec);
		System.out.println("Number of circles created successfully: " + Circle.countCir);
		System.out.println("Number of shapes created successfully: " + Shape.count);
	}
	
	public void Question9() {
		System.out.println("-------Question 9-------");
	}
}





























