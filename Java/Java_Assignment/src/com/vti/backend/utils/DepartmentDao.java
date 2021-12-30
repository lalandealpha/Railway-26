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
}
