package com.vti.frontend;

import com.vti.entity.*;
import com.vti.repository.*;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        AnswerRepository answerRepository = new AnswerRepository();
        CategoryQuestionRepository categoryQuestionRepository = new CategoryQuestionRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        ExamRepository examRepository = new ExamRepository();
        GroupRepository groupRepository = new GroupRepository();
        PositionRepository positionRepository = new PositionRepository();
        QuestionRepository questionRepository = new QuestionRepository();
        SalaryRepository salaryRepository = new SalaryRepository();
        TypeQuestionRepository typeQuestionRepository = new TypeQuestionRepository();

////         Create Account
//        Account account1 = new Account();
//        account1.setEmail("abc@gmail.com");
//        account1.setUsername("abc");
//        account1.setFirstName("AB");
//        account1.setLastName("C");
//
//        Account account2 = new Account();
//        account2.setEmail("edf@gmail.com");
//        account2.setUsername("edf");
//        account2.setFirstName("ED");
//        account2.setLastName("F");
//
//        accountRepository.createAccount(account1);
//        accountRepository.createAccount(account2);
//
//        List<Account> accounts = accountRepository.getAllAccounts();
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
//
////         Answer
//        Answer answer1 = new Answer();
//        answer1.setContent("This is some mock text....");
//        answer1.setIsCorrect(true);
//
//        Answer answer2 = new Answer();
//        answer2.setContent("This is some other mock text....");
//
//        answerRepository.createAnswer(answer1);
//        answerRepository.createAnswer(answer2);
//
//        List<Answer> answers = answerRepository.getAllAnswers();
//        for (Answer answer : answers) {
//            System.out.println(answer);
//        }
//
//        answerRepository.deleteAnswer((short) 1);
//        List<Answer> answers = answerRepository.getAllAnswers();
//        for (Answer answer : answers) {
//            System.out.println(answer);
//        }

//        // Category Question
//        CategoryQuestion categoryQuestion = new CategoryQuestion();
//        categoryQuestion.setName("Category1");
//        categoryQuestionRepository.createCategoryQuestion(categoryQuestion);
//
//        List<CategoryQuestion> categoryQuestions = categoryQuestionRepository.getAllCategoryQuestions();
//        for (CategoryQuestion cq : categoryQuestions) {
//            System.out.println(cq);
//        }
//
//        categoryQuestionRepository.updateCategoryQuestion((short) 1, "Category new name");
//        List<CategoryQuestion> categoryQuestions2 = categoryQuestionRepository.getAllCategoryQuestions();
//        for (CategoryQuestion cq : categoryQuestions2) {
//            System.out.println(cq);
//        }

//        // Department
//        Department department1 = new Department();
//        department1.setName("Department ABC");
//
//        Department department2 = new Department();
//        department2.setName("Department DEF");
//        departmentRepository.createDepartment(department1);
//        departmentRepository.createDepartment(department2);
//
//        List<Department> departments = departmentRepository.getAllDepartments();
//        for (Department dpt : departments) {
//            System.out.println(dpt);
//        }
//
//        departmentRepository.deleteDepartment((short) 1);
//
//        List<Department> departments1 = departmentRepository.getAllDepartments();
//        for (Department dpt : departments1) {
//            System.out.println(dpt);
//        }

//        // Exam
//        Exam exam1 = new Exam();
//        exam1.setTitle("Title1");
//        exam1.setDuration((short) 95);
//
//        Exam exam2 = new Exam();
//        exam2.setTitle("Title2");
//
//        examRepository.createExam(exam1);
//        examRepository.createExam(exam2);
//
//        List<Exam> exams = examRepository.getAllExams();
//        for (Exam exam : exams) {
//            System.out.println(exam);
//        }

//        // Position
//        Position position1 = new Position();
//        position1.setName(Position.PositionName.Dev);
//
//        Position position2 = new Position();
//        position2.setName(Position.PositionName.ScrumMaster);
//
//        positionRepository.createPosition(position1);
//        positionRepository.createPosition(position2);
//
//        List<Position> positions = positionRepository.getAllPositions();
//        for (Position position : positions) {
//            System.out.println(position);
//        }

//        // Salary
//        Salary salary1 = new Salary();
//        salary1.setSalaryName(Salary.SalaryName.PM);
//
//        Salary salary2 = new Salary();
//        salary2.setSalaryName(Salary.SalaryName.TEST);
//
//        salaryRepository.createSalary(salary1);
//        salaryRepository.createSalary(salary2);
//
//        List<Salary> salaries = salaryRepository.getAllSalaries();
//        for (Salary salary : salaries) {
//            System.out.println(salary);
//        }
//
//        salaryRepository.updateSalary((short) 1, Salary.SalaryName.DEV);
//
//        for (Salary salary : salaryRepository.getAllSalaries()) {
//            System.out.println(salary);
//        }

        //Type Question
        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.setName(TypeQuestion.TypeName.MULTIPLECHOICE);

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.setName(TypeQuestion.TypeName.ESSAY);

        typeQuestionRepository.createTypeQuestion(typeQuestion1);
        typeQuestionRepository.createTypeQuestion(typeQuestion2);

        List<TypeQuestion> typeQuestions = typeQuestionRepository.getAllTypeQuestions();
        for (TypeQuestion typeQuestion : typeQuestions) {
            System.out.println(typeQuestion);
        }
    }
}
