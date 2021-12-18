package com.vti.backend.assignment3;

import java.time.LocalDate;

import com.vti.entity.Teacher;

public class DefaultValue {
	
	public void Question1() {
		Teacher[] teachers = new Teacher[5];
		for (int i = 0; i < teachers.length; i++) {
			teachers[i] = new Teacher();
			teachers[i].setId(i +1);
			teachers[i].setEmail("Email " + (i +1));
			teachers[i].setUserName("Username " + (i +1));
			teachers[i].setFullName("Full name " + (i +1));
			teachers[i].setCreateDate(LocalDate.now());
		}
		
		for (Teacher ts : teachers) {
			System.out.println("ID: " + ts.getId());
			System.out.println("Email: " + ts.getEmail());
			System.out.println("Username: " + ts.getUserName());
			System.out.println("Full name: " + ts.getFullName());
			System.out.println("Created at: " + ts.getCreateDate());
			System.out.println("");
		}
	}
}
