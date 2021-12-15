package Assignment2_optional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import Assignment1.Department;
import Assignment1.Enum_Position;
import Assignment1.Gender;
import Assignment1.Position;
import Assignment1.Student;
import Assignment1.Teacher;

public class InputFromConsole {

	public static void main(String[] args) {
		Question1();
		
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

	public static void Question9() {
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

		// create student accounts
		Student student1 = new Student();
		student1.id = 1;
		student1.email = "alewisham5@phpbb.com";
		student1.userName = "alewisham5";
		student1.fullName = "Ardelis Lewisham";
		student1.gender = Gender.FEMALE;
		student1.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student2 = new Student();
		student2.id = 2;
		student2.email = "kbranno6@independent.co.uk";
		student2.userName = "kbranno6";
		student2.fullName = "Kathy Branno";
		student2.gender = Gender.MALE;
		student2.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student3 = new Student();
		student3.id = 3;
		student3.email = "cwanjek7@tamu.edu";
		student3.userName = "cwanjek7";
		student3.fullName = "Claribel Wanjek";
		student3.gender = Gender.FEMALE;
		student3.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);


		Student student4 = new Student();
		student4.id = 4;
		student4.email = "fbayldon8@wordpress.org";
		student4.userName = "fbayldon8";
		student4.fullName = "Fonsie Bayldon";
		student4.gender = Gender.FEMALE;
		student4.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student5 = new Student();
		student5.id = 5;
		student5.email = "ptwiddell9@fotki.com";
		student5.userName = "ptwiddell9";
		student5.fullName = "Pernell Twiddell";
		student5.gender = Gender.MALE;
		student5.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student6 = new Student();
		student6.id = 6;
		student6.email = "alewisham5@phpbb.com";
		student6.userName = "alewisham5";
		student6.fullName = "Ardelis Lewisham";
		student6.gender = Gender.FEMALE;
		student6.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student7 = new Student();
		student7.id = 7;
		student7.email = "ecantona@booking.com";
		student7.userName = "ecantona";
		student7.fullName = "Emlen Canton";
		student7.gender = Gender.UNKNOWN;
		student7.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student8 = new Student();
		student8.id = 8;
		student8.email = "alewisham5@phpbb.com";
		student8.userName = "alewisham5";
		student8.fullName = "Ardelis Lewisham";
		student8.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student9 = new Student();
		student9.id = 9;
		student9.email = "rphilipotb@samsung.com";
		student9.userName = "rphilipotb";
		student9.fullName = "Rolf Philipot";
		student9.gender = Gender.MALE;
		student9.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student10 = new Student();
		student10.id = 10;
		student10.email = "ovaard@netscape.com";
		student10.userName = "ovaard";
		student10.fullName = "Olive Vaar";
		student10.gender = Gender.FEMALE;
		student10.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);

		Student student11 = new Student();
		student11.id = 11;
		student11.email = "emccreadiec@walmart.com";
		student11.userName = "emccreadiec";
		student11.fullName = "Elke McCreadie";
		student11.gender = Gender.UNKNOWN;
		student11.createDate = LocalDate.of(2020, Month.SEPTEMBER, 05);
		
		System.out.println("-------Question 9-------");
		System.out.println("Choose a student from the following list:");
		Student[] stu = { student1, student2, student3, student4, student5, student6,
				student7, student8, student9, student10, student11 };
		for (Student s : stu) {
			System.out.println(s.fullName);
		}
		Scanner scanner = new Scanner(System.in);
		String studentInput = scanner.nextLine();
		int indexOfStudent = 0;
		for (int i = 0; i < stu.length; i++) {
			if (stu[i].fullName.equals(studentInput)) {
				indexOfStudent = i;
			}
		}
		System.out.println("");
		System.out.println("Choose a department from the following list:");
		Department[] dept = { department1, department2, department3 };
		for (Department d : dept) {
			System.out.println(d.name);
		}
		String deptInput = scanner.next();
		int indexOfDept = -1;
		for (int i = 0; i < dept.length; i++) {
			if(dept[i].name.equals(deptInput)) {
				indexOfDept = i;
			}
		}
		stu[indexOfStudent].department = dept[indexOfDept];
		Student[] studentOfDepartment =  { stu[indexOfStudent] };
		dept[indexOfDept].students = studentOfDepartment;
		System.out.println("");
		System.out.println("You just added student " + stu[indexOfStudent].fullName + " into the department " + dept[indexOfDept].name + ".");
		scanner.close();
		
	}

	public static void Question10() {
		System.out.println("Please select the function you want to use.");
		System.out.println("(1) Create an account"); 
		System.out.println("(2) Create a department");
		System.out.println("(3) Add a student into a department");
		Scanner scanner = new Scanner(System.in);
		boolean isCorrect = false;
		while (!isCorrect) {
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
		
	}
}



































