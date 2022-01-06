package com.vti.entity.inheritance;

public class HighSchoolStudent extends Student {
	String clazz;
	String desiredUniversity;

	public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}

	@Override
	public String toString() {
		return super.toString() + "\nClass: " + clazz + "\nDesired University: " + desiredUniversity;
	}

}
