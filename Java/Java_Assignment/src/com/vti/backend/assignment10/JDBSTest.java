package com.vti.backend.assignment10;

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

public class JDBSTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("/Users/user/Code/Java_Assignment_Maven/src/main/resource/database.properties"));
		
		String url = properties.getProperty("urltest");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		// register the driver class with DriverManager
		Class.forName(properties.getProperty("driver"));

		// Step 2: get a Database Connection
		Connection connection = DriverManager.getConnection(url, username, password);
		
		System.out.println("Connected successfully!");
		
//		// Step 3: Create a statement object
		String sql = "SELECT id, username, email FROM `User`";
		Statement statement = connection.createStatement();
		
		// Step 4: Execute query
		ResultSet resutlSet = statement.executeQuery(sql);
//		
//		// Step 5: Handling result set
		while(resutlSet.next()) {
			System.out.println(resutlSet.getInt("id"));
			System.out.println(resutlSet.getString("username"));
			System.out.println(resutlSet.getString("email"));
		}
		
//		// Test insert record
//		
//		int effectedRecordAmount = statement.executeUpdate("INSERT INTO `Group` (`name`, author_ID)  VALUES ('Java Senior', 4)");
//		System.out.println("Effected record amount: " + effectedRecordAmount);
//		
//		// Test insert with parameters
//		
//		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `Group` (`name`, author_ID)  VALUES (?, ?)");
//		System.out.println("Please enter the group's name: ");
//		String groupName = ScannerUtils.inputString();
//		System.out.println("Please enter the author's id: ");
//		int authorId = ScannerUtils.inputID("ID must be an integer and greater than 0. Please try again!");
//		preparedStatement.setString(1, groupName);
//		preparedStatement.setInt(2, authorId);
//		int effectedRecordAmount = preparedStatement.executeUpdate();
//		System.out.println("Effected record amount: " + effectedRecordAmount);
//		
//		PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE `Group` SET `name` = ? WHERE id = ?");
//		System.out.println("Please enter the id of the group you want to rename:");
//		int groupId = ScannerUtils.inputID("ID must be an integer and greater than 0. Please try again!");
//		System.out.println("Please enter the new name of the group:");
//		String groupNewName = ScannerUtils.inputString();
//		preparedStatement2.setInt(2, groupId);
//		preparedStatement2.setString(1, groupNewName);
//		int effectedRecordAmount = preparedStatement2.executeUpdate();
//		System.out.println("Effected record amount: " + effectedRecordAmount);
		
		// Step 6: Close connection
		connection.close();
		
	}

} 
