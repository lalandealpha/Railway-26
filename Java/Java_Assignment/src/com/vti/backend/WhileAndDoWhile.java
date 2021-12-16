package com.vti.backend;

import java.time.LocalDate;
import java.time.Month;

import Assignment1.Class;
import Assignment1.Department;
import Assignment1.Pos;
import Assignment1.Gender;
import Assignment1.Position;
import Assignment1.Student;
import Assignment1.Teacher;

public class WhileAndDoWhile {

	public void Question16() { // Question 16: Use WHILE, BREAK, CONTINUE to do Question above.
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
		
		// create position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = Pos.ADMIN;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = Pos.MENTOR;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = Pos.STUDENT;

		// create student accounts
		Student student1 = new Student();
		student1.id = 1;
		student1.email = "alewisham5@phpbb.com";
		student1.userName = "alewisham5";
		student1.fullName = "Ardelis Lewisham";
		student1.gender = Gender.FEMALE;
		student1.department = department1;
		student1.position = position2;
		student1.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student2 = new Student();
		student2.id = 2;
		student2.email = "kbranno6@independent.co.uk";
		student2.userName = "kbranno6";
		student2.fullName = "Kathy Branno";
		student2.gender = Gender.MALE;
		student2.department = department1;
		student2.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student3 = new Student();
		student3.id = 3;
		student3.email = "cwanjek7@tamu.edu";
		student3.userName = "cwanjek7";
		student3.fullName = "Claribel Wanjek";
		student3.gender = Gender.FEMALE;
		student3.department = department1;
		student3.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);


		Student student4 = new Student();
		student4.id = 4;
		student4.email = "fbayldon8@wordpress.org";
		student4.userName = "fbayldon8";
		student4.fullName = "Fonsie Bayldon";
		student4.gender = Gender.FEMALE;
		student4.department = department1;
		student4.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student5 = new Student();
		student5.id = 5;
		student5.email = "ptwiddell9@fotki.com";
		student5.userName = "ptwiddell9";
		student5.fullName = "Pernell Twiddell";
		student5.gender = Gender.MALE;
		student5.department = department2;
		student5.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student6 = new Student();
		student6.id = 6;
		student6.email = "alewisham5@phpbb.com";
		student6.userName = "alewisham5";
		student6.fullName = "Ardelis Lewisham";
		student6.gender = Gender.FEMALE;
		student6.department = department2;
		student6.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student7 = new Student();
		student7.id = 7;
		student7.email = "ecantona@booking.com";
		student7.userName = "ecantona";
		student7.fullName = "Emlen Canton";
		student7.gender = Gender.UNKNOWN;
		student7.department = department2;
		student7.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student8 = new Student();
		student8.id = 8;
		student8.email = "alewisham5@phpbb.com";
		student8.userName = "alewisham5";
		student8.fullName = "Ardelis Lewisham";
		student8.department = department3;
		student8.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student9 = new Student();
		student9.id = 9;
		student9.email = "rphilipotb@samsung.com";
		student9.userName = "rphilipotb";
		student9.fullName = "Rolf Philipot";
		student9.gender = Gender.MALE;
		student9.department = department3;
		student9.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student10 = new Student();
		student10.id = 10;
		student10.email = "ovaard@netscape.com";
		student10.userName = "ovaard";
		student10.fullName = "Olive Vaar";
		student10.gender = Gender.FEMALE;
		student10.department = department3;
		student10.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student11 = new Student();
		student11.id = 11;
		student11.email = "emccreadiec@walmart.com";
		student11.userName = "emccreadiec";
		student11.fullName = "Elke McCreadie";
		student11.gender = Gender.UNKNOWN;
		student11.department = department3;
		student11.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

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

		// create classes
		Class class1 = new Class();
		class1.id = 1;
		class1.name = "Railway26";
		class1.creator = teacher1;
		Student[] studentOfClass1 = { student1, student2 };
		class1.participants = studentOfClass1;
		class1.createDate = LocalDate.of(2021, 9, 18);

		Class class2 = new Class();
		class2.id = 2;
		class2.name = "Enterprise1";
		class2.creator = teacher2;
		Student[] studentOfClass2 = { student3, student4 };
		class2.participants = studentOfClass2;
		class2.createDate = LocalDate.of(2021, 9, 18);

		Class class3 = new Class();
		class3.id = 3;
		class3.name = "Challenger";
		class3.creator = teacher3;
		Student[] studentOfClass3 = { student5, student6 };
		class3.participants = studentOfClass3;
		class3.createDate = LocalDate.of(2021, 9, 18);

		Class class4 = new Class();
		class4.id = 4;
		class4.name = "Challenger";
		class4.creator = teacher4;
		Student[] studentOfClass4 = { student7 };
		class4.participants = studentOfClass4;
		class4.createDate = LocalDate.of(2021, 9, 18);

		Class class5 = new Class();
		class5.id = 5;
		class5.name ="Discovery";
		class5.creator = teacher5;
		Student[] studentOfClass5 = { student8, student9, student10, student11 };
		class5.participants = studentOfClass5;
		class5.createDate = LocalDate.of(2021, 9, 18);

		// Question 10: For each student,  show the information including email, full name, department name.0
		System.out.println("\n" + "Question 12.10: ");
		int i = 1;
		while (i < 100) {
			Student[] student = { student1, student2, student3, student4, student5, student6,
					student7, student8, student9, student10, student11 };
			for (Student s : student) {
					if (s.id == i) {
						System.out.println(
								"Account student " + i + "'s infomations: " + "\n" +
								"Email: " +s.email + "\n" +
								"Full name: " + s.fullName + "\n" +
								"Department: " + s.department.name + "\n"
								);
					}else {}
			}
			i++;
		}
				
		// Question 11: For each department, show the information including id and name.
		System.out.println("\n" + "Question 12.11: ");
		int x = 1;
		while (x < 100) {
			Department[] department = { department1, department2, department3 };
			for (Department d : department) {
				if (d.id == x) {
					System.out.println(
							"Department " + x + "'s information: " +"\n" +
							"ID: " + d.id + "\n" +
							"Name: " + d.name +"\n"
							);
				}else {}
			}
			x++;
		}
		
		// Question 12: Show only the information of the first 2 departments in the format of Question 10.
		// Way1
		System.out.println("\n" + "Question 12.12 the first way: ");
		int v = 1;
		while (v < 100) {
			Department[] department = { department1, department2, department3 };
			for (Department d : department) {
				if (d.id == v) {
					if (v == 3) {
					}else {
					System.out.println(
							"Department " + v + "'s information: " +"\n" +
							"ID: " + d.id + "\n" +
							"Name: " + d.name +"\n"
							);
					}
				}
			}
			v++;
		}
		
		// Way2
		System.out.println("\n" + "Question 12.12 the second way: ");
		int v2 = 1;
		while (v2 < 100) {
			Department[] department = { department1, department2, department3 };
			for (Department d : department) {
				if (d.id == v2) {
					if (v2 == 3) {
						break;
					}
					System.out.println(
							"Department " + v2 + "'s information: " +"\n" +
							"ID: " + d.id + "\n" +
							"Name: " + d.name +"\n"
							);
					}else {}
				}
			v2++;
		}
		
		// Question 13: Show all students information except student number 2.
		System.out.println("\n" + "Question 12.13: ");
		int n = 1;
		while (n < 100) {
			Student[] student = { student1, student2, student3, student4, student5, student6,
					student7, student8, student9, student10, student11 };
			for (Student s : student) {
				if (s.id == n) {
					if (n == 2) {
						continue;
					}
					System.out.println(
							"Student" + n + "'s information: " +"\n" +
							"ID: " + s.id + "\n" +
							"Email: " + s.email + "\n" +
							"User: " + s.userName + "\n" +
							"Name: " + s.fullName +"\n" + 
							"Gender: " + s.gender + "\n"
							);
					}else {}
				}
			n++;
		}
		
		// Question 14: Show the information of students whose ID < 4
		System.out.println("\n" + "Question 12.14: ");
		int a = 1;
		while (a < 4) {
			Student[] student = { student1, student2, student3, student4, student5, student6,
					student7, student8, student9, student10, student11 };
			for (Student s : student) {
				if (s.id == a) {
					System.out.println(
							"Student" + a + "'s information: " +"\n" +
							"ID: " + s.id + "\n" +
							"Email: " + s.email + "\n" +
							"User: " + s.userName + "\n" +
							"Name: " + s.fullName +"\n" + 
							"Gender: " + s.gender + "\n"
							);
					}else {}
				}
			a++;
		}
		
		// Question 15: Show numbers less than or equal to 20 and divisible by 2.
		System.out.println("\n" + "Question 12.15: Here are even numbers less than or equal to 20:");
		int b = 0;
		while (b <= 20) {
			if (b%2 != 0) {
			}else {
				System.out.println(b);
			}
			b++;
		}
		
	}	

	public void Question17() { // Question  17: Use DO WHILE, BREAK, CONTINUE to do Question above.
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
				
		// create position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = Pos.ADMIN;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = Pos.MENTOR;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = Pos.STUDENT;

		// create student accounts
		Student student1 = new Student();
		student1.id = 1;
		student1.email = "alewisham5@phpbb.com";
		student1.userName = "alewisham5";
		student1.fullName = "Ardelis Lewisham";
		student1.gender = Gender.FEMALE;
		student1.department = department1;
		student1.position = position2;
		student1.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student2 = new Student();
		student2.id = 2;
		student2.email = "kbranno6@independent.co.uk";
		student2.userName = "kbranno6";
		student2.fullName = "Kathy Branno";
		student2.gender = Gender.MALE;
		student2.department = department1;
		student2.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student3 = new Student();
		student3.id = 3;
		student3.email = "cwanjek7@tamu.edu";
		student3.userName = "cwanjek7";
		student3.fullName = "Claribel Wanjek";
		student3.gender = Gender.FEMALE;
		student3.department = department1;
		student3.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student4 = new Student();
		student4.id = 4;
		student4.email = "fbayldon8@wordpress.org";
		student4.userName = "fbayldon8";
		student4.fullName = "Fonsie Bayldon";
		student4.gender = Gender.FEMALE;
		student4.department = department1;
		student4.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student5 = new Student();
		student5.id = 5;
		student5.email = "ptwiddell9@fotki.com";
		student5.userName = "ptwiddell9";
		student5.fullName = "Pernell Twiddell";
		student5.gender = Gender.MALE;
		student5.department = department2;
		student5.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student6 = new Student();
		student6.id = 6;
		student6.email = "alewisham5@phpbb.com";
		student6.userName = "alewisham5";
		student6.fullName = "Ardelis Lewisham";
		student6.gender = Gender.FEMALE;
		student6.department = department2;
		student6.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student7 = new Student();
		student7.id = 7;
		student7.email = "ecantona@booking.com";
		student7.userName = "ecantona";
		student7.fullName = "Emlen Canton";
		student7.gender = Gender.UNKNOWN;
		student7.department = department2;
		student7.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student8 = new Student();
		student8.id = 8;
		student8.email = "alewisham5@phpbb.com";
		student8.userName = "alewisham5";
		student8.fullName = "Ardelis Lewisham";
		student8.department = department3;
		student8.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student9 = new Student();
		student9.id = 9;
		student9.email = "rphilipotb@samsung.com";
		student9.userName = "rphilipotb";
		student9.fullName = "Rolf Philipot";
		student9.gender = Gender.MALE;
		student9.department = department3;
		student9.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student10 = new Student();
		student10.id = 10;
		student10.email = "ovaard@netscape.com";
		student10.userName = "ovaard";
		student10.fullName = "Olive Vaar";
		student10.gender = Gender.FEMALE;
		student10.department = department3;
		student10.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student11 = new Student();
		student11.id = 11;
		student11.email = "emccreadiec@walmart.com";
		student11.userName = "emccreadiec";
		student11.fullName = "Elke McCreadie";
		student11.gender = Gender.UNKNOWN;
		student11.department = department3;
		student11.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

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

		// create classes
		Class class1 = new Class();
		class1.id = 1;
		class1.name = "Railway26";
		class1.creator = teacher1;
		Student[] studentOfClass1 = { student1, student2 };
		class1.participants = studentOfClass1;
		class1.createDate = LocalDate.of(2021, 9, 18);

		Class class2 = new Class();
		class2.id = 2;
		class2.name = "Enterprise1";
		class2.creator = teacher2;
		Student[] studentOfClass2 = { student3, student4 };
		class2.participants = studentOfClass2;
		class2.createDate = LocalDate.of(2021, 9, 18);

		Class class3 = new Class();
		class3.id = 3;
		class3.name = "Challenger";
		class3.creator = teacher3;
		Student[] studentOfClass3 = { student5, student6 };
		class3.participants = studentOfClass3;
		class3.createDate = LocalDate.of(2021, 9, 18);

		Class class4 = new Class();
		class4.id = 4;
		class4.name = "Challenger";
		class4.creator = teacher4;
		Student[] studentOfClass4 = { student7 };
		class4.participants = studentOfClass4;
		class4.createDate = LocalDate.of(2021, 9, 18);

		Class class5 = new Class();
		class5.id = 5;
		class5.name = "Discovery";
		class5.creator = teacher5;
		Student[] studentOfClass5 = { student8, student9, student10, student11 };
		class5.participants = studentOfClass5;
		class5.createDate = LocalDate.of(2021, 9, 18);

		// Question 10: For each student,  show the information including email, full name, department name.0
		System.out.println("\n" + "Question 12.10: ");
		int i = 1;
		do {
			Student[] student = { student1, student2, student3, student4, student5, student6, student7, student8,
					student9, student10, student11 };
			for (Student s : student) {
				if (s.id == i) {
					System.out.println("Account student " + i + "'s infomations: " + "\n" + "Email: " + s.email + "\n"
							+ "Full name: " + s.fullName + "\n" + "Department: " + s.department.name + "\n");
				} else {
				}
			}
			i++;
		} while (i < 100);
						
		// Question 11: For each department, show the information including id and name.
				System.out.println("\n" + "Question 12.11: ");
				int x = 1;
				do  {
					Department[] department = { department1, department2, department3 };
					for (Department d : department) {
						if (d.id == x) {
							System.out.println(
									"Department " + x + "'s information: " +"\n" +
									"ID: " + d.id + "\n" +
									"Name: " + d.name +"\n"
									);
						} else {}
					}
					x++;
				} while (x < 100);
				
		// Question 12: Show only the information of the first 2 departments in the format of Question 10.
		// Way1
		System.out.println("\n" + "Question 12.12 the first way: ");
		int v = 1;
		do {
			Department[] department = { department1, department2, department3 };
			for (Department d : department) {
				if (d.id == v) {
					if (v == 3) {
					} else {
						System.out.println("Department " + v + "'s information: " + "\n" + "ID: " + d.id + "\n"
								+ "Name: " + d.name + "\n");
					}
				}
			}
			v++;
		} while (v < 100);

		// Way2
		System.out.println("\n" + "Question 12.12 the second way: ");
		int v2 = 1;
		do {
			Department[] department = { department1, department2, department3 };
			for (Department d : department) {
				if (d.id == v2) {
					if (v2 == 3) {
						break;
					}
					System.out.println("Department " + v2 + "'s information: " + "\n" + "ID: " + d.id + "\n" + "Name: "
							+ d.name + "\n");
				} else {
				}
			}
			v2++;
		} while (v2 < 100);

		// Question 13: Show all students information except student number 2.
		System.out.println("\n" + "Question 12.13: ");
		int n = 1;
		do {
			Student[] student = { student1, student2, student3, student4, student5, student6, student7, student8,
					student9, student10, student11 };
			for (Student s : student) {
				if (s.id == n) {
					if (n == 2) {
						continue;
					}
					System.out.println("Student" + n + "'s information: " + "\n" + "ID: " + s.id + "\n" + "Email: "
							+ s.email + "\n" + "User: " + s.userName + "\n" + "Name: " + s.fullName + "\n" + "Gender: "
							+ s.gender + "\n");
				} else {
				}
			}
			n++;
		} while (n < 100);

		// Question 14: Show the information of students whose ID < 4
		System.out.println("\n" + "Question 12.14: ");
		int a = 1;
		do {
			Student[] student = { student1, student2, student3, student4, student5, student6, student7, student8,
					student9, student10, student11 };
			for (Student s : student) {
				if (s.id == a) {
					System.out.println("Student" + a + "'s information: " + "\n" + "ID: " + s.id + "\n" + "Email: "
							+ s.email + "\n" + "User: " + s.userName + "\n" + "Name: " + s.fullName + "\n" + "Gender: "
							+ s.gender + "\n");
				} else {
				}
			}
			a++;
		} while (a < 4);

		// Question 15: Show numbers less than or equal to 20 and divisible by 2.
		System.out.println("\n" + "Question 12.15: Here are even numbers less than or equal to 20:");
		int b = 0;
		do {
			if (b % 2 != 0) {
			} else {
				System.out.println(b);
			}
			b++;
		} while (b <= 20);
	}
}



