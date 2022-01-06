package com.vti.entity.comparing;

import java.time.LocalDate;

public class Student implements Comparable<Student>{
	private int id;
	private LocalDate birthday;
	private float mark;
	private String name;

	public Student(int id, String name, LocalDate birthday, float mark) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.mark = mark;
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", birthday=" + birthday + ", mark=" + mark + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student student) {
		return this.getName().compareTo(student.getName());
	}
}
