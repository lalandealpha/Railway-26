package com.vti.backend;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Random;

import com.vti.entity.Department;
import com.vti.entity.Gender;
import com.vti.entity.Student;

public class RandomNumber {

	public void Question1() {
		System.out.println("-------Question 1-------");
		Random random = new Random();
		int x1 = random.nextInt();
		System.out.println(x1 + "\n");
	}

	public void Question2() {
		System.out.println("-------Question 2-------");
		Random random = new Random();
		float x2 = random.nextFloat();
		System.out.println(x2 + "\n");
	}

	public void Question3() {
		System.out.println("-------Question 3-------");
		Random random = new Random();

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

		String[] studentName = { student1.getFullName(), student2.getFullName(), student3.getFullName(), student4.getFullName(),
				student5.getFullName(), student6.getFullName(), student7.getFullName(), student8.getFullName(), student9.getFullName(),
				student10.getFullName(), student11.getFullName() };
		int x = random.nextInt(10 - 0 + 1);
		System.out.println(studentName[x] + "\n");
	}

	public void Question4() {
		System.out.println("-------Question 4-------");
		Random random = new Random();
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		int randomInt = minDay + random.nextInt(maxDay - minDay + 1);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay + "\n");
	}

	public void Question5() {
		System.out.println("-------Question 5-------");
		Random random = new Random();
		Date now = new Date();
		int year = now.getYear() - 1;
		int month = now.getMonth();
		int date = now.getDate();

		int dayNow = (int) LocalDate.now().toEpochDay();
		int now1 = (int) LocalDate.of(year, month + 1, date).toEpochDay();
		int randomint1 = now1 + random.nextInt(dayNow - now1 + 1);
		LocalDate randomDay1 = LocalDate.ofEpochDay(randomint1);
		System.out.println(randomDay1 + "\n");
	}

	public void Question6() {
		System.out.println("-------Question 6-------");
		Random random = new Random();
		int dayNow1 = (int) LocalDate.now().toEpochDay();
		int randomint2 = random.nextInt(dayNow1);
		LocalDate randomDay2 = LocalDate.ofEpochDay(randomint2);
		System.out.println(randomDay2 + "\n");
	}

	public void Question7() {
		Random random = new Random();
		// Way 1
		System.out.println("-------Question 7 way 1-------");
		int x71 = random.nextInt(900) + 100;
		System.out.println(x71);

		// Way 2
		System.out.println("-------Question 7 way 2-------");
		int x72 = random.nextInt(999 - 0 + 1);
		System.out.println(x72);

		// Way 3
		System.out.println("-------Question 7 way 3-------");
		int x721 = 100 + random.nextInt(1000 - 100 + 1);
		System.out.println(x721);
	}
}
