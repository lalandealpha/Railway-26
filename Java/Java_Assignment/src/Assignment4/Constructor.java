package Assignment4;

import java.time.LocalDate;
import java.time.Month;

import Assignment1.Department;
import Assignment1.Pos;
import Assignment1.Position;
import Assignment1.Student;

public class Constructor {
	
	public static void main(String[] args) {
		Constructor ct = new Constructor();
		ct.Question2();
	}

	public void Question1() {
		System.out.println("-------Question 1a-------");
		System.out.println("Create 2 Constructors in Assignment1.Department\n");
		System.out.println("-------Question 1b-------");
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "IT";
		Department department2 = new Department(0, "Jap");
		System.out.println(department1.toString());
		System.out.println(department2.toString());
	}

	public void Question2() {
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
		
		System.out.println("-------Question 2a-------");
		System.out.println("Create 4 Constructors in Assignment1.Student\n");
		System.out.println("-------Question 2b-------");
		Student student1 = new Student();
		student1.id = 1;
		student1.email = "alewisham5@phpbb.com";
		student1.userName = "alewisham5";
		student1.fullName = "Ardelis Lewisham";
		student1.position = position1;
		student1.createDate = LocalDate.now();
		Student student2 = new Student(2, "kbranno6@independent.co.uk", "kbranno6", "Ardelis", "Lewisham");
		student2.position = position3;
		Student student3 = new Student(3, "cwanjek7@tamu.edu", "cwanjek7", "Claribel", "Wanjek", position3);
		Student student4 = new Student(4, "fbayldon8@wordpress.org", "fbayldon8", "Fonsie", "Bayldon", position1, LocalDate.of(2020, Month.SEPTEMBER, 05));
		System.out.println("4 student accounts have been created successfully:");
		Student[] student = { student1, student2, student3, student4 };
		for (Student s : student) {
			System.out.println(s.toString() + "\n");
		}
		
	}
}
