package com.vti.entity.collection;

public class Student {
	private static int count = 0;
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		super();
		this.id = ++count;
		this.name = name;
	}
	
	public int compareTo(Student student) {
		return this.getName().compareTo(student.getName());
	}
}
