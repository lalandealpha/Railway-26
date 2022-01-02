package com.vti.backend;

import java.time.LocalDate;

import java.time.Month;

import com.vti.entity.objectInitialization.Department;
import com.vti.entity.objectInitialization.Pos;
import com.vti.entity.objectInitialization.Position;
import com.vti.entity.objectInitialization.Student;

public class Constructor {

	public void Question1() {
		System.out.println("-------Question 1a-------");
		System.out.println("Create 2 Constructors in Assignment1.Department\n");
		System.out.println("-------Question 1b-------");
		Department department1 = new Department();
		department1.setID(1);
		department1.setName("IT");
		Department department2 = new Department(2, "Jap");
		System.out.println(department1.toString());
		System.out.println(department2.toString());
	}

	public void Question2() {
		// create position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = Pos.ADMIN;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = Pos.MENTOR;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = Pos.STUDENT;

		System.out.println("-------Question 2a-------");
		System.out.println("Create 4 Constructors in com.vti.entity.Student\n");
		System.out.println("-------Question 2b-------");
		Student student1 = new Student();
		student1.setId(1);
		;
		student1.setEmail("alewisham5@phpbb.com");
		student1.setUserName("alewisham5");
		student1.setFullName("Ardelis Lewisham");
		student1.setPosition(position1);
		student1.setCreateDate(LocalDate.now());
		Student student2 = new Student(2, "kbranno6@independent.co.uk", "kbranno6", "Ardelis", "Lewisham");
		student2.setPosition(position3);
		Student student3 = new Student(3, "cwanjek7@tamu.edu", "cwanjek7", "Claribel", "Wanjek", position3);
		Student student4 = new Student(4, "fbayldon8@wordpress.org", "fbayldon8", "Fonsie", "Bayldon", position1,
				LocalDate.of(2020, Month.SEPTEMBER, 05));
		System.out.println("4 student accounts have been created successfully:");
		Student[] student = { student1, student2, student3, student4 };
		for (Student s : student) {
			System.out.println(s.toString() + "\n");
		}

	}
}
