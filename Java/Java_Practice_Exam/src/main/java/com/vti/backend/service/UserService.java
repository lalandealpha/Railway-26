package com.vti.backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.repository.IUserRepostitory;
import com.vti.backend.repository.UserRepository;
import com.vti.entity.User;

/**
 * This class is user service. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 9 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 9 thg 1, 2022
 */
public class UserService implements IUserService{
	
	private IUserRepostitory userRepostitory;
	
	/**
	 * Constructor for class UserService.
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public UserService() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		userRepostitory = new UserRepository();
	}

	/* 
	* @see com.vti.backend.service.IUserService#getUserList(java.sql.Connection, java.util.Scanner)
	*/
	public List<User> getUserList(Connection connection, Scanner scanner) throws SQLException {
		return userRepostitory.getUserList(connection, scanner);
	}

	/* 
	* @see com.vti.backend.service.IUserService#printUserList(java.sql.Connection, java.util.Scanner)
	*/
	public void printUserList(Connection connection, Scanner scanner) throws SQLException {
		userRepostitory.printUserList(connection, scanner);
		
	}

	/* 
	* @see com.vti.backend.service.IUserService#getUserInfo(java.sql.Connection, java.util.Scanner, int)
	*/
	public void getUserInfo(Connection connection, Scanner scanner, int id) throws Exception {
		if(!userRepostitory.getUserInfo(connection, scanner, id)) {
			throw new Exception("User not found!");
		}
	}
	
	/* 
	* @see com.vti.backend.service.IUserService#isUserExist(java.sql.Connection, int)
	*/
	public boolean isUserExist(Connection connection, int id) throws SQLException {
		return userRepostitory.isUserExist(connection, id);
	}
	
	/* 
	* @see com.vti.backend.service.IUserService#isUserExist(java.sql.Connection, java.lang.String)
	*/
	public boolean isUserExist(Connection connection, String email) throws SQLException {
		return userRepostitory.isUserExist(connection, email);
	}
	

	/* 
	* @see com.vti.backend.service.IUserService#deleteUser(java.sql.Connection, int)
	*/
	public void deleteUser(Connection connection, int id) throws Exception {
		if (isUserExist(connection, id) == false) {
			throw new Exception("User not found!");
		} else {
			userRepostitory.deleteUser(connection, id);
		}
	}


	/* 
	* @see com.vti.backend.service.IUserService#login(java.sql.Connection, java.util.Scanner, java.lang.String, java.lang.String)
	*/
	public void login(Connection connection, Scanner scanner, String email, String password) throws Exception {
		// check if user exists or not
		if (isUserExist(connection, email) == false) {
			throw new Exception("The email you entered isn’t connected to an account.");
		} else {
			if (userRepostitory.login(connection, scanner, email, password) == false) {
				throw new Exception("The password you’ve entered is incorrect.");
			}
		}
	}


	/* 
	* @see com.vti.backend.service.IUserService#isAdmin(java.sql.Connection, java.lang.String)
	*/
	public boolean isAdmin(Connection connection, String email) throws SQLException {
		return userRepostitory.isAdmin(connection, email);
	}


	/* 
	* @see com.vti.backend.service.IUserService#createUser(java.sql.Connection, java.lang.String, java.lang.String)
	*/
	public boolean createUser(Connection connection, String fullName, String email) throws Exception {
		// check if user exists or not
		if (isUserExist(connection, email) == true) {
			 System.err.println("User exists!");
			 return false;
		} else {
			userRepostitory.createUser(connection, fullName, email);
			return true;
		}
	}
}
