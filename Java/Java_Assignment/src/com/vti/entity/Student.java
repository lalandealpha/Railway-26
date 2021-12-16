package com.vti.entity;
import java.time.LocalDate;

import Assignment1.Pos;

public class Student {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public Gender gender;
	public Department department;
	public Position position;
	public Class[] studyIns;
	public LocalDate createDate;
	
	public Student() {
		
	}
	
	public Student(int id, String email, String userName, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
	}
	
	public Student(int id, String email, String userName, String firstName, String lastName, Position position) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = LocalDate.now();
	}
	
	public Student(int id, String email, String userName, String firstName, String lastName, Position position, LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = createDate;
	}
	
	void takeAnExamination() {
		System.out.println("I am taking Exam: ");
	}
	
	void goToSchool () {
		System.out.println("I am going to school...");
	}


	
	@Override
	public String toString() {
		String result = "ID: " + id + "\nEmail: " + email + "\nUsername: " + userName + "\nFull name: " + fullName + "\nPosition: " + position.name + "\nCreated at: " + createDate;
		return result;
	
	}
}
