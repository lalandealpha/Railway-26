package Assignment1;
import java.time.LocalDate;

import java.time.Month;

// Question 2: Initialize at least 3 Objects for each table
public class Program {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
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

		// create answer
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "Bypass Left Internal Iliac Artery to Left Femoral Artery with Nonautologous Tissue Substitute, Open Approach";
		answer1.isCorrect =  true;

		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.content = "Supplement Cul-de-sac with Autologous Tissue Substitute, Via Natural or Artificial Opening Endoscopic";
		answer2.isCorrect = false;

		Answer answer3 = new Answer();
		answer3.id = 3;
		answer3.content = "Reposition Left Ankle Joint, Percutaneous Approach";
		answer3.isCorrect = false;

		Answer answer4 = new Answer();
		answer4.id = 4;
		answer4.content = "Tendons, Destruction";
		answer4.isCorrect = true;

		Answer answer5 = new Answer();
		answer5.id = 5;
		answer5.content = "Supplement Thoracolumbar Vertebral Disc with Autologous Tissue Substitute, Open Approach";
		answer5.isCorrect = false;

		Answer answer6 = new Answer();
		answer6.id = 6;
		answer6.content = "High Dose Rate (HDR) Brachytherapy of Thorax Lymphatics using Other Isotope";
		answer6.isCorrect = false;

		Answer answer7 = new Answer();
		answer7.id = 7;
		answer7.content = "Replacement of Left Ventricle with Autologous Tissue Substitute, Open Approach";
		answer7.isCorrect = false;

		Answer answer8 = new Answer();
		answer8.id = 8;
		answer8.content = "Occlusion of Bladder with Intraluminal Device, Open Approach";
		answer8.isCorrect = false;

		Answer answer9 = new Answer();
		answer9.id = 9;
		answer9.content = "Therapeutic Exercise Treatment of Integumentary System - Head and Neck using Prosthesis";
		answer9.isCorrect = false;

		Answer answer10 = new Answer();
		answer10.id = 10;
		answer10.content = "Destruction of Parathyroid Gland, Open Approach";
		answer10.isCorrect = false;

		Answer answer11 = new Answer();
		answer11.id = 11;
		answer11.content = "Revision of Infusion Device in Lumbosacral Disc, Percutaneous Approach";
		answer11.isCorrect = false;


		// create question
		Question question1 = new Question();
		question1.id = 1;
		question1.content = "What is a correct syntax to output \"Hello World\" in Java";
		question1.createDate = LocalDate.of(2021, 8, 26);
		Answer[] answerOfQuestion1 = { answer1, answer2, answer3 };
		question1.answers = answerOfQuestion1;

		Question question2 = new Question();
		question2.id = 2;
		question2.content = "How do you insert COMMENTS in Java code?";
		question2.createDate = LocalDate.of(2021, 8, 26);
		Answer[] answerOfQuestion2 = { answer4, answer5 };
		question2.answers = answerOfQuestion2;

		Question question3 = new Question();
		question3.id = 3;
		question3.content = "Which data type is used to create a variable that should store text?";
		question3.createDate = LocalDate.of(2021, 8, 26);
		Answer[] answerOfQuestion3 = { answer6 };
		question3.answers = answerOfQuestion3;

		Question question4 = new Question();
		question4.id = 4;
		question4.content = "How do you create a variable with the numeric value 5?";
		question4.createDate = LocalDate.of(2021, 8, 26);
		Answer[] answerOfQuestion4 = { answer7, answer8, answer9 };
		question4.answers = answerOfQuestion4;

		Question question5 = new Question();
		question5.id = 5;
		question5.content = "The value of a string variable can be surrounded by single quotes.";
		question5.createDate = LocalDate.of(2021, 8, 26);
		Answer[] answerOfQuestion5 = { answer10, answer11 };
		question5.answers = answerOfQuestion5;

		// create question type
		QuestionType type1 = new QuestionType ();
		type1.id = 1;
		type1.name = "Essay";
		Question[] questionOfType1 = { question1, question2, question3 };
		type1.questions = questionOfType1;

		QuestionType type2 = new QuestionType ();
		type2.id = 2;
		type2.name = "Essay";
		Question[] questionOfType2 = { question4, question5 };
		type2.questions = questionOfType2;

		// create question category
		QuestionCategory category1 = new  QuestionCategory ();
		category1.id = 1;
		category1.name = "General knowledge";
		Question[] questionOfCategory1 = { question1, question2 };
		category1.questions = questionOfCategory1;

		QuestionCategory category2 = new  QuestionCategory ();
		category2.id = 2;
		category2.name = "Expertise'";
		Question[] questionOfCategory2 = { question3 };
		category2.questions = questionOfCategory2;

		QuestionCategory category3 = new  QuestionCategory ();
		category3.id = 1;
		category3.name = "Skill";
		Question[] questionOfCategory3 = { question4, question5 };
		category3.questions = questionOfCategory3;

		Exam exam1 = new Exam ();
		exam1.id = 1;
		exam1.code = "BA143";
		exam1.title = "First Exam";
		exam1.creator = teacher1;
		exam1.createDate = LocalDate.of(2015, 1, 20);
		exam1.duration =  Duration.MINUTE15;
		Question[] questionOfExam1 = { question1, question2, question3 };
		exam1.questions = questionOfExam1;

		Exam exam2 = new Exam ();
		exam2.id = 2;
		exam2.code = "CF443";
		exam2.title = "Mid-term Exam";
		exam2.creator = teacher1;
		exam2.createDate = LocalDate.of(2015, 1, 20);
		exam2.duration =  Duration.MINUTE45;
		Question[] questionOfExam2 = { question3, question4 };
		exam2.questions = questionOfExam2;
		
		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "HK007";
		exam3.title = "Final Exam";
		exam3.creator = teacher4;
		exam3.createDate = LocalDate.of(2015, 1, 20);
		exam2.duration = Duration.MINUTE90;
		Question[] questionOfExam3 = { question1, question3, question4, question5 };
		exam3.questions = questionOfExam3;

// Question 3: Print out all the properties of each object
		// answer 1
		
		//System.out.println(question1.toString());
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("answer1's information: ");
		System.out.println("ID: " + answer1.id);
		System.out.println("Content: " + answer1.content);
		System.out.println("true or false: " + answer1.isCorrect); 
		System.out.println("Question:  " + answer1.question); // can not get question's content
		System.out.println("\n");
		
		// class1
		System.out.println("class1's information: ");
		System.out.println("ID: " + class1.id);
		System.out.println("Name: " + class1.name);
		System.out.println("Created by: " + class1.creator.fullName);
		System.out.println("Department: " + class1.department); // can not get department's name
		System.out.println("Created at : " + class1.createDate);
		System.out.println("\n");
	
		// department 1
		System.out.println("department1's information");
		System.out.println("ID: " + department1.id);
		System.out.println("Name: " + department1.name);
		System.out.println("\n");
		
		//exam 1
		System.out.println("exam1's information: ");
		System.out.println("ID: " + exam1.id);
		System.out.println("Code: " + exam1.code);
		System.out.println("Title: " + exam1.title);
		System.out.println("Duration: " + exam1.duration.getValue() + "minutes"); 
		System.out.println("Created by: " + exam1.creator.fullName);
		System.out.println("\n");
		
		// position 1
		System.out.println("position1's information: ");
		System.out.println("ID: " + position1.id);
		System.out.println("Name: " + position1.name);
		System.out.println("Student: "); 
		for (Student s: studentPosition1 ) {
			System.out.println(s.fullName);
		}
		System.out.println("\n");
		
		// question 1
		System.out.println("question1's information: ");
		System.out.println("ID: " + question1.id);
		System.out.println("Content: " + question1.content);
		System.out.println("Type: " +  question1.type); // can not get type's name
		System.out.println("Created by: " + question1.creator); // can not get creator's fullname
		System.out.println("Created at: " + question1.createDate);
		System.out.println("\n");
		
		// question category 1
		System.out.println("questioncategory1's information: ");
		System.out.println("ID: " + category1.id);
		System.out.println("Name: " + category1.name);
		System.out.println("\n");
		
		// question type 1
		System.out.println("questiontype1's information: ");
		System.out.println("ID: " + type1.id);
		System.out.println("Name: " + type1.name);
		System.out.println("\n");
		
		// student 1
		System.out.println("student1's information: ");
		System.out.println("ID: " + student1.id);
		System.out.println("Username: " + student1.userName);
		System.out.println("Fullname: " + student1.fullName);
		System.out.println("Email: " + student1.email);
		System.out.println("Gender: " + student1.gender);
		System.out.println("Position: " + student1.position); // can not get position's name
		System.out.println("Department: " + student1.department); // can not get department's name
		System.out.println("Created at:" + student1.createDate);
		System.out.println("\n");
		
		// teacher 1
		System.out.println("teacher1's information: ");
		System.out.println("ID: " + teacher1.id);
		System.out.println("Username: " + teacher1.userName);
		System.out.println("Fullname: " + teacher1.fullName);
		System.out.println("Email: " + teacher1.email);
		System.out.println("Gender" + teacher1.gender);
		System.out.println("Department: " + teacher1.department); // can not get department's name
		System.out.println("Created at: " + teacher1.createDate);
	}
}
