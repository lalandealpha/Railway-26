package com.vti.entity;
import java.time.LocalDate;

public class Teacher {
	private int id;
	private String email;
	private String userName;
	private String fullName;
	private Gender gender;
	private Department department;
	private Clazz[] inChargeOfs;
	private Exam[] createdExams;
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
	
	
	public String getClazz() {
		String result = "";
		for (int i = 0; i < inChargeOfs.length; i++) {
			result += inChargeOfs[i].name + ", ";
		}
		return result;
	}

	public void setClazz(Clazz[] inChargeOfs) {
		this.inChargeOfs = inChargeOfs;
	}
	
	public String getExam() {
		String result = "";
		for (int i = 0; i < createdExams.length; i++) {
			result += createdExams[i].title + ", ";
		}
		return result;
	}

	public void setExam(Exam[] createdExams) {
		this.createdExams = createdExams;
	}
	
	
	public LocalDate getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	
	
	public Teacher() {
	}
	
	public Teacher(int id, String email, String userName, String fullName, Gender gender, Department department) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.gender = gender;
		this.department = department;
		this.createDate = LocalDate.now();
	}
	
	public Teacher(int id, String email, String userName, String fullName, Gender gender, Department department, LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.gender = gender;
		this.department = department;
		this.createDate = createDate;
	}
	
	void goToWork() {
		System.out.println("I am going to work....");
	}
	
	void markExam() {
		System.out.println("I am marking Exam: ");
	}
}
