package com.vti.backend.assignment2Optional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import com.vti.entity.Department;
import com.vti.entity.Gender;
import com.vti.entity.Teacher;

public class SystemPrintF {

	public void Question1() {
		System.out.println("-------Question 1-------");
		System.out.printf("%d %n", 5);
	}

	public void Question2() {
		System.out.println('\n' + "-------Question 2-------");
		int i = 100000000;
		System.out.printf(Locale.US, "%,d %n", i);
	}

	public void Question3() {
		System.out.println('\n' + "-------Question 3-------");
		float x = 5.567098f;
		System.out.printf(Locale.ITALY, "%.4f", x);
		System.out.println("\n");
	}

	public void Question4() {
		System.out.println("-------Question 4-------");
		String name = "Steve Rogers";
		System.out.printf("I am '%s' and i am single ^^!", name);
		System.out.println("\n");
	}

	public void Question5() {
		System.out.println("-------Question 5-------");
		String pattern = "dd/MM/yyy HH'h':mm'p':ss's'";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date dateNow = new Date();
		String getDateNow = dateFormat.format(dateNow);
		System.out.println(getDateNow);
		System.out.println("\n");

		// Question 6: Show the information of teachers
		// create departments
		Department department1 = new Department(1, "IT");

		Department department2 = new Department(2, "English");

		Department department3 = new Department(3, "Japanese");

		// create teacher accounts
		Teacher teacher1 = new Teacher(1, "nrate0@goo.ne.jp", "nrate0", "Nedi Rate", Gender.FEMALE, department1, LocalDate.of(2020, 11, 12));

		Teacher teacher2 = new Teacher(2, "ldawbury1@telegraph.co.uk", "ldawbury1", "Lorilee Dawbury", Gender.MALE, department1, LocalDate.of(2021, 3, 22));
		
		Teacher teacher3 = new Teacher(3, "lesilmon2@indiegogo.com", "lesilmon2", "Lila Esilmon", Gender.MALE, department1, LocalDate.of(2019, 5, 19));

		Teacher teacher4 = new Teacher(4, "nagresswell3@godaddy.com", "agresswell3", "Axe Gresswell", Gender.MALE, department2, LocalDate.of(2018, 7, 25));

		Teacher teacher5 = new Teacher(5, "bscotson4@plala.or.jp", "bscotson4", "Brig Scotson", Gender.UNKNOWN, department2, LocalDate.of(2021, 11, 01));
		
		// set department.teachers
		Teacher[] teacherOfDept1 = { teacher1, teacher2, teacher3 };
		department1.setTeachers(teacherOfDept1);
		Teacher[] teacherOfDept2 = { teacher4 };
		department2.setTeachers(teacherOfDept2);

		System.out.println("-------Question 6-------");
		Teacher[] teacher = { teacher1, teacher2, teacher3, teacher4, teacher5 };
		System.out.printf("|%5s|%20s|%n", "ID", "Fullname");
		for (Teacher t : teacher) {
			System.out.printf("|%5s|%20s|%n", t.getId(), t.getFullName());
		}
		System.out.println("\n");
	}
}
