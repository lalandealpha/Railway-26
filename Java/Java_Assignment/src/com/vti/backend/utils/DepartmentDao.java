package com.vti.backend.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vti.entity.jdbc.Department;

public class DepartmentDao {
	
	public List<Department> getDepartments(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM `Department`");
		List<Department> departments = new ArrayList<Department>();
		while (resultSet.next()) {
			departments.add(new Department(resultSet.getInt(1), resultSet.getString(2)));
		}
		Collections.sort(departments);
		return departments;
		
	}
	
	public Department getDeptById(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Department WHERE DepartmentId = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Department department = null;
			while (resultSet.next()) {
				department = new Department(resultSet.getInt(1), resultSet.getString(2));
			}
		return department; 
	}
	
	public boolean isDeptNameExist(Connection connection, String name) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT DepartmentName FROM Department WHERE DepartmentName = ?");
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	
	public boolean isDeptIdExist(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT DepartmentID FROM Department WHERE DepartmentID = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	
	public void createDepartment(Connection connection, String name) throws SQLException {
		if(isDeptNameExist(connection, name)) {
			System.out.println("Department exists!");
		} else {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Department (DepartmentName) VALUES (?)");
			preparedStatement.setString(1, name);
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Effected record(s) amount:" + effectedRecordAmount);
		}
	}

	public void updateDeptName(Connection connection, int id, String name) throws SQLException {
		if(!isDeptIdExist(connection, id)) {
			System.err.println("Department not found!");
		} else {
			if(isDeptNameExist(connection, name)) {
				System.err.println("The department name you want to change is the same as the current department name.");
			} else {
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Department SET DepartmentName = ? WHERE DepartmentID =?");
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, id);
				int effectedRecordAmount = preparedStatement.executeUpdate();
				System.out.println("Effected record(s) amount:" + effectedRecordAmount);
			}
		}
	}
	
	public void deleteDepartment(Connection connection, int id) throws SQLException {
		if(!isDeptIdExist(connection, id)) {
			System.err.println("Department not found!");
		} else {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Department WHERE DepartmentID =?");
			preparedStatement.setInt(1, id);
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Effected record(s) amount:" + effectedRecordAmount);
		}
	}
}
