package com.vti.entity.staticTest;

import java.util.List;

import com.vti.backend.utils.ScannerUtils;

public class Student {
	public static int count = 0;
	protected static String college;
	protected int id;
	protected String name;
	protected static float moneyGroup;

	public Student() {
		if (count < 7 && PrimaryStudent.countps + SecondaryStudent.countss < 7) {
			count++;
			this.id = count;
			System.out.println("Please enter the student's name:");
			this.name = ScannerUtils.inputString();
		} else {
			System.err.println("Exceeded the number of student accounts allowed to create!");
		}
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
