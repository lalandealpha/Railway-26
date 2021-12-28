package com.vti.entity.generic;

public class Student<T extends Number> {
	private T id;
	private String name;

	public Student(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public <T1, T2> void print(T1 a, T2 b) {
		System.out.println(a);
		System.out.println(b);
	}
}
