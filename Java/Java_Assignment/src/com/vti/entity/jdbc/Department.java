package com.vti.entity.jdbc;

public class Department implements Comparable<Department> {
	private int id;
	private String name;

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public int compareTo(Department department) {
		return id > department.id ? 1 : -1;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + "\n" + "Department: " + name;
	}
}
