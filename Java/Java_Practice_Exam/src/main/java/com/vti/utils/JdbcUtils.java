package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class is JDBC utils. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 9 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 9 thg 1, 2022
 */
public class JdbcUtils {
	
	/**
	 * This method is for connecting to a database. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param databaseFilePath
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Connection ConnectToDb(String databaseFilePath) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(databaseFilePath));
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		Class.forName(properties.getProperty("driver"));
		return DriverManager.getConnection(url, username, password);
	}
	
	/**
	 * This method is for checking if database connected or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @return
	 */
	public boolean isDbConnected(Connection connection) {
	    try {
	        connection.prepareStatement("SELECT 1");
	        return true;
	    } catch (SQLException | NullPointerException e) {
	    	return false;
	    }
	}
	
	/**
	 * This method is for close a connection to a database. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @throws SQLException
	 */
	public void disconnect(Connection connection) throws SQLException {
		if(connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
}
