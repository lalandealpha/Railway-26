package com.vti.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

/**
 * This class is User repository.
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 9 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 9 thg 1, 2022
 */
public class UserRepository implements IUserRepostitory {
	private Connection connection;
	private JdbcUtils jdbcUtils;

	public UserRepository() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		jdbcUtils = new JdbcUtils();
		connection = jdbcUtils.connectToDb("/Users/user/Code/Java_Practice_Exam/src/main/source/database.properties");
	}

	/*
	 * @see
	 * com.vti.backend.repository.IUserRepostitory#getUserList(java.sql.Connection,
	 * java.util.Scanner)
	 */
	public List<User> getUserList() throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet1 = statement.executeQuery("SELECT * FROM `Admin`");
		List<User> users = new ArrayList<>();
		// get all admins
		while (resultSet1.next()) {
			User user = new Admin(resultSet1.getInt("Id"), resultSet1.getString("Fullname"),
					resultSet1.getString("Email"), resultSet1.getString("Password"), resultSet1.getInt("ExpInYear"));
			users.add(user);
		}
		// get all employees
		ResultSet resultSet2 = statement.executeQuery("SELECT * FROM `Employee`");
		while (resultSet2.next()) {
			User user = new Employee(resultSet2.getInt("Id"), resultSet2.getString("Fullname"),
					resultSet2.getString("Email"), resultSet2.getString("Password"), resultSet2.getString("ProSkill"));
			users.add(user);
		}
		return users;
	}

	/*
	 * @see com.vti.backend.repository.IUserRepostitory#printUserList(java.sql.
	 * Connection, java.util.Scanner)
	 */
	public void printUserList() throws SQLException {
		List<User> users = getUserList();
		System.out.println("Information of all users:");
		System.out.println("+---+--------------------+------------------------------+----------+");
		System.out.printf("|%-3s|%-20s|%-30s|%-10s|\n", "ID", "Fullname", "Email", "Position");
		System.out.println("+---+--------------------+------------------------------+----------+");
		for (User u : users) {
			System.out.printf("|%-3s|%-20s|%-30s|%-10s|\n", u.getId(), u.getFullName(), u.getEmail(),
					(u instanceof Admin ? "Admin" : "Employee"));
			System.out.println("+---+--------------------+------------------------------+----------+");
		}
	}

	/*
	 * @see
	 * com.vti.backend.repository.IUserRepostitory#getUserInfo(java.sql.Connection,
	 * java.util.Scanner, int)
	 */
	public boolean getUserInfo(int id) throws Exception {
		List<User> users = getUserList();
		System.out.println("Information of the user:");
		for (User u : users) {
			if (u.getId() == id) {
				System.out.println(u.toString(u));
				return true;
			}
		}
		return false;
	}

	/*
	 * @see
	 * com.vti.backend.repository.IUserRepostitory#isUserExist(java.sql.Connection,
	 * int)
	 */
	public boolean isUserExist(int id) throws SQLException {
		// get admin
		PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM `Admin` WHERE Id = ?");
		preparedStatement1.setInt(1, id);
		ResultSet resultSet1 = preparedStatement1.executeQuery();

		// get employee
		PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM `Employee` WHERE Id = ?");
		preparedStatement2.setInt(1, id);
		ResultSet resultSet2 = preparedStatement2.executeQuery();

		if (resultSet1.next() || resultSet2.next()) {
			return true;
		}
		return false;
	}

	/*
	 * @see
	 * com.vti.backend.repository.IUserRepostitory#isUserExist(java.sql.Connection,
	 * java.lang.String)
	 */
	public boolean isUserExist(String email) throws SQLException {
		// get admin
		PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM `Admin` WHERE Email = ?");
		preparedStatement1.setString(1, email);
		ResultSet resultSet1 = preparedStatement1.executeQuery();

		// get employee
		PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM `Employee` WHERE Email = ?");
		preparedStatement2.setString(1, email);
		ResultSet resultSet2 = preparedStatement2.executeQuery();

		if (resultSet1.next() || resultSet2.next()) {
			return true;
		}
		return false;
	}

	/*
	 * @see
	 * com.vti.backend.repository.IUserRepostitory#deleteUser(java.sql.Connection,
	 * int)
	 */
	public void deleteUser(int id) throws SQLException {
		PreparedStatement preparedStatement1 = connection.prepareStatement("DELETE FROM `Admin` WHERE Id = ?");
		preparedStatement1.setInt(1, id);
		int AffectedRecordAmount = preparedStatement1.executeUpdate();

		PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM `Employee` WHERE Id = ?");
		preparedStatement2.setInt(1, id);

		System.out.println("User deleted!");
		AffectedRecordAmount += preparedStatement2.executeUpdate();
		System.out.println("Affected Record Amount: " + AffectedRecordAmount);
	}

	/*
	 * @see com.vti.backend.repository.IUserRepostitory#login(java.sql.Connection,
	 * java.util.Scanner, java.lang.String, java.lang.String)
	 */
	public boolean login(String email, String password) throws Exception {
		List<User> users = getUserList();
		for (User u : users) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				System.out.println("Logged in!");
				return true;
			}
		}
		return false;
	}

	/*
	 * @see com.vti.backend.repository.IUserRepostitory#isAdmin(java.sql.Connection,
	 * java.lang.String)
	 */
	public boolean isAdmin(String email) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Admin` WHERE Email = ?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	/*
	 * @see
	 * com.vti.backend.repository.IUserRepostitory#createUser(java.sql.Connection,
	 * java.lang.String, java.lang.String)
	 */
	public void createUser(String fullName, String email) throws Exception {
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO `Employee` (Email, Fullname, `Password`) VALUES (?, ?, ?)");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, fullName);
		preparedStatement.setString(3, "123456");
		System.out.println("Created successfully!");
		int AffectedRecordAmount = preparedStatement.executeUpdate();
		System.out.println("Affected record(s) amount:" + AffectedRecordAmount);
	}

	/* 
	* @see com.vti.backend.repository.IUserRepostitory#closeConnection()
	*/
	public void closeConnection() throws SQLException {
		if (jdbcUtils.isDbConnected(connection)) {
			connection.close();
		}
	}
}
