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
import com.vti.entity.jdbc.Department;

public class CRUD {
	
	private Connection connection;
	DepartmentDao departmentDao = new DepartmentDao();
	
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
}
