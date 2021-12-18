package com.vti.entity.inheritance;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the worker's full name:");
		String fullNameInput3 = scanner.nextLine();
		System.out.println("Please enter the worker's gender(MALE, FEMALE):");
		String genderInput3 = scanner.nextLine();
		System.out.println("Please enter the worker's address:");
		String addressInput3 = scanner.nextLine();
		System.out.println("Please enter the worker's level:");
		int level = scanner.nextInt();
		System.out.println("Please enter the worker's age:");
		int ageInput3 = scanner.nextInt();
		
		Worker worker = new Worker(fullNameInput3, ageInput3, null, addressInput3, level);
		
		if(genderInput3.equals("MALE")) {
			worker.setGender(Gender.MALE);
		} else if (genderInput3.equals("FEMALE")) {
			worker.setGender(Gender.FEMALE);
		} else {
			worker.setGender(Gender.UNKNOWN);
		}
		
		System.out.println(worker.toString() +"\nLevel: " + worker.getLevel());
	}

}
