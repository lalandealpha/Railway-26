package com.vti.entity;

import java.time.LocalDate;

public class Clazz {
	public int id;
	public String name;
	public Teacher creator;
	public Student[] participants;
	public Department department;
	public LocalDate createDate;
}
