package com.vti.frontend;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.*;
import com.vti.repository.*;

import javax.xml.soap.Detail;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        QuestionRepository questionRepository = new QuestionRepository();
        PositionRepository positionRepository = new PositionRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        AddressRepository addressRepository = new AddressRepository();
        ExamRepository examRepository = new ExamRepository();
        TypeQuestionRepository typeQuestionRepository = new TypeQuestionRepository();
        GroupRepository groupRepository = new GroupRepository();
        GroupAccountRepository groupAccountRepository = new GroupAccountRepository();
        DetailDepartmentRepository detailDepartmentRepository = new DetailDepartmentRepository();
        ManagerRepository managerRepository = new ManagerRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();

//        List<Account> accounts = accountRepository.getAllAccounts();
//        for (Account account : accounts) {
//            System.out.println(account);
//        }

//        List<Account> accounts3 = accountRepository.getAllAccounts();
//        for (Account account : accounts3) {
//            System.out.println(account.getFullName());
//            for (GroupAccount groupAccount : account.getGroupAccounts()) {
//                System.out.println(groupAccount.getGroup().getName());
//                System.out.println(groupAccount.getJoinDate());
//            }
//        }

//
//        List<Account> accounts2 = accountRepository.getAllAccounts();
//        for (Account account : accounts2) {
//            System.out.println("Account: " + account.getFullName());
//            System.out.println("Group created by this user:");
//            for (Group group : account.getCreatedGroups()) {
//                System.out.println(group.getName());
//            }
//        }

//        Manager manager = new Manager();
//        manager.setEmail("skadfjiiskd@gmail.com");
//        manager.setFirstName("sdjkfsdf");
//        manager.setLastName("iijj238");
//        manager.setUsername("sdiimznm");
//        manager.setDepartment(departmentRepository.getDepartmentByID((short) 5));
//        manager.setPosition(accountRepository.getAccountByID((short) 4).getPosition());
//        manager.setSalary(accountRepository.getAccountByID((short) 4).getSalary());
//
//        managerRepository.createManager(manager);

//
//        List<Question> questions = questionRepository.getAllQuestions();
//        for (Question question : questions) {
////            System.out.println(question);
//            System.out.println(question.getContent());
//            System.out.println(question.getCategoryQuestion().getName());
//            for (Exam exam : question.getExams()) {
//                System.out.println(exam.getTitle());
//            }
//
//            for (Answer answer : question.getAnswers()) {
//                System.out.println(answer.getContent());
//            }
//        }
//
//        List<TypeQuestion> typeQuestions = typeQuestionRepository.getAllTypeQuestions();
//        for (TypeQuestion typeQuestion : typeQuestions) {
//            System.out.println(typeQuestion.getName());
//            for (Question question : typeQuestion.getQuestions()) {
//                System.out.println(question.getContent());
//            }
//        }
//
//        List<Position> positions = positionRepository.getAllPositions();
//        for (Position position : positions) {
//            System.out.println(position);
//        }
//
//        List<Department> departments = departmentRepository.getAllDepartments();
//        for (Department department : departments) {
//            System.out.println(department);
//        }

//        List<DetailDepartment> detailDepartments = detailDepartmentRepository.getAllDetailDepartments();
//        List<Department> departments = new ArrayList<>();
//        for (DetailDepartment detailDepartment : detailDepartments) {
//            Department department = (Department) detailDepartment;
//            departments.add(department);
//        }
//
//        for (Department department : departments) {
//            System.out.println(department.getName());
//        }

//        DetailDepartment detailDepartment = new DetailDepartment();
//        detailDepartment.setName("akjsdf");
//        detailDepartment.setAddress(detailDepartmentRepository.getDetailDepartmentByID((short) 3).getAddress());
//        detailDepartment.setEmulationPoint((short) 30);
//
//        detailDepartmentRepository.createDetailDepartment(detailDepartment);

//
//        List<Address> addresses = addressRepository.getAllAddresss();
//        for (Address address : addresses) {
//            System.out.println(address);
//        }
//
//        List<Exam> exams = examRepository.getAllExams();
//        for (Exam exam : exams) {
//            System.out.println(exam);
//        }

//        Exam exam = examRepository.getExamByID((short) 2);
//        exam.getQuestions().add(questionRepository.getQuestionByID((short) 2));
//        examRepository.updateExam(exam);

//        Account inputAccount1 = new Account();
//        inputAccount1.setFirstName("ABDck");
//        inputAccount1.setLastName("sdkfiasdf");
//        inputAccount1.setUsername("akdiks");
//        inputAccount1.setEmail("kais@gmai.com");
//        Account resultAccount1 =  accountRepository.createAccount(inputAccount1);
//
//        Account inputAccount2 = new Account();
//        inputAccount2.setFirstName("ABDcsdssk");
//        inputAccount2.setLastName("sdkfiddfasdf");
//        inputAccount2.setUsername("akdsdssiks");
//        inputAccount2.setEmail("kaisdfss@gmai.com");
//        Account resultAccount2 =  accountRepository.createAccount(inputAccount2);
//
//        Group inputGroup1 = new Group();
//        inputGroup1.setName("new Group");
//        inputGroup1.setCreator(resultAccount1);
//        Group resultGroup1 = groupRepository.createGroup(inputGroup1);
//
//        GroupAccount groupAccount = new GroupAccount();
//        groupAccount.setAccountId(resultAccount2.getId());
//        groupAccount.setGroupId(resultGroup1.getId());
//        groupAccountRepository.createGroupAccount(groupAccount);


//        List<DepartmentDTO> departmentDTOS =  departmentRepository.getAllDepartments(1, 5, null, null);
//        for (DepartmentDTO departmentDTO : departmentDTOS) {
//            System.out.println(departmentDTO);
//        }

        System.out.println(accountRepository.getEmpAndManagerAmount());
    }
}
