package Assignment2_optional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import Assignment1.Department;
import Assignment1.Gender;
import Assignment1.Teacher;

public class SystemPrintF {

	public static void main(String[] args) {

		// Question 1: Declare an integer equal to 5 and use the printf command to print
		// that integer.
		System.out.println("-------Question 1-------");
		System.out.printf("%d %n", 5);

		// Question 2: Declare 1 integer = 100 000 000 and use the command System out
		// printf to print
		// output that integer to the following format: 100,000,000
		System.out.println('\n' + "-------Question 2-------");
		int i = 100000000;
		System.out.printf(Locale.US, "%,d %n", i);

		// Question 3: Declare a real number = 5.567098 and use the System out printf
		// command to print the number
		// that only consists of 4 numbers after the comma
		System.out.println('\n' + "-------Question 3-------");
		float x = 5.567098f;
		System.out.printf(Locale.ITALY, "%.4f", x);
		System.out.println("\n");

		// Question 4: Declare the full name of a student, and print that student's name
		// in the following format
		System.out.println("-------Question 4-------");
		String name = "Steve Rogers";
		System.out.printf("I am '%s' and i am single ^^!", name);
		System.out.println("\n");

		// Question 5: Print out the current time in the following format
		// 04/24/2020 11h:16p:20s
		System.out.println("-------Question 5-------");
		String pattern = "dd/MM/yyy HH'h':mm'p':ss's'";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date dateNow = new Date();
		String getDateNow = dateFormat.format(dateNow);
		System.out.println(getDateNow);
		System.out.println("\n");

		// Question 6: Show the information of teachers
		// create departments
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "IT";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "English";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Japanese";

		// create teacher accounts
		Teacher teacher1 = new Teacher();
		teacher1.id = 1;
		teacher1.email = "nrate0@goo.ne.jp";
		teacher1.userName = "nrate0";
		teacher1.fullName = "Nedi Rate";
		teacher1.gender = Gender.FEMALE;
		teacher1.department = department1;
		teacher1.createDate = LocalDate.of(2020, 11, 12);

		Teacher teacher2 = new Teacher();
		teacher2.id = 2;
		teacher2.email = "ldawbury1@telegraph.co.uk";
		teacher2.userName = "ldawbury1";
		teacher2.fullName = "Lorilee Dawbury";
		teacher2.gender = Gender.MALE;
		teacher2.department = department1;
		teacher2.createDate = LocalDate.of(2021, 3, 22);

		Teacher teacher3 = new Teacher();
		teacher3.id = 3;
		teacher3.email = "lesilmon2@indiegogo.com";
		teacher3.userName = "lesilmon2";
		teacher3.fullName = "Lila Esilmon";
		teacher3.gender = Gender.MALE;
		teacher3.department = department1;
		teacher3.createDate = LocalDate.of(2019, 5, 19);

		Teacher teacher4 = new Teacher();
		teacher4.id = 4;
		teacher4.email = "nagresswell3@godaddy.com";
		teacher4.userName = "agresswell3";
		teacher4.fullName = "Axe Gresswell";
		teacher4.gender = Gender.MALE;
		teacher4.department = department2;
		teacher4.createDate = LocalDate.of(2018, 7, 25);

		Teacher teacher5 = new Teacher();
		teacher5.id = 5;
		teacher5.email = "bscotson4@plala.or.jp";
		teacher5.userName = "bscotson4";
		teacher5.fullName = "Brig Scotson";
		teacher5.gender = Gender.UNKNOWN;
		teacher5.createDate = LocalDate.of(2021, 11, 01);

		System.out.println("-------Question 6-------");
		Teacher[] teacher = { teacher1, teacher2, teacher3, teacher4, teacher5 };
		System.out.printf("|%5s|%20s|%n", "ID", "Fullname");
		for (Teacher t : teacher) {
			System.out.printf("|%5s|%20s|%n", t.id, t.fullName);
		}
		System.out.println("\n");
	}

}
