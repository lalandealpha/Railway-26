package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.vti.backend.utils.ScannerUtils;

public class Basic {

	public static Connection connection;

	public Basic() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Properties properties = new Properties();
		properties.load(
				new FileInputStream("/Users/user/Code/Java_Assignment_10_Maven/src/main/resource/database.properties"));

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		Class.forName(properties.getProperty("driver"));
		connection = DriverManager.getConnection(url, username, password);
	}

	public void Question1() throws IOException, ClassNotFoundException, SQLException {
		System.out.println("-------Question 1-------");
		System.out.println("Connected successfully!");

	}

	public void Question2() throws IOException, ClassNotFoundException, SQLException {
		System.out.println("-------Question 2-------");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM `Position`");
		System.out.println("Information of positions:");
		System.out.printf("%-5s|%-10s|\n","ID","Position");
		while (resultSet.next()) {
	        System.out.printf("%-5d|%-10s|\n", resultSet.getInt(1), resultSet.getString(2));
		}
	}

	public void Question3() throws SQLException {
		System.out.println("-------Question 3-------");
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `Position` (PositionName) VALUES (?)");
		System.out.println("Please enter the position's name:");
		String positionName = ScannerUtils.inputString();
		preparedStatement.setString(1, positionName);
		int effectedRecordAmount = preparedStatement.executeUpdate();
		System.out.println("Effected record(s) amount: " + effectedRecordAmount);
	}
	
	public void Question4() throws SQLException {
		System.out.println("-------Question 4-------");
		Statement statement = connection.createStatement();
		int effectedRecordAmount = statement.executeUpdate("UPDATE `Position` SET PositionName = 'Vice Monitor' WHERE PositionID = 4");
		System.out.println("Effected record(s) amount: " + effectedRecordAmount);
	}

	public void Question5() throws SQLException {
		System.out.println("-------Question 5-------");
		System.out.println("Please enter the position's ID:");
		int positionId = ScannerUtils.inputID("ID must be an integer and greater than 0");
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT PositionID FROM Position WHERE PositionID = ?");
		preparedStatement.setInt(1, positionId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next() == false) {
			System.err.println("Position not found");
		} else {
			PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM `Position` WHERE PositionID = ?");
			preparedStatement2.setInt(1, positionId);
			int effectedRecordAmount = preparedStatement2.executeUpdate();
			System.out.println("Effected record(s) amount: " + effectedRecordAmount);
		}
	}
}
