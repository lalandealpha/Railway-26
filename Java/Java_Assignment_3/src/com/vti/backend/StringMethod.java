package com.vti.backend;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import com.vti.entity.Clazz;
import com.vti.entity.Department;
import com.vti.entity.Gender;
import com.vti.entity.Student;
import com.vti.entity.Teacher;

public class StringMethod {

	public void Question1And2() {
		// Question 1:
		System.out.println("-------Question 1-------");
		String s1 = "java and python";
		System.out.println("String length is: " + s1.length());
		System.out.println("");

		// Question 2:
		System.out.println("-------Question 2-------");
		String s2 = " are two of the popular programming languages.";
		String s3 = s1.concat(s2); // or s1 + s2
		System.out.println(s3);
	}

	public void Question3() {
		System.out.println("-------Question 3-------");
		System.out.println("Please enter your first name:");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String firstChar = s.substring(0, 1);
		String sToLowerCase = s.toLowerCase();
		String firstCharOfLC = sToLowerCase.substring(0, 1);
		if (firstChar.equals(firstCharOfLC)) {
			String s1 = firstCharOfLC.toUpperCase() + s.substring(1);
			System.out.println("Your name is: " + s1);
		} else {
			System.out.println("Your name is: " + s);
		}
		scanner.close();
	}

	public void Question4() {
		System.out.println("-------Question 4-------");
		System.out.println("Please enter your first name:");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		for (int i = 0; i < s.length(); i++) {
			String space = " ";
			String a = s.substring(i, i + 1);
			String b = a.toUpperCase();
			if (!a.equals(space)) {
				System.out.println("The " + i + " character is: " + b);
			} else {
				System.out.println("");
			}
		}
		scanner.close();
	}

	public void Question5() {
		System.out.println("-------Question 5-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your first name:");
		String firstName = scanner.next();
		System.out.println("Please enter your last name:");
		String lastName = scanner.next();
		System.out.println("Your name is: " + firstName + " " + lastName);
		scanner.close();
	}

	public void Question6() {
		System.out.println("-------Question 6-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your full name:");
		String fullName = scanner.nextLine();
		String[] words = fullName.split("\\s");
		System.out.println("Your first name is: " + words[0]);
		System.out.print("Your middle name is: ");
		for (int i = 1; i < (words.length - 1); i++) {
			System.out.print(words[i] + " ");
		}
		System.out.println("");
		System.out.println("Your last name is: " + words[words.length - 1]);
		scanner.close();
	}

	public void Question7() {
		System.out.println("-------Question 7-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your full name:");
		String fullName = scanner.nextLine();
		String trimmedFullName = fullName.trim();
		String[] words = trimmedFullName.split("\\s");
		System.out.print("Your name is: ");
		for (int i = 0; i < words.length; i++) {
			String firstChar = words[i].substring(0, 1);
			String restChar = words[i].substring(1);
			String result = firstChar.toUpperCase() + restChar.toLowerCase();
			System.out.print(result + " ");
		}
		scanner.close();
	}

	public void Question8() {
		// create departments
		Department department1 = new Department(1, "IT");

		Department department2 = new Department(2, "English");

		Department department3 = new Department(3, "Japanese");

		// create student accounts
		Student student1 = new Student();
		student1.setId(1);
		student1.setEmail("alewisham5@phpbb.com");
		student1.setUserName("alewisham5");
		student1.setFullName("Ardelis Lewisham");
		student1.setGender(Gender.FEMALE);
		student1.setDepartment(department1);
		student1.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student2 = new Student();
		student2.setId(2);
		student2.setEmail("kbranno6@independent.co.uk");
		student2.setUserName("kbranno6");
		student2.setFullName("Kathy Branno");
		student2.setGender(Gender.MALE);
		student2.setDepartment(department1);
		student2.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student3 = new Student();
		student3.setId(3);
		student3.setEmail("cwanjek7@tamu.edu");
		student3.setUserName("cwanjek7");
		student3.setFullName("Claribel Wanjek");
		student3.setGender(Gender.FEMALE);
		student3.setDepartment(department1);
		student3.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student4 = new Student();
		student4.setId(4);
		student4.setEmail("fbayldon8@wordpress.org");
		student4.setUserName("fbayldon8");
		student4.setFullName("Fonsie Bayldon");
		student4.setGender(Gender.FEMALE);
		student4.setDepartment(department1);
		student4.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student5 = new Student();
		student5.setId(5);
		student5.setEmail("ptwiddell9@fotki.com");
		student5.setUserName("ptwiddell9");
		student5.setFullName("Pernell Twiddell");
		student5.setGender(Gender.MALE);
		student5.setDepartment(department2);
		student5.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student6 = new Student();
		student6.setId(6);
		student6.setEmail("alewisham5@phpbb.com");
		student6.setUserName("alewisham5");
		student6.setFullName("Ardelis Lewisham");
		student6.setGender(Gender.FEMALE);
		student6.setDepartment(department2);
		student6.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student7 = new Student();
		student7.setId(7);
		student7.setEmail("ecantona@booking.com");
		student7.setUserName("ecantona");
		student7.setFullName("Emlen Canton");
		student7.setGender(Gender.UNKNOWN);
		student7.setDepartment(department2);
		student7.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student8 = new Student();
		student8.setId(8);
		student8.setEmail("alewisham@gmail.com");
		student8.setUserName("alewisham36");
		student8.setFullName("Ardelis Lewisham");
		student8.setGender(Gender.UNKNOWN);
		student8.setDepartment(department3);
		student8.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student9 = new Student();
		student9.setId(9);
		student9.setEmail("rphilipotb@samsung.com");
		student9.setUserName("rphilipotb");
		student9.setFullName("Rolf Philipot");
		student9.setGender(Gender.UNKNOWN);
		student9.setDepartment(department3);
		student9.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student10 = new Student();
		student10.setId(10);
		student10.setEmail("ovaard@netscape.com");
		student10.setUserName("ovaard");
		student10.setFullName("Olive Vaar");
		student10.setGender(Gender.FEMALE);
		student10.setDepartment(department3);
		student10.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student11 = new Student();
		student11.setId(10);
		student11.setEmail("emccreadiec@walmart.com");
		student11.setUserName("emccreadiec");
		student11.setFullName("Elke McCreadie");
		student11.setGender(Gender.UNKNOWN);
		student11.setDepartment(department3);
		student11.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		// create teacher accounts
		Teacher teacher1 = new Teacher(1, "nrate0@goo.ne.jp", "nrate0", "Nedi Rate", Gender.FEMALE, department1,
				LocalDate.of(2020, 11, 12));

		Teacher teacher2 = new Teacher(2, "ldawbury1@telegraph.co.uk", "ldawbury1", "Lorilee Dawbury", Gender.MALE,
				department1, LocalDate.of(2021, 3, 22));

		Teacher teacher3 = new Teacher(3, "lesilmon2@indiegogo.com", "lesilmon2", "Lila Esilmon", Gender.MALE,
				department1, LocalDate.of(2019, 5, 19));

		Teacher teacher4 = new Teacher(4, "nagresswell3@godaddy.com", "agresswell3", "Axe Gresswell", Gender.MALE,
				department2, LocalDate.of(2018, 7, 25));

		Teacher teacher5 = new Teacher(5, "bscotson4@plala.or.jp", "bscotson4", "Brig Scotson", Gender.UNKNOWN,
				department2, LocalDate.of(2021, 11, 01));

		// set department.teachers
		Teacher[] teacherOfDept1 = { teacher1, teacher2, teacher3 };
		department1.setTeachers(teacherOfDept1);
		Teacher[] teacherOfDept2 = { teacher4 };
		department2.setTeachers(teacherOfDept2);

		// set department.students
		Student[] studentOfDept1 = { student1, student2, student3, student4, student5 };
		department1.setStudents(studentOfDept1);

		Student[] studentOfDept2 = { student6, student7 };
		department2.setStudents(studentOfDept2);

		Student[] studentOfDept3 = { student8, student9, student10, student11 };
		department3.setStudents(studentOfDept3);

		// create classes
		Clazz clazz1 = new Clazz();
		clazz1.id = 1;
		clazz1.name = "Railway26";
		clazz1.creator = teacher1;
		Student[] studentOfclazz1 = { student1, student2 };
		clazz1.participants = studentOfclazz1;
		clazz1.createDate = LocalDate.of(2021, 9, 18);

		Clazz clazz2 = new Clazz();
		clazz2.id = 2;
		clazz2.name = "Enterprise1";
		clazz2.creator = teacher2;
		Student[] studentOfclazz2 = { student3, student4 };
		clazz2.participants = studentOfclazz2;
		clazz2.createDate = LocalDate.of(2021, 9, 18);

		Clazz clazz3 = new Clazz();
		clazz3.id = 3;
		clazz3.name = "Challenger";
		clazz3.creator = teacher3;
		Student[] studentOfclazz3 = { student5, student6 };
		clazz3.participants = studentOfclazz3;
		clazz3.createDate = LocalDate.of(2021, 9, 18);

		Clazz clazz4 = new Clazz();
		clazz4.id = 4;
		clazz4.name = "Challenger";
		clazz4.creator = teacher4;
		Student[] studentOfclazz4 = { student7 };
		clazz4.participants = studentOfclazz4;
		clazz4.createDate = LocalDate.of(2021, 9, 18);

		Clazz clazz5 = new Clazz();
		clazz5.id = 5;
		clazz5.name = "Discovery";
		clazz5.creator = teacher5;
		Student[] studentOfclazz5 = { student8, student9, student10, student11 };
		clazz5.participants = studentOfclazz5;
		clazz5.createDate = LocalDate.of(2021, 9, 18);

		System.out.println("-------Question 8-------");
		Clazz[] clazzObject = { clazz1, clazz2, clazz3, clazz4, clazz5 };
		for (int i = 0; i < clazzObject.length; i++) {
			if (clazzObject[i].name.contains("Chal")) {
				System.out.println("clazzID: " + clazzObject[i].id);
				System.out.println("Name: " + clazzObject[i].name);
				System.out.println("Number of students: " + clazzObject[i].participants.length);
				System.out.println("Creator: " + clazzObject[i].creator.getFullName());
				System.out.println("Created at: " + clazzObject[i].createDate);
				System.out.println("");
			} else {
				System.out.println("There are no clazzes whose names contain Chal");
			}
		}
	}

	public void Question9() {
		// create departments
		Department department1 = new Department(1, "IT");

		Department department2 = new Department(2, "English");

		Department department3 = new Department(3, "Japanese");

		// create student accounts
		Student student1 = new Student();
		student1.setId(1);
		student1.setEmail("alewisham5@phpbb.com");
		student1.setUserName("alewisham5");
		student1.setFullName("Ardelis Lewisham");
		student1.setGender(Gender.FEMALE);
		student1.setDepartment(department1);
		student1.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student2 = new Student();
		student2.setId(2);
		student2.setEmail("kbranno6@independent.co.uk");
		student2.setUserName("kbranno6");
		student2.setFullName("Kathy Branno");
		student2.setGender(Gender.MALE);
		student2.setDepartment(department1);
		student2.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student3 = new Student();
		student3.setId(3);
		student3.setEmail("cwanjek7@tamu.edu");
		student3.setUserName("cwanjek7");
		student3.setFullName("Claribel Wanjek");
		student3.setGender(Gender.FEMALE);
		student3.setDepartment(department1);
		student3.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student4 = new Student();
		student4.setId(4);
		student4.setEmail("fbayldon8@wordpress.org");
		student4.setUserName("fbayldon8");
		student4.setFullName("Fonsie Bayldon");
		student4.setGender(Gender.FEMALE);
		student4.setDepartment(department1);
		student4.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student5 = new Student();
		student5.setId(5);
		student5.setEmail("ptwiddell9@fotki.com");
		student5.setUserName("ptwiddell9");
		student5.setFullName("Pernell Twiddell");
		student5.setGender(Gender.MALE);
		student5.setDepartment(department2);
		student5.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student6 = new Student();
		student6.setId(6);
		student6.setEmail("alewisham5@phpbb.com");
		student6.setUserName("alewisham5");
		student6.setFullName("Ardelis Lewisham");
		student6.setGender(Gender.FEMALE);
		student6.setDepartment(department2);
		student6.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student7 = new Student();
		student7.setId(7);
		student7.setEmail("ecantona@booking.com");
		student7.setUserName("ecantona");
		student7.setFullName("Emlen Canton");
		student7.setGender(Gender.UNKNOWN);
		student7.setDepartment(department2);
		student7.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student8 = new Student();
		student8.setId(8);
		student8.setEmail("alewisham@gmail.com");
		student8.setUserName("alewisham36");
		student8.setFullName("Ardelis Lewisham");
		student8.setGender(Gender.UNKNOWN);
		student8.setDepartment(department3);
		student8.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student9 = new Student();
		student9.setId(9);
		student9.setEmail("rphilipotb@samsung.com");
		student9.setUserName("rphilipotb");
		student9.setFullName("Rolf Philipot");
		student9.setGender(Gender.UNKNOWN);
		student9.setDepartment(department3);
		student9.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student10 = new Student();
		student10.setId(10);
		student10.setEmail("ovaard@netscape.com");
		student10.setUserName("ovaard");
		student10.setFullName("Olive Vaar");
		student10.setGender(Gender.FEMALE);
		student10.setDepartment(department3);
		student10.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		Student student11 = new Student();
		student11.setId(10);
		student11.setEmail("emccreadiec@walmart.com");
		student11.setUserName("emccreadiec");
		student11.setFullName("Elke McCreadie");
		student11.setGender(Gender.UNKNOWN);
		student11.setDepartment(department3);
		student11.setCreateDate(LocalDate.of(2020, Month.SEPTEMBER, 05));

		// create teacher accounts
		Teacher teacher1 = new Teacher(1, "nrate0@goo.ne.jp", "nrate0", "Nedi Rate", Gender.FEMALE, department1,
				LocalDate.of(2020, 11, 12));

		Teacher teacher2 = new Teacher(2, "ldawbury1@telegraph.co.uk", "ldawbury1", "Lorilee Dawbury", Gender.MALE,
				department1, LocalDate.of(2021, 3, 22));

		Teacher teacher3 = new Teacher(3, "lesilmon2@indiegogo.com", "lesilmon2", "Lila Esilmon", Gender.MALE,
				department1, LocalDate.of(2019, 5, 19));

		Teacher teacher4 = new Teacher(4, "nagresswell3@godaddy.com", "agresswell3", "Axe Gresswell", Gender.MALE,
				department2, LocalDate.of(2018, 7, 25));

		Teacher teacher5 = new Teacher(5, "bscotson4@plala.or.jp", "bscotson4", "Brig Scotson", Gender.UNKNOWN,
				department2, LocalDate.of(2021, 11, 01));

		// set department.teachers
		Teacher[] teacherOfDept1 = { teacher1, teacher2, teacher3 };
		department1.setTeachers(teacherOfDept1);
		Teacher[] teacherOfDept2 = { teacher4 };
		department2.setTeachers(teacherOfDept2);

		// set department.students
		Student[] studentOfDept1 = { student1, student2, student3, student4, student5 };
		department1.setStudents(studentOfDept1);

		Student[] studentOfDept2 = { student6, student7 };
		department2.setStudents(studentOfDept2);

		Student[] studentOfDept3 = { student8, student9, student10, student11 };
		department3.setStudents(studentOfDept3);

		// create classes
		Clazz clazz1 = new Clazz();
		clazz1.id = 1;
		clazz1.name = "Railway26";
		clazz1.creator = teacher1;
		Student[] studentOfclazz1 = { student1, student2 };
		clazz1.participants = studentOfclazz1;
		clazz1.createDate = LocalDate.of(2021, 9, 18);

		Clazz clazz2 = new Clazz();
		clazz2.id = 2;
		clazz2.name = "Enterprise1";
		clazz2.creator = teacher2;
		Student[] studentOfclazz2 = { student3, student4 };
		clazz2.participants = studentOfclazz2;
		clazz2.createDate = LocalDate.of(2021, 9, 18);

		Clazz clazz3 = new Clazz();
		clazz3.id = 3;
		clazz3.name = "Challenger";
		clazz3.creator = teacher3;
		Student[] studentOfclazz3 = { student5, student6 };
		clazz3.participants = studentOfclazz3;
		clazz3.createDate = LocalDate.of(2021, 9, 18);

		Clazz clazz4 = new Clazz();
		clazz4.id = 4;
		clazz4.name = "Challenger";
		clazz4.creator = teacher4;
		Student[] studentOfclazz4 = { student7 };
		clazz4.participants = studentOfclazz4;
		clazz4.createDate = LocalDate.of(2021, 9, 18);

		Clazz clazz5 = new Clazz();
		clazz5.id = 5;
		clazz5.name = "Discovery";
		clazz5.creator = teacher5;
		Student[] studentOfclazz5 = { student8, student9, student10, student11 };
		clazz5.participants = studentOfclazz5;
		clazz5.createDate = LocalDate.of(2021, 9, 18);

		System.out.println("-------Question 9-------");
		Clazz[] clazzObject = { clazz1, clazz2, clazz3, clazz4, clazz5 };
		String comparedName = "Challenger";
		for (int i = 0; i < clazzObject.length; i++) {
			if (clazzObject[i].name.equals(comparedName)) {
				System.out.println("clazzID: " + clazzObject[i].id);
				System.out.println("Name: " + clazzObject[i].name);
				System.out.println("Number of students: " + clazzObject[i].participants.length);
				System.out.println("Creator: " + clazzObject[i].creator.getFullName());
				System.out.println("Created at: " + clazzObject[i].createDate);
				System.out.println("");
			} else {
				System.out.println("There is no clazz named Challenger");
			}
		}
	}

	public void Question10() {
		System.out.println("-------Question 10-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the first string:");
		String s1 = scanner.nextLine();
		System.out.println("Please enter the second string:");
		String s2 = scanner.nextLine();
		StringBuilder sb = new StringBuilder(s1);
		String rev = sb.reverse().toString();
		if (s2.equals(rev)) {
			System.out.println("These two strings are the reverses of each other.");
		} else {
			System.out.println("These two strings are not the reverses of each other.");
		}
		scanner.close();
	}

	public void Question11() {
		System.out.println("-------Question 11-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any string:");
		String s = scanner.nextLine();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("a")) {
				count += 1;
			}
		}
		System.out.println("\n" + "In the string: " + s);
		System.out.println("The 'a' charater has come " + count + " time(s) at position: ");
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("a")) {
				System.out.println(i + 1 + " ");
			}
		}
		scanner.close();
	}

	public void Question12() {
		System.out.println("-------Question 12-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any string:");
		String s = scanner.nextLine();
		StringBuilder sb = new StringBuilder(s);
		String result = "";
		for (int i = 0; i < sb.length(); i++) {
			result += sb.charAt(sb.length() - (i + 1));
		}
		System.out.println(result);
		scanner.close();
	}

	public void Question13() {
		System.out.println("-------Question 13-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any string:");
		String s = scanner.nextLine();
		if (s.matches(".*\\d.*")) {
			System.out.println("The string you just entered contains (a) number(s)");
		} else {
			System.out.println("The string you just entered does not contain a number.");
		}
		scanner.close();
	}

	public void Question14() {
		System.out.println("-------Question 14-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any string:");
		String s = scanner.nextLine();
		String result = "";
		System.out.println("Please enter the character you want to replace with '*': ");
		String replacing = scanner.next();
		for (int i = 0; i < s.length(); i++) {
			if (s.subSequence(i, i + 1).equals(replacing)) {
				result += "*";
			} else {
				result += s.charAt(i);
			}
		}
		System.out.println("\nThe result after replacing character '" + replacing + "' with '*' is:\n" + result);
		scanner.close();
	}

	public void Question15() {
		System.out.println("-------Question 15-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any string:");
		String s = scanner.nextLine();
		String result = "";
		String trimmedS = s.trim();
		String[] words = trimmedS.split("\\s");
		for (int i = 0; i < words.length; i++) {
			result += words[words.length - (i + 1)] + " ";
		}
		System.out.println("\nThe result after reversing the string you just entered is:\n" + result);
		scanner.close();
	}

	public void Question16() {
		System.out.println("-------Question 16-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any string:");
		String s1 = scanner.nextLine();
		System.out.println("Please enter the number of charaters in a part you want to split (integer; > 0): ");
		boolean isCorrect = false;
		while (!isCorrect) {
			boolean scanHasNext = scanner.hasNextInt();
			String s2 = scanner.nextLine();
			if (scanHasNext) {
				int n = Integer.parseInt(s2);
				if (n > 0) {
					if (s1.length() % n == 0) {
						int x = s1.length() / n;
						System.out.println("The string you just entered has been split into " + x + " equal parts with "
								+ n + " characters in each part as follows:");
						for (int j = 0; j < x; j++) {
							System.out.println("'" + s1.substring(n * j, n * (j + 1)) + "'");
						}
						isCorrect = true;
					} else {
						System.out.println("The string you just entered cannot be split into equal parts with " + n
								+ " characters in each part!");
						isCorrect = true;
					}
				} else {
					System.out.println("Please try again!");
				}
			} else {
				System.out.println("Please try again!");
			}
		}
		scanner.close();

	}
}
