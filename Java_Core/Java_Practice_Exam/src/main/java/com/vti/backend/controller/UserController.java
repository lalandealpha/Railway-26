package com.vti.backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.service.IUserService;
import com.vti.backend.service.UserService;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;
import com.vti.utils.RegexUtils;
import com.vti.utils.ScannerUtils;

/**
 * This class is user controller. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 9 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 9 thg 1, 2022
 */
public class UserController  {
	private IUserService userService;
	private ScannerUtils scannerUtils;
	
	/**
	 * Constructor for class UserController.
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
	public UserController() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		userService = new UserService();
		scannerUtils = new ScannerUtils();
	}

	/**
	 * This method is for getting list of all users. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @param scanner
	 * @return List
	 * @throws SQLException
	 */
	public List<User> getUserList() throws SQLException {
		return userService.getUserList();
	}

	/**
	 * This method is for printing out all users' information. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @param scanner
	 * @throws SQLException
	 */
	public void printUserList() throws SQLException {
		userService.printUserList();
	}

	/**
	 * This method is for getting user's information. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @param scanner
	 */
	public void getUserInfo() {
		System.out.println("Please enter the id of the User:");
		// validate id input
		int id = scannerUtils.inputID("ID must be an integer and greater than 0. Please try again");
		try {
			userService.getUserInfo(id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}


	/**
	 * This method is for checking if user exists or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean isUserExist(int id) throws SQLException {
		return userService.isUserExist(id);
	}
	
	/**
	 * This method is for checking if user exists or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean isUserExist(String email) throws SQLException {
		return userService.isUserExist(email);
	}


	/**
	 * This method is for deleting an user. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @throws Exception 
	 */
	public void deleteUser() {
		System.out.println("Please enter the id of the User:");
		// validate id input
		int id = scannerUtils.inputID("ID must be an integer and greater than 0. Please try again");
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	

	/**
	 * This method is for logging in. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @param scanner
	 */
	public void login() {
		while(true) {
			System.out.println("Please enter your email:");
			String email = scannerUtils.inputString();
			// validate email input
			if(RegexUtils.isEmail(email)) {
				boolean isCorrect = false;
				while(!isCorrect) {
					System.out.println("Please enter your password:");
					String password = scannerUtils.inputString();
					// validate password input
					if(RegexUtils.isPassword(password)) {
						try {
							userService.login(email, password);
							return;
						} catch (Exception e) {
							System.err.println(e.getMessage());
							isCorrect = true;
						}
					} else {
						System.err.println("Invalid password. Password must have 6-12 characters and at least one upper case character. Please try again!");
					}
				}
			} else {
				System.err.println("Invalid email (abc@domain.xxx.yyy). Please try again!");
			}
		}
	}


	/**
	 * This method is for checking if user is an Administrator or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public boolean isAdmin(String email) throws SQLException {
		return userService.isAdmin(email);
	}


	/**
	 * This method is for creating an user. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param connection
	 * @param fullName
	 */
	public void createUser() {
		while(true) {
			System.out.println("Please enter your email:");
			String email = scannerUtils.inputString();
			// validate email input
			if(RegexUtils.isEmail(email)) {
				try {
					// check if the user is an administrator or not
					if(!isAdmin(email)) {
						System.err.println("The email you entered isn’t connected to an administrator account.");
					} else {
						boolean isCorrect = false;
						while(!isCorrect) {
							System.out.println("Please enter your password:");
							String password = scannerUtils.inputString();
							// validate password input
							if(RegexUtils.isPassword(password)) {
								try {
									userService.login(email, password);
									validateUserInfo();
									isCorrect = true;
									return;
								} catch (Exception e) {
									System.err.println(e.getMessage());
									isCorrect = true;
								}
							} else {
								System.err.println("Invalid password. Password must have 6-12 characters and at least one upper case character. Please try again!");
							}
						}
					}
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			} else {
				System.err.println("Invalid email (abc@domain.xxx.yyy). Please try again!");
			}
		}

	}

	/**
	 * This method is for validating user's information while creating. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param connection
	 * @param scanner
	 * @throws Exception
	 */
	private void validateUserInfo() throws Exception {
		while(true) {
			System.out.println("Please enter the name of the user:");
			String fullName = scannerUtils.inputString();
			// validate full name input
			if(RegexUtils.isFullname(fullName)) {
				boolean isCreated = false;
				while(!isCreated) {
					System.out.println("Please enter the email of the user:");
					String email1 = scannerUtils.inputString();
					// validate email input
					if(RegexUtils.isEmail(email1)) {
						if(userService.createUser(fullName, email1)) {
							isCreated = true;
							return;
						}
					}else {
						System.err.println("Invalid email (abc@domain.xxx.yyy). Please try again!");
					}
				}
			} else {
				System.err.println("Invalid Fullname. Fullname must not contain numbers or special characters. Please try again!");
			}
		}
	}
	
	public void closeConnection() throws SQLException {
		userService.closeConnection();
	}
}
