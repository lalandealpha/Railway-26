package com.vti.entity.jdbc;

import java.util.Date;

public class StudentAccount {
	private int id;
	private String email;
	private String username;
	private String fullname;
	private String departmentName;
	private Date createDate;

	public StudentAccount(int id, String email, String username, String fullname, Date createDate) {
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

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDepartmentId() {
		return departmentName;
	}

	public void setDepartmentId(String departmentName) {
		this.departmentName = departmentName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
