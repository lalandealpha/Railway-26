package com.vti.entity.finalTest;

import com.vti.backend.assignment6.ScannerUtils;

public class Student {
	private final int id;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public Student() {
		System.out.println("Please enter the student's id:");
		this.id = ScannerUtils.inputInt("ID must be an integer. Please try again!");
		System.out.println("Please enter the student's name:");
		this.name = ScannerUtils.inputString();
	}
	
	static final void study() {
		System.out.println("Studying...");
	}
}
