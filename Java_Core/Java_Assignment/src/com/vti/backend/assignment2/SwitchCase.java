package com.vti.backend.assignment2;

import java.time.LocalDate;
import java.time.Month;

import com.vti.entity.objectInitialization.Clazz;
import com.vti.entity.objectInitialization.Department;
import com.vti.entity.objectInitialization.Gender;
import com.vti.entity.objectInitialization.Pos;
import com.vti.entity.objectInitialization.Position;
import com.vti.entity.objectInitialization.Student;
import com.vti.entity.objectInitialization.Teacher;

public class SwitchCase {

	public void Question5() { // Question 5: Get the number of students in department 1, print the
								// corresponding output.
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

		// create position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = Pos.ADMIN;
		Student[] studentPosition1 = { student1, student5 };
		position1.students = studentPosition1;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = Pos.MENTOR;
		Student[] studentPosition2 = { student4, student7 };
		position2.students = studentPosition2;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = Pos.STUDENT;
		Student[] studentPosition3 = { student2, student3, student6, student8, student9, student10, student11 };
		position3.students = studentPosition3;

		// Question 5: Get the number of students in department 1, print the
		// corresponding output
		System.out.println("-------Question 5-------");
		switch (department1.getStudentsArray().length) {
		case 0:
			System.out.println(department1.getName() + " department has no students.");
			break;
		case 1:
			System.out.println(department1.getName() + " department has only 1 student.");
			break;
		default:
			System.out.println(department1.getName() + " department has many students.");
			break;
		}

	}

	public void Question6() { // Question 6: Use switch case to do Question 2.
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

		// create position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = Pos.ADMIN;
		Student[] studentPosition1 = { student1, student5 };
		position1.students = studentPosition1;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = Pos.MENTOR;
		Student[] studentPosition2 = { student4, student7 };
		position2.students = studentPosition2;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = Pos.STUDENT;
		Student[] studentPosition3 = { student2, student3, student6, student8, student9, student10, student11 };
		position3.students = studentPosition3;

		// Question 6: Use switch case to do Question 2
		System.out.println("-------Question 6-------");
		switch (clazz5.participants.length) {
		case 0:
			System.out.println("Class " + clazz5.name + " has no students.");
			break;
		case 1:
			System.out.println("Class " + clazz5.name + " has 1 student.");
			break;
		default:
			System.out.println("Class " + clazz5.name + " has many students.");
			break;
		}

	}

	public void Question7() { // Question 7: Use switch case to do Question 4.
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

		// create position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = Pos.ADMIN;
		Student[] studentPosition1 = { student1, student5 };
		position1.students = studentPosition1;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = Pos.MENTOR;
		Student[] studentPosition2 = { student4, student7 };
		position2.students = studentPosition2;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = Pos.STUDENT;
		Student[] studentPosition3 = { student2, student3, student6, student8, student9, student10, student11 };
		position3.students = studentPosition3;

		// Question 7: Use switch case to do Question 4:
		System.out.println("-------Question 7-------");
		System.out.println(student1.getPosition());
		switch (student1.getPosition()) {
		case ADMIN:
			System.out.println(student1.getFullName() + " is an admin.");
			break;
		default:
			System.out.println(student1.getFullName() + " is not an admin.");
			break;
		}

	}
}
