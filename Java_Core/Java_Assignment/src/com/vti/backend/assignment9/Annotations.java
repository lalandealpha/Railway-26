package com.vti.backend.assignment9;

import java.util.Date;

import com.vti.entity.annotations.Student;

public class Annotations {
	
	public void Question1() {
		System.out.println("-------Question 1-------");
		@SuppressWarnings("deprecation")
		Date date = new Date(2020, 5, 18);
		System.out.println(date);
	}
	
	@SuppressWarnings("deprecation")
	public void Question2() {
		System.out.println("-------Question 2-------");
		Student student = new Student("Nguyen Thanh Luan");
		System.out.println(student.getId());
		
		System.out.println(student.getIdV2());

	}
}
