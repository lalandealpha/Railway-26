package com.vti.backend.assignment4;

import java.util.Scanner;

import com.vti.entity.inheritance.StaffManagement;

public class Inheritance {
	public void Question1() {
		System.out.println("-------Question 1-------");
		System.out.println("Create 3 classes in com.vti.entity.inheritance");
	}
	
	public void Question2() {
		System.out.println("-------Question 2-------");
		System.out.println("Please select one of the following functions:");
		System.out.println("(1) Add a new Staff Account");
		System.out.println("(2) Search for information of a staff");
		System.out.println("(3) Show information of all staffs");
		System.out.println("(4) Delete a staff");
		StaffManagement sm = new StaffManagement();
		Scanner sc = new Scanner(System.in);
		boolean isCorrect = true;
		while(isCorrect) {
			boolean shn = sc.hasNextInt();
			String selectInput = sc.nextLine();
			if(shn && Integer.parseInt(selectInput) > 0 && Integer.parseInt(selectInput) < 5) {
				switch(Integer.parseInt(selectInput)) {
				case 1:
					sm.addStaff();
					isCorrect = false;
					break;
				case 2:
					sm.searchStaff();
					isCorrect = false;
					break;
				case 3:
					sm.getAllStaff();
					isCorrect = false;
					break;
				case 4:
					sm.deleteStaff();
					isCorrect = false;
					break;
				default:
				}
				
			} else {
				System.out.println("Please try again!");
			}
		}
	}
}
