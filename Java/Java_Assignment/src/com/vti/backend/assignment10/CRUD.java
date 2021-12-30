package com.vti.backend.assignment10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.vti.backend.utils.DepartmentDao;
import com.vti.backend.utils.ScannerUtils;
import com.vti.backend.utils.StudentAccountSao;
import com.vti.entity.jdbc.Department;
import com.vti.entity.jdbc.StudentAccount;

public class CRUD {
	
	private Connection connection;
	DepartmentDao departmentDao = new DepartmentDao();
	StudentAccountSao studentAccountSao = new StudentAccountSao();
	
	public CRUD() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("/Users/user/Code/Java_Assignment_Maven/src/main/resource/database.properties"));

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		Class.forName(properties.getProperty("driver"));
		connection = DriverManager.getConnection(url, username, password);
	}
	
	public void Question1() throws SQLException  {
		System.out.println("-------Question 1-------");
		List<Department> departments = departmentDao.getDepartments(connection);
		System.out.println("Information of all departments:");
		System.out.printf("%-5s|%-10s|\n","ID","Deparment");
		for (Department d : departments) {
			System.out.printf("%-5d|%-10s|\n", d.getId(), d.getName());
		}
	}
	
	public void Question2() throws SQLException {
		System.out.println("-------Question 2-------");
		List<Department> departments = departmentDao.getDepartments(connection);
		boolean isExist = false;
		for (Department d : departments) {
			if(d.getId() == 15) {
				System.out.println("Information of department:");
				System.out.println(d.toString());
				isExist = true;
			} 
		}
		if(!isExist) {
			System.err.println("Department not found!");
		}
	}

	public void Question3() throws SQLException {
		System.out.println("-------Question 3-------");
		System.out.println("Please enter the department's id:");
		int id = ScannerUtils.inputID("ID must be an integer and greater than 0");
		if(departmentDao.getDeptById(connection, id) !=  null) {
			System.out.println("Information of department:");
			System.out.println(departmentDao.getDeptById(connection, id).toString());
		} else {
			System.err.println("Department not found!");
		}
	}
	
	public void Question4() throws SQLException {
		System.out.println("-------Question 4-------");
		System.out.println("Please enter the department's name:");
		String name = ScannerUtils.inputString();
		if(departmentDao.isDeptNameExist(connection, name)) {
			System.out.println("Department exists!");
		} else {
			System.out.println("Department not exists!");
		}
	}
	
	public void Question5() throws SQLException {
		System.out.println("-------Question 5-------");
		System.out.println("Please enter the name of the department you want to create:");
		String name = ScannerUtils.inputString();
		departmentDao.createDepartment(connection, name);
	}

	public void Question6() throws SQLException {
		System.out.println("-------Question 6-------");
		System.out.println("Please enter the id of the department id you want to change:");
		int id = ScannerUtils.inputID("ID must be an integer and greater than 0");
		System.out.println("Please enter the new name:");
		String name = ScannerUtils.inputString();
		departmentDao.updateDeptName(connection, id, name);
	}

	public void Question7() throws SQLException {
		System.out.println("-------Question 7-------");
		System.out.println("Please enter the id of the department you want to delete:");
		int id = ScannerUtils.inputID("ID must be an integer and greater than 0.");
		departmentDao.deleteDepartment(connection, id);
	}

	public void Question81() {
		System.out.println("-------Question 8.1-------");
		System.out.println("Show all the student account.");
		List<StudentAccount> studentAccounts = studentAccountSao.getStudentAcc(connection);
		System.out.println("Information of all students:");
		System.out.printf("%-5s|%-10s|\n", "ID", "Email", "Username", "Fullname", "Deparment", "Created at"));
		for (Department d : departments) {
			System.out.printf("%-5d|%-10s|\n", d.getId(), d.getName());
		}
	}
}
