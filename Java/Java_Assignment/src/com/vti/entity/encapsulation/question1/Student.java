package com.vti.entity.encapsulation.question1;

public class Student {
	private static int count = 0;
	private int id;
	private String fullName;
	private String hometown;
	private float mark;
	
	public Student(String fullName, String hometown) {
		count++;		
		this.id = count;
		this.fullName = fullName;
		this.hometown = hometown;
		this.mark = 0;
	}
	
	public void setMark(float mark) {
		this.mark = mark;
	}
	
	public void addMark(float mark) {
		this.mark += mark;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}

	@Override
	public String toString() {
		String result = "ID: " + id + "\nFull name: " + fullName + "\nMark: " + mark;
		if(this.mark < 4.0) {
			result += "\nClassification: Weak";
		} else if(this.mark >= 4.0 && this.mark < 6.0) {
			result += "\nClassification: Average";	
		}else if(this.mark >= 6.0 && this.mark < 8.0) {
			result += "\nClassification: Good";	
		}else {
			result += "\nClassification: Excellent";	
		}
		return result;
	}
	
}
