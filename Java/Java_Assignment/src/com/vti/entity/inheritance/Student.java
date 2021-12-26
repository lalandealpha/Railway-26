package com.vti.entity.inheritance;

public class Student extends Person {
	private int id;

	public Student(String name, int id) {
		super(name);
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return super.toString() + "\nID: " + id;
	}

}
