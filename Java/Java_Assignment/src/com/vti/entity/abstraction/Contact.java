package com.vti.entity.abstraction;

public class Contact {
	private String name;
	private String number;
	
	public String getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Contact(String name, String number) {
		this.number = number;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nNumber: " + number;
	}
}
