package com.vti.backend.assignment6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.exceptionTest.Clazz;
import com.vti.entity.exceptionTest.Department;
import com.vti.entity.exceptionTest.Student;

public class ExceptionTest {
	public void Question1And2() {
		System.out.println("-------Question 1 And 2-------");
		try {
			System.out.println(devide(7, 0));
		} catch (ArithmeticException e) {
			System.err.println("Cannot devide by 0");
		} finally {
			System.out.println("Devide complete!");
		}
	}

	private int devide(int a, int b) {
		return a / b;
	}

	public void Question3() {
		System.out.println("-------Question 3-------");
		int[] numbers = { 1, 2, 3 };

		try {
			System.out.println(numbers[10]);
		} catch (Exception e) {
			System.err.println("Array index out of bounds!");
		}
	}

	public void Question4() {
		System.out.println("-------Question 4-------");
		getByIndex(3);
	}

	private void getByIndex(int index) {
		List<Department> departments = new ArrayList<>();
		departments.add(new Department(1, "IT"));
		departments.add(new Department(2, "English"));
		departments.add(new Department(3, "Japanese"));
		try {
			System.out.println(departments.get(index).toString());
		} catch (Exception e) {
			System.err.println("Department not found!");
		}
	}

	public void Question5And6() {
		System.out.println("-------Question 5 And 6-------");
		inputAge();
	}

	private void inputAge() {
		Scanner scanner = new Scanner(System.in);
		boolean isCorrect = true;
		while (isCorrect) {
			System.out.print("Please input your age: ");
			try {
				int age = scanner.nextInt();
				if (age > 0) {
					System.out.println("Your age is: " + age);
					isCorrect = false;
				} else {
					System.err.println("Wrong inputing! The age must be greater than 0, please try again.");
				}
			} catch (InputMismatchException e) {
				System.err.println("Wrong inputing! Please input your age as an integer.");
			} finally {
				scanner.nextLine();
			}
		}
		scanner.close();
	}

	public void Question7And8() {
		System.out.println("-------Question 7 And 8-------");
		System.out.println("Create class com.vti.backend.assignment6.ScannerUtils.");
	}

	public void Question9() {
		System.out.println("-------Question 9-------");
		Department department1 = new Department();
		System.out.println(department1.toString());
	}

	public void Question10() {
		System.out.println("-------Question 10-------");
		Clazz clazz = new Clazz();
		System.out.println("Class created successfully!");
		System.out.println(clazz.toString());

	}
}
