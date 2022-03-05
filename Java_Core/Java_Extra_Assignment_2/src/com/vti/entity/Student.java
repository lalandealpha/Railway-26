package com.vti.entity;

import java.time.LocalDate;
import java.util.Date;

public class Student {
	private String fullname;
	private String id;
	private LocalDate birthday;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Student(String fullname) {
		super();
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "Student [fullname=" + fullname + ", id=" + id + ", birthday=" + birthday + "]";
	}

}
