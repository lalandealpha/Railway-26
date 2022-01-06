package com.vti.backend.assignment2Optional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import com.vti.entity.objectInitialization.Department;
import com.vti.entity.objectInitialization.Gender;
import com.vti.entity.objectInitialization.Pos;
import com.vti.entity.objectInitialization.Position;
import com.vti.entity.objectInitialization.Student;
import com.vti.entity.objectInitialization.Teacher;

public class InputFromConsole {
	
	public void Question1() { // Question 1: Allow users input 3 integers
	System.out.println("-------Question 1-------");
	Scanner scanner = new Scanner(System.in);
	System.out.println("Please enter the 1st integer: ");
	boolean isCorrect1 = false;
	while (!isCorrect1) {
		boolean scanHasNext1 = scanner.hasNextInt();
		String i1 = scanner.nextLine();
		if(scanHasNext1) {
			System.out.println("The 1st integer you just entered is: " + i1);	
			isCorrect1 = true;
		} else {
			System.out.println("You did not enter a integer. Please try again!");
		}
	}
	
	System.out.println("\n" + "Please enter the 2nd integer: ");
	boolean isCorrect2 = false;
	while (!isCorrect2) {
		boolean scanHasNext2 = scanner.hasNextInt();
		String i2 = scanner.nextLine();
		if(scanHasNext2) {
			System.out.println("The 2nd integer you just entered is: " + i2);	
			isCorrect2 = true;
		} else {
			System.out.println("You did not enter a integer. Please try again!");
		}
	}

	System.out.println("\n" + "Please enter the 3rd integer: ");
	boolean isCorrect3 = false;
	while (!isCorrect3) {
		boolean scanHasNext3 = scanner.hasNextInt();
		String i3 = scanner.nextLine();
		if(scanHasNext3) {
			System.out.println("The 3rd integer you just entered is: " + i3);	
			isCorrect3 = true;
		} else {
			System.out.println("You did not enter a integer. Please try again!");
		}
	}
	scanner.close();
	
}

	public void Question2() { // Question 2: Allow user input 2 float number
		System.out.println("-------Question 2-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the 1st float number: ");
		boolean isCorrect1 = false;
		while (!isCorrect1) {
			boolean scanHasNext1 = scanner.hasNextFloat();
			String i1 = scanner.nextLine();
			if(scanHasNext1) {
				System.out.println("The 1st float number you just entered is: " + i1);	
				isCorrect1 = true;
			} else {
				System.out.println("You did not enter a float number. Please try again!");
			}
		}
		
		System.out.println('\n' + "Please enter the 2nd float number: ");
		boolean isCorrect2 = false;
		while (!isCorrect2) {
			boolean scanHasNext2 = scanner.hasNextFloat();
			String i2 = scanner.nextLine();
			if(scanHasNext2) {
				System.out.println("The 2nd float number you just entered is: " + i2);	
				isCorrect2 = true;
			} else {
				System.out.println("You did not enter a float number. Please try again!");
			}
		}
		scanner.close();		
	}

	public void Question3() { // Question 3: Allow user to enter his/her first and last name and print the user's first and last name 
		System.out.println("-------Question 3-------");
		System.out.println("Please enter your first name: ");
		Scanner scanner = new Scanner(System.in);
		String firstName = scanner.next();
		System.out.println("Please enter your last name: ");
		String lastName = scanner.next();
		System.out.println("Your name is: " + firstName + " " + lastName);
		scanner.close();
	}

	public void Question4() throws ParseException { 	// Question 4: Allow user to input his/her birthday
		System.out.println("-------Question 4-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your birthday in the following format: dd-mm-yyyy ");
		String dateInput = scanner.next();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dateInput);
		System.out.println(date);
		scanner.close();
		}
	
	public void Question5() { // Question 5: Allow user to create Student account
		// create departments
		Department department1 = new Department(1, "IT");

		Department department2 = new Department(2, "English");

		Department department3 = new Department(3, "Japanese");
		
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

		System.out.println("-------Question 5-------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter full name: ");
		String fullNameInput = scanner.nextLine();
		System.out.println("Please choose an username: ");
		String userNameInput = scanner.next();
		System.out.println("Please enter your your email: ");
		String emailInput = scanner.next();
		Student student = new Student();
		final AtomicInteger count = new AtomicInteger(11);
		student.setId(count.incrementAndGet());
		student.setEmail(emailInput);
		student.setUserName(userNameInput);
		student.setFullName(fullNameInput);
		System.out.println("Please enter your gender (MALE, FEMALE): ");
		String genderInput = scanner.next();
		switch (genderInput) {
		case "MALE":
			student.setGender(Gender.MALE);;
			break;
		case "FEMALE":
			student.setGender(Gender.FEMALE);
			break;
		default:
			student.setGender(Gender.UNKNOWN);
		}

//			System.out.println("Please enter DepartmentName");
//			String departmentInput = scanner.next();
//			System.out.println("Please enter Position:");
//			String positionInput = scanner.next();		
	
//			student.position.name = positionInput;
//			student.department.name = departmentInput;
		student.setCreateDate(LocalDate.now());
		System.out.println("\n" +  "Your account has been created successfully!");
		System.out.println("ID: " + student.getId());
		System.out.println("Email: " + student.getEmail());
		System.out.println("Username: " + student.getUserName());
		System.out.println("Full name: " + student.getFullName());
		System.out.println("Gender: " + student.getGender());
		System.out.println("Created at: " + student.getCreateDate());	
		

	}

	public void Question6() { // Question 6: Allow user to create Department.
		System.out.println("-------Question 6-------");
		System.out.println("Please enter the name of the department:");
		Scanner scanner = new Scanner(System.in);
		String nameInput = scanner.next();
		Department department = new Department();
		department.setName(nameInput);
		final AtomicInteger count = new AtomicInteger(3);
		department.setID(count.incrementAndGet());
		System.out.println("Department created successfully!");
		System.out.println("DepartmentID: " + department.getID());
		System.out.println("Department: " + department.getName());
		
	}

	public void Question7() {
		System.out.println("-------Question 7-------");
		System.out.println("Please enter an even number.");
		Scanner scanner = new Scanner(System.in);
		boolean isCorrect = false;
		while (!isCorrect) {
			int i = scanner.nextInt();
			if (i % 2 == 0) {
				System.out.println("The even number you just enterd is: " + i);
				isCorrect = true;
			} else {
				System.out.println("You did not enter an even number. Please try again!");
			}
		}
		scanner.close();
	}

	public void Question8() {
		System.out.println("-------Question 8-------");
		System.out.println("Please select the function you want to use.");
		System.out.println("(1) Create a student account"); 
		System.out.println("(2) Create a department");
		Scanner scanner = new Scanner(System.in);
		boolean isCorrect = false;
		while (!isCorrect) {
			String i = scanner.next();
			switch(i) {
			case "1":
				Question5();
				isCorrect = true;
				break;
			case "2":
				Question6();
				isCorrect = true;
				break;
			default:
				System.out.println("Please try again!");
			}
		}
		scanner.close();
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

		
		System.out.println("-------Question 9-------");
		Scanner scanner = new Scanner(System.in);
		Student[] stu = { student1, student2, student3, student4, student5, student6,
				student7, student8, student9, student10, student11 };
		int indexOfStudent = -1;
		Department[] dept = { department1, department2, department3 };
		int indexOfDept = -1;
		
		boolean isCorrect1 = true;
		boolean isCorrect2 = true;
		while (isCorrect1) {
			System.out.println("Choose a student from the following list:");		
			for (Student s : stu) {
				System.out.println(s.getFullName());
			}
			String studentInput = scanner.nextLine();
			for (int i = 0; i < stu.length; i++) {
				if (stu[i].getFullName().equals(studentInput)) {
					indexOfStudent = i;
					isCorrect1 = false;
				} 

			}	
		}

		while (isCorrect2) {
			System.out.println("Choose a department from the following list:");
			
			for (Department d : dept) {
				System.out.println(d.getName());
			}
			String deptInput = scanner.next();
			
			for (int j = 0; j < dept.length; j++) {
				if(dept[j].getName().equals(deptInput)) {
					indexOfDept = j;
					isCorrect2 = false;
				}
			}
		}

		stu[indexOfStudent].setDepartment(dept[indexOfDept]);
		Student[] studentOfDepartment =  { stu[indexOfStudent] };
		dept[indexOfDept].setStudents(studentOfDepartment);;
		System.out.println("");
		System.out.println("You just added student " + stu[indexOfStudent].getFullName() + 
				" into the department " + dept[indexOfDept].getName() + ".");
	}

	public void Question10() {

		Scanner scanner = new Scanner(System.in);
		boolean isCorrect = false;
		while (!isCorrect) {
			System.out.println("Please select the function you want to use.");
			System.out.println("(1) Create an account"); 
			System.out.println("(2) Create a department");
			System.out.println("(3) Add a student into a department");
			String i = scanner.next();
			switch(i) {
			case "1":
				Question5();
				System.out.println("Do you want to use an other function?");
				System.out.println("(1) Yes");
				System.out.println("(2) No");
				scanner.nextLine();
				boolean isCorrect2 = false;
				String x;
				while (!isCorrect2) {
					x = scanner.nextLine();
					if (x.equals("2")) {		
						System.out.println("See you again!");
						isCorrect2 = true;
						isCorrect = true;
					} else if (x.equals("1")) {
						isCorrect = false;
						isCorrect2 = true;
					} else {
						System.out.println("Please try again!");
					}
				}
				break;
			case "2":
				Question6();
				System.out.println("Do you want to use an other function?");
				System.out.println("(1) Yes");
				System.out.println("(2) No");
				boolean isCorrect3 = false;
				while (!isCorrect3) {
					scanner.nextLine();
					String x2 = scanner.next();
					if (x2.equals("2")) {		
						System.out.println("See you again!");
						isCorrect3 = true;
						isCorrect = true;
					} else if (x2.equals("1")) {
						isCorrect = false;
						isCorrect3 = true;
					} else {
						System.out.println("Please try again!");
					}
				}
				break;
			case "3":
				Question9();
				System.out.println("Do you want to use an other function?");
				System.out.println("(1) Yes");
				System.out.println("(2) No");
				boolean isCorrect4 = false;
				while (!isCorrect4) {
					String x3 = scanner.next();
					if (x3.equals("2")) {		
						System.out.println("See you again!");
						isCorrect4 = true;
						isCorrect = true;
					} else if (x3.equals("1")) {
						isCorrect = false;
						isCorrect4 = true;
					} else {
						System.out.println("Please try again!");
					}
				}
				break;
			default:
				System.out.println("Please try again!");
			}
		}
	scanner.close();	
	}
}
