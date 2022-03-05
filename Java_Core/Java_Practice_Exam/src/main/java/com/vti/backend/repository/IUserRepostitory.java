package com.vti.backend.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.User;

public interface IUserRepostitory {
	
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
	 * @return
	 * @throws SQLException
	 */
	List<User> getUserList() throws SQLException;

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
	 * @throws SQLException
	 */
	void printUserList() throws SQLException;

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
	 * @param id
	 * @return boolean
	 * @throws Exception
	 */
	boolean getUserInfo(int id) throws Exception;

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
	 * @return boolean
	 * @throws SQLException
	 */
	boolean isUserExist(int id) throws SQLException;

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
	 * @return boolean
	 * @throws SQLException
	 */
	boolean isUserExist(String email) throws SQLException;

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
	 */
	void deleteUser(int id) throws SQLException;

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
	 * @return 
	 * @throws Exception
	 */
	boolean login(String email, String password) throws Exception;

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
	boolean isAdmin(String email) throws SQLException;

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
	 * @throws Exception
	 */
	void createUser(String fullName, String email) throws Exception;
	
	/**
	 * This method is for closing connection to a database. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 13 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 13 thg 1, 2022
	 * @throws SQLException
	 */
	void closeConnection() throws SQLException;
}
