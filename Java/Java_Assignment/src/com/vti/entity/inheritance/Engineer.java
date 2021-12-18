package com.vti.entity.inheritance;

public class Engineer extends Staff {

	public Engineer(String fullName, int age, Gender gender, String address, String speciality) {
		super(fullName, age, gender, address);
		this.setSpeciality(speciality);
	}
	
	private String speciality;
	
	public String getSpeciality() {
		return speciality;
	}
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	@Override
	public String toString() {
		return super.toString() +"\nSpeciality: " + getSpeciality();
	}
}
