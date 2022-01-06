package com.vti.entity;

import java.time.LocalDate;
import java.util.Date;

public class Student implements Comparable<Student> {
	private String fullname;
	private String id;
	private LocalDate birthday;
	private int requirementsAnalysis;
	private int softwareDesign;
	private int javaPrograming;
	private int codeAndUnitTest;
	private int managementTool;

	public Student(String fullname) {
		super();
		this.fullname = fullname;
	}

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

	public int getRequirementsAnalysis() {
		return requirementsAnalysis;
	}

	public void setRequirementsAnalysis(int requirementsAnalysis) {
		this.requirementsAnalysis = requirementsAnalysis;
	}

	public int getSoftwareDesign() {
		return softwareDesign;
	}

	public void setSoftwareDesign(int softwareDesign) {
		this.softwareDesign = softwareDesign;
	}

	public int getJavaPrograming() {
		return javaPrograming;
	}

	public void setJavaPrograming(int javaPrograming) {
		this.javaPrograming = javaPrograming;
	}

	public int getCodeAndUnitTest() {
		return codeAndUnitTest;
	}

	public void setCodeAndUnitTest(int codeAndUnitTest) {
		this.codeAndUnitTest = codeAndUnitTest;
	}

	public int getManagementTool() {
		return managementTool;
	}

	public void setManagementTool(int managementTool) {
		this.managementTool = managementTool;
	}
	
	public float getAverageMark() {
		return (requirementsAnalysis + softwareDesign + javaPrograming + codeAndUnitTest + managementTool) / (float) 5;
	}

	@Override
	public int compareTo(Student stu) {
		if(stu == null) {
			return 0;
		}
		if(this.getAverageMark() < stu.getAverageMark()) {
			return 1;
		} else if (this.getAverageMark() > stu.getAverageMark()) {
			return -1;
		}
		return 0;
	}

}
