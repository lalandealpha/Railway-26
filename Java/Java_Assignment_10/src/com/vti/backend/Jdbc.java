package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.vti.backend.utils.JdbcUtils;

public class Jdbc {
	public void Question1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("-------Question 1-------");
		JdbcUtils.ConnectToDb("/Users/user/Code/Java_Assignment_Maven/src/main/resource/database.properties", "url", "username", "password");
		System.out.println("Connected successfully!");
	}
	
	public void Question2() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("-------Question 2-------");
		Connection connection = JdbcUtils.ConnectToDb("/Users/user/Code/Java_Assignment_Maven/src/main/resource/database.properties", "url", "username", "password");
		if(JdbcUtils.isDbConnected(connection)) {
			System.out.println("Connected!");
		} else {
			System.out.println("Not connected");
		}
	}
}
