package com.vti.entity.inheritance;

public class Employee extends Staff {

	public Employee(String fullName, int age, Gender gender, String address, String job) {
		super(fullName, age, gender, address);
		this.job = job;
	}

	private String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return super.toString() + "\nJob: " + getJob();
	}

}
