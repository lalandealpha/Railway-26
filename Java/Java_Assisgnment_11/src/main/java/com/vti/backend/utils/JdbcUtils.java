package com.vti.backend.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	
	public static Connection ConnectToDb(String databaseFilePath) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(databaseFilePath));
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		Class.forName(properties.getProperty("driver"));
		return DriverManager.getConnection(url, username, password);
	}
	
	public static boolean isDbConnected(Connection connection) {
	    try {
	        connection.prepareStatement("SELECT 1");
	        return true;
	    } catch (SQLException | NullPointerException e) {
	    	return false;
	    }
	}
}
