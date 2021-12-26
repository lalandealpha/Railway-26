package com.vti.entity.demoFileAndIOStream;

import java.io.Serializable;

import com.vti.backend.utils.ScannerUtils;

public class Student implements Serializable {
	private int id;
	private String name;

	public Student() {
		System.out.println("Please enter the student's ID: ");
		this.id = ScannerUtils.inputID("ID must be an integer and greater than 0");
		System.out.println("Please enter the student's name: ");
		this.name = ScannerUtils.inputString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
