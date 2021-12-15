package Assignment2_optional;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import Assignment1.Department;
import Assignment1.Gender;
import Assignment1.Student;

public class Methods {

	public static void main(String[] args) {
		Methods m = new Methods();
		boolean isCorrect = true;
		while (isCorrect) {
			System.out.println("Moi ban nhap vao chuc nang muon su dung: ");
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			switch(i) {
			case 1: 
				m.createAccount();
				sc.nextLine();
				System.out.println("Ban co muon thuc hien chuc nang khac khong?: ");
				String select = sc.nextLine();
				if (select.equals("Co")) {
					isCorrect = true;
				} else {
					isCorrect = false;
				}
				break;
			case 2:
				m.createDepartment();
				sc.nextLine();
				System.out.println("Ban co muon thuc hien chuc nang khac khong?: ");
				String select2 = sc.nextLine();
				if (select2.equals("Co")) {
					isCorrect = true;
				} else {
					isCorrect = false;
				}
				break;
			case 3:
				Question9();
				sc.nextLine();
				System.out.println("Ban co muon thuc hien chuc nang khac khong?: ");
				String select3 = sc.nextLine();
				if (select3.equals("Co")) {
					isCorrect = true;
				} else {
					isCorrect = false;
				}
				break;
			default:
				System.out.println("Moi ban nhap lai!");
			}
		}
	}
	
	public void createAccount() {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		System.out.println("Nhap ten day du: ");
		student.fullName = sc.nextLine();
		
		// fix scanner bug
		sc.nextLine();
		
		System.out.println("Nhap username: ");
		student.userName = sc.nextLine();
		System.out.println("Tao student thanh cong: " + student.toString());
	}
	
	public void createDepartment() {
		// tuong tu create account
		Department department = new Department();
		department.name = "Sale";
		department.id = 3;
		System.out.println("Tao department thanh cong:" + department.toString());
		
	}

	public void createUser() {
		
	}
	
	public static void goToSchool() {
		System.out.println("Going to school");
	}
	
	public static void goToHome() {
		System.out.println("Going home");
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
		int indexOfStudent = -1;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
