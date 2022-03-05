package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.CallableStatement;
import com.vti.backend.utils.DepartmentDao;
import com.vti.backend.utils.ScannerUtils;

public class ProcedureTest {
	Connection connection;
	
	public ProcedureTest() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("/Users/user/Code/Java_Assignment_10_Maven/src/main/resource/database.properties"));

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		Class.forName(properties.getProperty("driver"));
		connection = DriverManager.getConnection(url, username, password);
		
	}
	
	public void Demo() throws ClassNotFoundException, IOException, SQLException {	
		CallableStatement callableStatement = (CallableStatement) connection.prepareCall("{CALL sp_update_student_account(?, ?)}");
		callableStatement.setString(1, "Luan Nguyen");
		callableStatement.setInt(2, 3);
		int affectedRecordAmount = callableStatement.executeUpdate();
		System.out.println("Affected record amount: " + affectedRecordAmount);
	}
	
	public void Question1() throws Exception {
		System.out.println("Please enter the id of the department you want to delete.");
		int id = ScannerUtils.inputID("Please try again!");
		deleteDepartment(id);
	}
	
	private void deleteDepartment(int id) throws Exception {
		DepartmentDao departmentMethod = new DepartmentDao();
		if(!departmentMethod.isDeptIdExist(connection, id)) {
			throw new Exception("Department not found!");
		} else {
			CallableStatement callableStatement = (CallableStatement) connection.prepareCall("{CALL sp_delete_department(?)}");
			callableStatement.setInt(1, id);
			int affectedRecordAmount = callableStatement.executeUpdate();
			System.out.println("Affected record amount: " + affectedRecordAmount);
		}
	}
}
