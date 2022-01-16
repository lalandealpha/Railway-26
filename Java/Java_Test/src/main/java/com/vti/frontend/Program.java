//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.controller.UserController;
import com.vti.entity.Admin;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

/**
 * This class is Program. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 15 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 15 thg 1, 2022
 */
public class Program {
	private static UserController controller;
	private static ScannerUtils scannerUtils;
	/**
	 * This method is for Program demo. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 15 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 15 thg 1, 2022
	 * @param args
	 * @throws Exception 
	 */

	
	public static void main(String[] args) throws Exception {
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
					List<User> users = controller.getUserList();
					System.out.println("Information of all users:");
					System.out.println("+---+--------------------+------------------------------+----------+");
					System.out.printf("|%-3s|%-20s|%-30s|%-10s|\n", "ID", "Fullname", "Email", "Position");
					System.out.println("+---+--------------------+------------------------------+----------+");
					for (User u : users) {
						System.out.printf("|%-3s|%-20s|%-30s|%-10s|\n", u.getId(), u.getFullName(), u.getEmail(),
								(u instanceof Admin ? "Admin" : "Employee"));
						System.out.println("+---+--------------------+------------------------------+----------+");
					}
					break;
				case 2:
					controller.getUserInfor();
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
					System.gc();
					return;
			}
			System.out.println("");
		}
	}

}
