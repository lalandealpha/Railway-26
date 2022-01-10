package com.vti.backend.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.User;

public interface IUserService {
	
	/**
	 * This method is for getting a list of all users. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param scanner
	 * @return
	 * @throws SQLException
	 */
	List<User> getUserList(Connection connection, Scanner scanner) throws SQLException;

	/**
	 * This method is for printing out all users' information. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param scanner
	 * @throws SQLException
	 */
	void printUserList(Connection connection, Scanner scanner) throws SQLException;

	/**
	 * This method is for getting user's information. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param scanner
	 * @param id
	 * @throws Exception
	 */
	void getUserInfo(Connection connection, Scanner scanner, int id) throws Exception;

	/**
	 * This method is for checking if user exists or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean isUserExist(Connection connection, int id) throws SQLException;

	/**
	 * This method is for checking if user exists or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	boolean isUserExist(Connection connection, String email) throws SQLException;

	/**
	 * This method is for checking if user exists or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param id
	 * @throws SQLException
	 * @throws Exception 
	 */
	void deleteUser(Connection connection, int id) throws SQLException, Exception;

	/**
	 * This method is for logging in. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param scanner
	 * @param email
	 * @param password
	 * @throws Exception
	 */
	void login(Connection connection, Scanner scanner, String email, String password) throws Exception;

	/**
	 * This method is for checking if user is an Administrator or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	boolean isAdmin(Connection connection, String email) throws SQLException;

	/**
	 * This method is for creating an user. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param fullName
	 * @param email
	 * @return boolean
	 * @throws Exception
	 */
	boolean createUser(Connection connection, String fullName, String email) throws Exception;
}
