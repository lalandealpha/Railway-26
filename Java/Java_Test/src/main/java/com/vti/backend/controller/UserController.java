//
package com.vti.backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.service.IUserService;
import com.vti.backend.service.UserService;
import com.vti.entity.User;
import com.vti.utils.RegexUtils;
import com.vti.utils.ScannerUtils;

/**
 * This class is UserController. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 14 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 14 thg 1, 2022
 */
public class UserController {
	IUserService service;
	ScannerUtils scannerUtils;
	
	/**
	 * Constructor for class UserController.
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public UserController() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		service = new UserService();
		scannerUtils = new ScannerUtils();
	}

	/**
	 * This method is for getting a list of all Users. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @return
	 * @throws SQLException
	 */
	public List<User> getUserList() throws SQLException {
		return service.getUserList();
	}

	/**
	 * This method is for getting an User's information. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public void getUserInfor() throws SQLException {
		System.out.println("Please enter the id of the User:");
		// validate id input
		int id = scannerUtils.inputID("ID must be an integer and greater than 0. Please try again");
		try {
			if(service.getUserInfor(id) ==  null) {
				System.err.println("User not found!");
			} else {
				System.out.println(service.getUserInfor(id).toString());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	/**
	 * This method is for deleting an User's account. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public void deleteUser() throws SQLException {
		System.out.println("Please enter the id of the User:");
		// validate id input
		int id = scannerUtils.inputID("ID must be an integer and greater than 0. Please try again");
		try {
			int affectedRecordAmount = service.deleteUser(id);
			System.out.println("User deleted!");
			System.out.println("Affected record(s) amount: " + affectedRecordAmount);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This method is for loggin in. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @param email
	 * @param password
	 * @throws Exception 
	 */
	public void login() throws Exception {
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
							service.login(email, password);
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
	 * This method is for creating an User account. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 14 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 14 thg 1, 2022
	 * @param email
	 * @param fullname
	 * @return
	 * @throws Exception 
	 */
	public void createUser() throws Exception {
		while(true) {
			System.out.println("Please enter your email:");
			String email = scannerUtils.inputString();
			// validate email input
			if(RegexUtils.isEmail(email)) {
				// check if the user is an administrator or not
				boolean isCorrect = false;
				while(!isCorrect) {
					System.out.println("Please enter your password:");
					String password = scannerUtils.inputString();
					// validate password input
					if(RegexUtils.isPassword(password)) {
						try {
							if(!service.loginForAdmin(email, password)) {
								throw new Exception("The email or password you’ve entered not connected to any Administrator account.");
							} else {
								validateUserInfo();
								isCorrect = true;
								return;
							}
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
					String email = scannerUtils.inputString();
					// validate email input
					if(RegexUtils.isEmail(email)) {
						int affectedRecordAmount = service.createUser(email, fullName);
						System.out.println("User account created!");
						System.out.println("Affected record(s) amount: " + affectedRecordAmount);
						isCreated = true;
						return;
					}else {
						throw new Exception("Invalid email (abc@domain.xxx.yyy). Please try again!");
					}
				}
			} else {
				throw new Exception("Invalid Fullname. Fullname must not contain numbers or special characters. Please try again!");
			}
		}
	}

}
