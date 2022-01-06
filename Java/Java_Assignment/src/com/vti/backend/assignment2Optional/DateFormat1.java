package com.vti.backend.assignment2Optional;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import com.vti.entity.objectInitialization.Answer;
import com.vti.entity.objectInitialization.Department;
import com.vti.entity.objectInitialization.Duration;
import com.vti.entity.objectInitialization.Exam;
import com.vti.entity.objectInitialization.Gender;
import com.vti.entity.objectInitialization.Question;
import com.vti.entity.objectInitialization.QuestionCategory;
import com.vti.entity.objectInitialization.QuestionType;
import com.vti.entity.objectInitialization.Teacher;

public class DateFormat1 {

	public void Question12345() {
		// create departments
		Department department1 = new Department(1, "IT");
		Department department2 = new Department(2, "English");
		Department department3 = new Department(3, "Japanese");
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

		// Question 1: Show the exam1's information having createDate formatted in
		// English format
		System.out.println("-------Question1-------");
		System.out.println("ID: " + exam1.id);
		System.out.println("Code: " + exam1.code);
		System.out.println("Title: " + exam1.title);
		System.out.println("Creator: " + exam1.creator.getFullName());

		Date input = Date.from(exam1.createDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Locale locale = new Locale("jp", "JP");
		DateFormat dF = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String examdate = dF.format(input);
		System.out.println("Created at: " + examdate + "\n");

		// Question 2: Show exam1's createDate in following format: Year - Month - Day -
		// Hour - Minute - Second
		System.out.println("-------Question 2-------");
		String pattern = "yyyy - MM - dd  HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String examdate2 = sdf.format(input);
		System.out.println(examdate2 + "\n");

		// Question 3: Show only year
		System.out.println("-------Question 3-------");
		String pattern1 = "yyyy";
		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern1);
		String examdate3 = sdf2.format(input);
		System.out.println(examdate3 + "\n");

		// Question 4: Show only year and month
		System.out.println("-------Question 4-------");
		String pattern2 = "yyyy - MM";
		SimpleDateFormat sdf3 = new SimpleDateFormat(pattern2);
		String examdate4 = sdf3.format(input);
		System.out.println(examdate4 + "\n");

		// Question 5: Show only MM - DD
		System.out.println("-------Question 5-------");
		String pattern3 = "MM - DD";
		SimpleDateFormat sdf4 = new SimpleDateFormat(pattern3);
		String examdate5 = sdf4.format(input);
		System.out.println(examdate5 + "\n");
	}
}
