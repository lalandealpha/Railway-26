package com.vti.entity.exceptionTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.assignment6.ScannerUtils;

public class Clazz {
	public int id;
	public String name;
	public List<Student> participants;
	public LocalDate createDate;
	
	public Clazz() {
		System.out.println("Please enter the class's id: ");
		this.id = ScannerUtils.inputInt();
		System.out.println("Please enter the class's name: ");
		this.name = ScannerUtils.inputString();
		List<Student> students = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Do you want to add a student in this class?");
			System.out.println("(1) Yes");
			System.out.println("(2) No");
			try {
				int i = scanner.nextInt();
				if(i == 1) {
					students.add(new Student());
				} else if(i == 2) {
					break;
				} else {
					System.err.println("Please try again!");
				}
			} catch (Exception e) {
				System.err.println("Please try again!");
			} finally {
				scanner.nextLine();
			}
		}
		this.participants = students;
	}
	
	@Override
	public String toString() {
		String result = "Class'ID: " + id + "\nClass's name: " + name + "\nStudents: ";
		for (int i = 0; i < participants.size(); i++) {
			result += "\nStudent: " + i + ":\n" + participants.get(i).toString();
		}
		return result;
	}
}



