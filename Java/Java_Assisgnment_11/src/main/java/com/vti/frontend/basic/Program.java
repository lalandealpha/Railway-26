package com.vti.frontend.basic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.datalayer.StudentRepository;
import com.vti.backend.presentationlayer.StudentController;
import com.vti.entity.basic.Student;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

public class Program {
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		JdbcUtils jdbcUtils = new JdbcUtils();
		ScannerUtils scannerUtils = new ScannerUtils();
		StudentController studentController = new StudentController();
		Connection connection = jdbcUtils.ConnectToDb("/Users/user/Code/Java_Assisgnment_11/src/main/resource/database.properties");
		
		List<Student> students = studentController.getStudentList(connection);
		System.out.println("Information of all students:");
		System.out.println("+---+--------------------+----------+--------------------+----------+----------+---------------+");
		System.out.printf("|%-3s|%-20s|%-10s|%-20s|%-10s|%-10s|%-15s|\n", "ID", "Email", "Username", "Fullname", "Deparment", "Position", "Created at");
		System.out.println("+---+--------------------+----------+--------------------+----------+----------+---------------+");
		for (Student s : students) {
			System.out.printf("|%-3s|%-20s|%-10s|%-20s|%-10s|%-10s|%02d/%02d/%-9d|\n", s.getId(), s.getEmail(), s.getUserName(), s.getFullName(), s.getDepartment().getName(), s.getPositon(), s.getCreateDate().getDate(), s.getCreateDate().getMonth() + 1, s.getCreateDate().getYear() + 1900);
			System.out.println("+---+--------------------+----------+--------------------+----------+----------+---------------+");
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the email of the student:");
		String email = scannerUtils.inputString(scanner);
		System.out.println("Please choose an username of the student:");
		String username = scannerUtils.inputString(scanner);
		System.out.println("Please enter the name of the student:");
		String fullName = scannerUtils.inputString(scanner);
		System.out.println("Please enter the department of the student:");
		String department = scannerUtils.inputString(scanner);
		System.out.println("Please enter the position of the student:");
		String position = scannerUtils.inputString(scanner);
		
		try {
			studentController.createStudentAcc(connection, email, username, fullName, department, position);
			System.out.println("Created successfully!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Create failure!");
		}
		scanner.close();
		jdbcUtils.disconnect(connection);
	}
}
