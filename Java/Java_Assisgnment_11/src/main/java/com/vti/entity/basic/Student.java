package com.vti.entity.basic;

import java.util.Date;

public class Student extends User {
	private Pos positon;

	public Student(int id, String email, String userName, String fullName, Department department, Date createDate,
			Pos positon) {
		super(id, email, userName, fullName, department, createDate);
		this.positon = positon;
	}
	
	public Student(int id, String email, String userName, String fullName, Date createDate) {
		super(id, email, userName, fullName, createDate);
	}

	public Pos getPositon() {
		return positon;
	}

	public void setPositon(Pos positon) {
		this.positon = positon;
	}

	@Override
	public String toString() {
		return "ID: " + getId() + "\nEmail: " + getEmail()
				+ "\nUsername" + getUserName() + "\nFullname: " + getFullName() + "\nDepartment: "
				+ getDepartment().getName() + "\nCreated at: " + getCreateDate();
	}
}
