package com.vti.entity.exceptionTest;

import java.util.List;

import com.vti.backend.assignment6.ScannerUtils;

public class Department {
	private int id;
	private String name;
	private List<Student> students;
	private List<Teacher> teachers;
	
	public Department() {
		System.out.print("Please enter the department's id: ");
		this.id = ScannerUtils.inputInt();
		System.out.print("Please enter the department's name: ");
		this.name = ScannerUtils.inputString();
	}
	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStudents() {
		String result = "";
		if(students == null) {
			result += "There are no students in this department.";
		} else {
			for (Student s : students) {
				result += "\n" + s.getFullName();
			}
		}
		return result;
	}
	
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public List<Student> getStudentsArray() {
		List<Student> result = students;
		return result;
	}
	
	public String getTeachers() {
		String result = "";
		if(teachers == null) {
			result += "There are no teachers in this department.";
		} else {
			for (Teacher t : teachers) {
				result += "\n" + t.getFullName();
			}
		}
		return result;
	}
	
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	@Override
	public String toString() {
		String result = "ID: " + id + "\nName: " + name + "\nStudent: ";
		if(students == null) {
			result += "There are no students in this department.";
		} else {
			for (Student s : students) {
				result += "\n" + s.getFullName();
			}
		}
		result += "\nTeacher: ";
		if(teachers == null) {
			result += "There are no teachers in this department.";
		} else {
			for (Teacher t : teachers) {
				result += "\n" + t.getFullName();
			}
		}

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
