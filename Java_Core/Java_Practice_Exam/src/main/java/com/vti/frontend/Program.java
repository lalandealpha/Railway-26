package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.controller.UserController;
import com.vti.backend.repository.UserRepository;
import com.vti.backend.service.IUserService;
import com.vti.backend.service.UserService;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

/**
 * This class is for demo program. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 9 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 9 thg 1, 2022
 */
public class Program {
	private static UserController controller;
	private static ScannerUtils scannerUtils;
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		controller = new UserController();
		scannerUtils = new ScannerUtils();
		
		while(true) {
			System.out.println("Please select the function you want to use:");
			System.out.println("(1) Get a list of all Users");
			System.out.println("(2) Get an User's information");
			System.out.println("(3) Delete an User");
			System.out.println("(4) Log in");
			System.out.println("(5) Create User (Only for administrators)");
			System.out.println("(6) Exit");
			int select = scannerUtils.inputInt("Please try again!", 1, 6);
			switch (select) {
				case 1:
					controller.printUserList();
					break;
				case 2:
					controller.getUserInfo();
					break;
				case 3:
					controller.deleteUser();
					break;
				case 4:
					controller.login();
					break;
				case 5:
					controller.createUser();
					break;
				default:
					System.out.println("Exiting the program...");
					scannerUtils.disconnect();
					controller.closeConnection();
					System.gc();
					return;
			}
			System.out.println("");
		}
	}
}
