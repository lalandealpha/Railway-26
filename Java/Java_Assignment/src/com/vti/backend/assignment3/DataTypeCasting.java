package com.vti.backend.assignment3;

import java.util.Random;
import java.util.Scanner;

public class DataTypeCasting {
	
	public void Question123() {
		// Question 1:
		System.out.println("-------Question 1-------");
		
		float salary1  = 5240.5f;
		float salary2 = 10970.055f;
		
		int salary1Casting = (int) salary1;
		int salary2Casting = (int) salary2;
	
		System.out.println("Rounded Salary 1: " + salary1Casting);
		System.out.println("Rounded Salary 2: " + salary2Casting);
		String toString = salary1Casting + "";
		System.out.println("");
		
		// Question 2:
		 System.out.println("-------Question 2-------");
		Random random = new Random();
		int i = random.nextInt(100000);
		System.out.println(String.format("%05d", i));
		System.out.println("");
		
		// Question 3:
		// Way 1:
		System.out.println("-------Question 3 Way 1-------");
		String iToString = String.format("%05d", i) + "";
		String haiSoCuoi = iToString.substring(3);
		System.out.println(haiSoCuoi);
		// Way 2:
		System.out.println("-------Question 3 Way 2-------");
		System.out.println(i % 100); // Cach 2 se xuat hien truong hop khong dung neu so la xxx00, xx00x
		System.out.println("");
	}
	
	
	public void Question4() {
		// Question 4: 
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the 1st integer: ");	
		boolean isCorrect1 = false;
		boolean isCorrect2 = false;
		while (!isCorrect1) {
			boolean scanHasNext1 = scanner.hasNextInt();
			String test1 = scanner.next();
			if (scanHasNext1) {
				System.out.println("Please enter the 2st integer: ");
				while (!isCorrect2) {
					
					boolean scanHasNext2 = scanner.hasNextInt();	
					String test2 = scanner.next();
					if (scanHasNext2) {
						int i1 = Integer.parseInt(test1);
						int i2 = Integer.parseInt(test2);
						System.out.println("The quotient of the two numbers just entered is: " + (float) i1 / i2);
						isCorrect1 = true;
						isCorrect2 = true;					
					} else {
						System.out.println("You did not enter a integer. Please try again!");		
					} 
				}
			} else {
				System.out.println("You did not enter a integer. Please try again!");
			}			
		}
		scanner.close();
	}
}
