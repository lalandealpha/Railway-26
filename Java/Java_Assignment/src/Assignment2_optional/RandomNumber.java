package Assignment2_optional;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Random;

import Assignment1.Department;
import Assignment1.Enum_Position;
import Assignment1.Gender;
import Assignment1.Position;
import Assignment1.Student;

public class RandomNumber {

	public static void main(String[] args) {
		Random random = new Random();
		// Question 1: Get a random integer.
		System.out.println("-------Question 1-------");
		int x1 = random.nextInt();
		System.out.println(x1 + "\n");

		// Question 2: Get a random real number.
		System.out.println("-------Question 2-------");
		float x2 = random.nextFloat();
		System.out.println(x2 + "\n");

		// Question 3:
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

		System.out.println("-------Question 3-------");
		String[] studentName = { student1.fullName, student2.fullName, student3.fullName, student4.fullName,
				student5.fullName, student6.fullName, student7.fullName, student8.fullName, student9.fullName,
				student10.fullName, student11.fullName };
		int x = random.nextInt(10 - 0 + 1);
		System.out.println(studentName[x] + "\n");

		// Question 4: Print a random date between 24-07-1995 and 20-12-1995
		System.out.println("-------Question 4-------");
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		int randomInt = minDay + random.nextInt(maxDay - minDay + 1);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay + "\n");

		// Question 5: Print out a random date within the last 1 year
		System.out.println("-------Question 5-------");
		Date now = new Date();
		int year = now.getYear() - 1;
		int month = now.getMonth();
		int date = now.getDate();

		int dayNow = (int) LocalDate.now().toEpochDay();
		int now1 = (int) LocalDate.of(year, month, date).toEpochDay();
		int randomint1 = now1 + random.nextInt(dayNow - now1 + 1);
		LocalDate randomDay1 = LocalDate.ofEpochDay(randomint1);
		System.out.println(randomDay1 + "\n");

		// Question 6: Print out a random date in the past
		System.out.println("-------Question 6-------");
		int dayNow1 = (int) LocalDate.now().toEpochDay();
		int randomint2 = random.nextInt(dayNow1);
		LocalDate randomDay2 = LocalDate.ofEpochDay(randomint2);
		System.out.println(randomDay2 + "\n");

		// Question 7: Get a random 3 digit number
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
