package com.vti.entity;

public class Department {
	public byte id;
	public String name;
	public Student[] students;
	public Teacher[] teachers;
	
	public Department() {
		
	}
	
	public Department(int id, String name) {
		this.id = 0;
		this.name = name;
	}
	
	@Override
	public String toString() {
		String result = "DepartmentID: " + id + "\nDepartmentName: " + name;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		Department deparmentX = (Department) obj;
		if(id == deparmentX.id && name.equals(deparmentX.name)) {
			return true;
		} else {
			return false;
		}
	}
	
}
