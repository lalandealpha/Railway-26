package com.vti.entity.IOStreamTest;

import java.io.Serializable;

public class Student implements IStudent, Serializable {
	private int id;
	private String name;
	private int group;

	public Student(int id, String name, int group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getGroup() {
		return group;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrop(int group) {
		this.group = group;
	}

	@Override
	public void rollUp() {
		System.out.println(this.getName() + " is rolling up...");

	}

	@Override
	public void study() {
		System.out.println(this.getName() + " is studying...");

	}

	@Override
	public void cleanUp() {
		System.out.println(this.getName() + " is cleaning up...");

	}

}
