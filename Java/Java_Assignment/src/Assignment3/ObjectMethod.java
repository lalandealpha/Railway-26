package Assignment3;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import Assignment1.Department;
import Assignment1.Gender;
import Assignment1.Student;
import Assignment1.Teacher;

public class ObjectMethod {

	public static void main(String[] args) {
		Question6();
	}

	public static void Question1() {
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
		student1.department = department1;
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
		teacher5.department = department2;
		teacher5.createDate = LocalDate.of(2021, 11, 01);
		
		// set department.teachers
		Teacher[] teacherOfDept1 = { teacher1, teacher2, teacher3 };
		department1.teachers = teacherOfDept1;
		Teacher[] teacherOfDept2 = { teacher4 };
		department2.teachers = teacherOfDept2;
				
		// set department.students
		Student[] studentOfDept1 = { student1, student2, student3, student4, student5 };
		department1.students = studentOfDept1;
				
		Student[] studentOfDept2 = { student6, student7 };
		department2.students = studentOfDept2;
				
		Student[] studentOfDept3 = { student8, student9, student10, student11 };
		department3.students = studentOfDept3;
		
		System.out.println("-------Question 1-------");
		System.out.println("Information of Department 1:");
		System.out.println(department1.toString());
		System.out.println("");
		System.out.println("Students: ");
		for (Student s: studentOfDept1) {
			System.out.println(s.fullName);
		}
		System.out.println("");
		System.out.println("Teachers:");
		for(Teacher t: teacherOfDept1) {
			System.out.println(t.fullName);
		}
	}

	public static void Question3() {
		// create departments
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "IT";
		
		System.out.println("-------Question 3--------");
		System.out.println(department1.hashCode());
	}

	public static void Question4() {
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
		
		System.out.println("-------Question 4-------");
		if (department1.name.equals("English")) {
			System.out.println("Department 1 is English Department.");
		} else {
			System.out.println("Department 1 is not English Department.");
		}
	}
	
	public static void Question5() {
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

		System.out.println("------Question 5-------");
		if (department1.equals(department2)) {
			System.out.println("Department 1 is equal to epartment 2.");
		} else {
			System.out.println("Department 1 is not equal to epartment 2.");
		}
	}

	public static void Question6() {
		// create departments
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Marketing";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Boss of director";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Waiting room";
		
		Department department4 = new Department();
		department4.id = 4;
		department4.name = "Accounting";	
		
		Department department5 = new Department();
		department5.id = 5;
		department5.name = "Sale";	
		
		System.out.println("------Question 6------");
		System.out.println("The departments have been arranged in ascending alphabetical order as following:");
		String[] n =  { department1.name, department2.name, department3.name,  department4.name, department5.name };
		
		Arrays.sort(n);
		for (String string : n) {
			System.out.println(string);
		}
		
	}
}
































