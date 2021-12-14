package Assignment2_optional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import Assignment1.Department;
import Assignment1.Enum_Position;
import Assignment1.Gender;
import Assignment1.Position;
import Assignment1.Student;

public class InputFromConsole {

	public static void main(String[] args) {
		Question8();
		
	}
	
	public static void Question1() { // Question 1: Allow users input 3 integers
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

	public static void Question2() { // Question 2: Allow user input 2 float number
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

	public static void Question3() { // Question 3: Allow user to enter his/her first and last name and print the user's first and last name 
		System.out.println("Please enter your first name: ");
		Scanner scanner = new Scanner(System.in);
		String firstName = scanner.next();
		System.out.println("Please enter your last name: ");
		String lastName = scanner.next();
		System.out.println("Your name is: " + firstName + " " + lastName);
		scanner.close();
	}

	public static void Question4() throws ParseException { 	// Question 4: Allow user to input his/her birthday
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your birthday in the following format: dd-mm-yyyy ");
		String dateInput = scanner.next();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dateInput);
		System.out.println(date);
		scanner.close();
		}
	
	public static void Question5() { // Question 5: Allow user to create Student account
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
		position1.name = Enum_Position.ADMIN;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = Enum_Position.MENTOR;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = Enum_Position.STUDENT;

			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter full name: ");
			String fullNameInput = scanner.nextLine();
			System.out.println("Please choose an username: ");
			String userNameInput = scanner.next();
			System.out.println("Please enter your your email: ");
			String emailInput = scanner.next();
			Student student = new Student();
			final AtomicInteger count = new AtomicInteger(11);
			student.id = count.incrementAndGet();
			student.email = emailInput;
			student.userName = userNameInput;
			student.fullName = fullNameInput;
			System.out.println("Please enter your gender (MALE, FEMALE): ");
			String genderInput = scanner.next();
			switch (genderInput) {
			case "MALE":
				student.gender = Gender.MALE;
				break;
			case "FEMALE":
				student.gender = Gender.FEMALE;
				break;
			default:
				student.gender = Gender.UNKNOWN;
			}

//			System.out.println("Please enter DepartmentName");
//			String departmentInput = scanner.next();
//			System.out.println("Please enter Position:");
//			String positionInput = scanner.next();		
	
//			student.position.name = positionInput;
//			student.department.name = departmentInput;
			student.createDate = LocalDate.now();
			System.out.println("\n" +  "Your account has been created successfully!");
			System.out.println("ID: " + student.id);
			System.out.println("Email: " + student.email);
			System.out.println("Username: " + student.userName);
			System.out.println("Full name: " + student.fullName);
			System.out.println("Gender: " + student.gender);
			System.out.println("Created at: " + student.createDate);
			
			scanner.close();

	}

	public static void Question6() { // Question 6: Allow user to create Department.
		System.out.println("Please enter the name of the department:");
		Scanner scanner = new Scanner(System.in);
		String nameInput = scanner.next();
		Department department = new Department();
		department.name = nameInput;
		final AtomicInteger count = new AtomicInteger(3);
		department.id = (byte) count.incrementAndGet();
		System.out.println("Department created successfully!");
		System.out.println("DepartmentID: " + department.id);
		System.out.println("Department: " + department.name);
		scanner.close();
	}

	public static void Question7() {
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

	public static void Question8() {
		System.out.println("Please select the function you want to use.");
		System.out.println("(1) Create an account"); 
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
}



































