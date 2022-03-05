package com.vti.entity;

import java.time.LocalDate;

public class Student {
	private int id;
	private String email;
	private String userName;
	private String fullName;
	private Gender gender;
	private Department department;
	private Position position;
	private Clazz[] studyIns;
	private LocalDate createDate;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department.getName();
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Pos getPosition() {
		return position.name;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getClazz() {
		String result = "";
		for (int i = 0; i < studyIns.length; i++) {
			result += studyIns[i].name + ", ";
		}
		return result;
	}

	public void setClazz(Clazz[] studyIns) {
		this.studyIns = studyIns;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Student() {

	}

	public Student(int id, String email, String userName, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
	}

	public Student(int id, String email, String userName, String firstName, String lastName, Position position) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = LocalDate.now();
	}

	public Student(int id, String email, String userName, String firstName, String lastName, Position position,
			LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = createDate;
	}

	void takeAnExamination() {
		System.out.println("I am taking Exam: ");
	}

	void goToSchool() {
		System.out.println("I am going to school...");
	}

	@Override
	public String toString() {
		String result = "ID: " + id + "\nEmail: " + email + "\nUsername: " + userName + "\nFull name: " + fullName
				+ "\nPosition: " + position.name + "\nCreated at: " + createDate;
		return result;

	}

}
