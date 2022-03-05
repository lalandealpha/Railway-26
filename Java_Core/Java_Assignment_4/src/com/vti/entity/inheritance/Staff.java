package com.vti.entity.inheritance;

public abstract class Staff {
	private String fullName;
	private int age;
	private Gender gender;
	private String address;
	
	public Staff(String fullName, int age, Gender gender, String address) {
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public int getAge() {
		return age;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		String result ="";
		result = "Fullname: " + fullName + "\nAge: " + age + "\nGender: " + gender + "\nAddress: " + address;
		return result;
	}
}
