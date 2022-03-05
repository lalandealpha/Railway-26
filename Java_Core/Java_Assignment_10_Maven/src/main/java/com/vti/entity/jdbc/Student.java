package com.vti.entity.jdbc;

import java.util.Date;

public class Student {
	private int id;
	private String email;
	private String username;
	private String fullname;
	private String departmentName;
	private Date createDate;

	public Student(int id, String email, String username, String fullname, Date createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\nEmail: " + email + "\nUsername: " + username + "\nFullname: " + fullname
				+ "\nDepartmentName: " + departmentName + "\nCreateDate: " + createDate + "\n";
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getFullname() {
		return fullname;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
