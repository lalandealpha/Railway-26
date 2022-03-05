package com.vti.entity.annotations;

public class Student {
	private static int count = 0;
	private int id;
	private String name;

	public Student(String name) {
		super();
		this.id = ++count;
		this.name = name;
	}
	/**
	 * 
	 * @deprecated replaced by {@link #getIdV2()}
	 */
	
	@Deprecated
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getIdV2() {
		return "MSV: " + id;
	}
}
