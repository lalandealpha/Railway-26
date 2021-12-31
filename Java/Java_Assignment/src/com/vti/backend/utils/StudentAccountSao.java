package com.vti.backend.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.entity.jdbc.StudentAccount;

public class StudentAccountSao {
	private static DepartmentDao departmentDao = new DepartmentDao();

	public List<StudentAccount> getStudentAcc(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM StudentAccount");
		List<StudentAccount> studentAccounts = new ArrayList<StudentAccount>();
		while (resultSet.next()) {
			StudentAccount studentAccount = new StudentAccount(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4), resultSet.getDate(7));
			studentAccount.setDepartmentName(departmentDao.getDeptById(connection, resultSet.getInt(5)).getName());
			studentAccounts.add(studentAccount);
		}
		return studentAccounts;
	}

	public StudentAccount getStuAccById(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM StudentAccount WHERE StudentID = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		StudentAccount studentAccount = null;
		while (resultSet.next()) {
			studentAccount = new StudentAccount(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getDate(7));
			studentAccount.setDepartmentName(departmentDao.getDeptById(connection, resultSet.getInt(5)).getName());
		}
		return studentAccount;

	}

	public boolean isStuNameExist(Connection connection, String name) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT Fullname FROM StudentAccount WHERE Fullname = ?");
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	
	public boolean isStuIdExist(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT StudentID FROM StudentAccount WHERE StudentID = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	
	public void createStudentAcc(Connection connection, String email, String username, String fullname, int departmentId) throws SQLException {
		if(isStuNameExist(connection, fullname)) {
			System.out.println("Student name exists!");
		} else {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO StudentAccount (Email, Username, Fullname, DepartmentID) VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, fullname);
			preparedStatement.setInt(4, departmentId);
//			preparedStatement.setDate(5, new Date());
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Effected record(s) amount:" + effectedRecordAmount);
		}
	}

	public void updateStudentName(Connection connection, int id, String name) throws SQLException {
		if(!isStuIdExist(connection, id)) {
			System.err.println("Student not found!");
		} else {
			if(isStuNameExist(connection, name)) {
				System.err.println("The new name is the same as the current department name.");
			} else {
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE StudentAccount SET Fullname = ? WHERE StudentID =?");
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, id);
				int effectedRecordAmount = preparedStatement.executeUpdate();
				System.out.println("Effected record(s) amount:" + effectedRecordAmount);
			}
		}
	}
	
	public void deleteStudent(Connection connection, int id) throws SQLException {
		if(!isStuIdExist(connection, id)) {
			System.err.println("Student not found!");
		} else {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM StudentAccount WHERE StudentID =?");
			preparedStatement.setInt(1, id);
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Effected record(s) amount:" + effectedRecordAmount);
		}
	}
}
