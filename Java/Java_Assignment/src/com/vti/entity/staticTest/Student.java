package com.vti.entity.staticTest;

import java.util.List;

import com.vti.backend.assignment6.ScannerUtils;

public class Student {
	public static int count = 0;
	private static String college;
	private int id;
	private String name;
	private static float moneyGroup;

	public Student() {
		this.id = ++count;
		System.out.println("Please enter the student's name:");
		this.name = ScannerUtils.inputString();
	}
	
	public static String getCollege() {
		return college;
	}
	public static void setCollege(String college) {
		Student.college = college;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static float getMoneyGroup() {
		return moneyGroup;
	}

	public static void setMoneyGroup(float moneyGroup) {
		Student.moneyGroup = moneyGroup;
	}
	
	public void buySnack(float f) {
		Student.setMoneyGroup(Student.getMoneyGroup() - f);
		System.out.println("Amount left after buying snack: " + Student.getMoneyGroup());
	}
	
	public void buyBread(float f) {
		Student.setMoneyGroup(Student.getMoneyGroup() - f);
		System.out.println("Amount left after buying bread: " + Student.getMoneyGroup());
	}
	
	public void buySupply(float f) {
		Student.setMoneyGroup(Student.getMoneyGroup() - f);
		System.out.println("Amount left after buying school supplies: " + Student.getMoneyGroup());
	}
	
	public static void contributeMoney(float f) {
		Student.setMoneyGroup(Student.getMoneyGroup() + f);
		System.out.println("Amount after contributing: " + Student.getMoneyGroup());

	}
	
	@Override
	public String toString() {
		return "ID: " + id + "\nName: " + name + "\nCollege: " + college;
	}
}
