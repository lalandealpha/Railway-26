package com.vti.backend.assignment1;

import java.time.LocalDate;

import java.time.Month;

import com.vti.entity.objectInitialization.Answer;
import com.vti.entity.objectInitialization.Clazz;
import com.vti.entity.objectInitialization.Department;
import com.vti.entity.objectInitialization.Duration;
import com.vti.entity.objectInitialization.Exam;
import com.vti.entity.objectInitialization.Gender;
import com.vti.entity.objectInitialization.Pos;
import com.vti.entity.objectInitialization.Position;
import com.vti.entity.objectInitialization.Question;
import com.vti.entity.objectInitialization.QuestionCategory;
import com.vti.entity.objectInitialization.QuestionType;
import com.vti.entity.objectInitialization.Student;
import com.vti.entity.objectInitialization.Teacher;

public class ObjectInitialization {

	public void Question() {
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

		// create answer
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "Bypass Left Internal Iliac Artery to Left Femoral Artery with Nonautologous Tissue Substitute, Open Approach";
		answer1.isCorrect = true;

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
		QuestionType type1 = new QuestionType();
		type1.id = 1;
		type1.name = "Essay";
		Question[] questionOfType1 = { question1, question2, question3 };
		type1.questions = questionOfType1;

		QuestionType type2 = new QuestionType();
		type2.id = 2;
		type2.name = "Essay";
		Question[] questionOfType2 = { question4, question5 };
		type2.questions = questionOfType2;

		// create question category
		QuestionCategory category1 = new QuestionCategory();
		category1.id = 1;
		category1.name = "General knowledge";
		Question[] questionOfCategory1 = { question1, question2 };
		category1.questions = questionOfCategory1;

		QuestionCategory category2 = new QuestionCategory();
		category2.id = 2;
		category2.name = "Expertise'";
		Question[] questionOfCategory2 = { question3 };
		category2.questions = questionOfCategory2;

		QuestionCategory category3 = new QuestionCategory();
		category3.id = 1;
		category3.name = "Skill";
		Question[] questionOfCategory3 = { question4, question5 };
		category3.questions = questionOfCategory3;

		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "BA143";
		exam1.title = "First Exam";
		exam1.creator = teacher1;
		exam1.createDate = LocalDate.of(2015, 1, 20);
		exam1.duration = Duration.MINUTE15;
		Question[] questionOfExam1 = { question1, question2, question3 };
		exam1.questions = questionOfExam1;

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "CF443";
		exam2.title = "Mid-term Exam";
		exam2.creator = teacher1;
		exam2.createDate = LocalDate.of(2015, 1, 20);
		exam2.duration = Duration.MINUTE45;
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
		System.out.println("answer1's information: ");
		System.out.println("ID: " + answer1.id);
		System.out.println("Content: " + answer1.content);
		System.out.println("true or false: " + answer1.isCorrect);
		System.out.println("Question:  " + answer1.question); // can not get question's content
		System.out.println("\n");

		// clazz1
		System.out.println("clazz1's information: ");
		System.out.println("ID: " + clazz1.id);
		System.out.println("Name: " + clazz1.name);
		System.out.println("Created by: " + clazz1.creator.getFullName());
		System.out.println("Department: " + clazz1.department); // can not get department's name
		System.out.println("Created at : " + clazz1.createDate);
		System.out.println("\n");

		// department 1
		System.out.println("department1's information");
		System.out.println("ID: " + department1.getID());
		System.out.println("Name: " + department1.getName());
		System.out.println("\n");

		// exam 1
		System.out.println("exam1's information: ");
		System.out.println("ID: " + exam1.id);
		System.out.println("Code: " + exam1.code);
		System.out.println("Title: " + exam1.title);
		System.out.println("Duration: " + exam1.duration.getValue() + "minutes");
		System.out.println("Created by: " + exam1.creator.getFullName());
		System.out.println("\n");

		// position 1
		System.out.println("position1's information: ");
		System.out.println("ID: " + position1.id);
		System.out.println("Name: " + position1.name);
		System.out.println("Student: ");
		for (Student s : studentPosition1) {
			System.out.println(s.getFullName());
		}
		System.out.println("\n");

		// question 1
		System.out.println("question1's information: ");
		System.out.println("ID: " + question1.id);
		System.out.println("Content: " + question1.content);
		System.out.println("Type: " + question1.type); // can not get type's name
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
		System.out.println("ID: " + student1.getId());
		System.out.println("Username: " + student1.getUserName());
		System.out.println("Fullname: " + student1.getFullName());
		System.out.println("Email: " + student1.getEmail());
		System.out.println("Gender: " + student1.getGender());
		System.out.println("Position: " + student1.getPosition());
		System.out.println("Department: " + student1.getDepartment());
		System.out.println("Created at:" + student1.getCreateDate());
		System.out.println("\n");

		// teacher 1
		System.out.println("teacher1's information: ");
		System.out.println("ID: " + teacher1.getId());
		System.out.println("Username: " + teacher1.getUserName());
		System.out.println("Fullname: " + teacher1.getFullName());
		System.out.println("Gender" + teacher1.getGender());
		System.out.println("Department: " + teacher1.getDepartment());
		System.out.println("Created at: " + teacher1.getCreateDate());
	}
}
