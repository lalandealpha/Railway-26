package com.vti.backend.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.jdbc.StudentAccount;

public class StudentAccountSao {
	public List<StudentAccount> getStudentAcc(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM StudentAccount");
		List<StudentAccount> studentAccounts = new ArrayList<StudentAccount>();
		DepartmentDao departmentDao = new DepartmentDao();
		while(resultSet.next()) {
			StudentAccount studentAccount = new StudentAccount(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(7));
			studentAccount.setDepartmentId(departmentDao.getDeptById(connection, resultSet.getInt(5)).getName());
			studentAccounts.add(studentAccount);
		}
		return studentAccounts;
	}
	
	public StudentAccount getStuAccById(Connection connection, int id) {
		
		
	}
}
