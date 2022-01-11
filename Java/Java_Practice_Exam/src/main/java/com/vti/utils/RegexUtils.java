package com.vti.utils;

public class RegexUtils {
	// Email pattern: abc@domain.xxx or abc@domain.xxx.yyy
	private static final String emailPattern = "^[a-zA-Z0-9-._]+@([a-z]+\\.[a-z]+|[a-z]+\\.[a-z]{2,}\\.[a-z]{2,})$";
	
	/*Password:
	 * 6-12 characters (that aren't new lines)
	 * having at least one upper case character.
	 */
	private static final String passwordPattern = "^(?=.[a-zA-Z0-9]).{6,12}$";
	
	// Full name: not contains numbers or special characters
	private static final String fullNamePattern = "^[a-zA-Z\\s]+";
	
	/**
	 * This method is for checking email matches pattern or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param email
	 * @return boolean
	 */
	public static boolean isEmail(String email) {
		return email.matches(emailPattern);
	}
	
	/**
	 * This method is for checking password matches pattern or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param password
	 * @return boolean
	 */
	public static boolean isPassword(String password) {
		return password.matches(passwordPattern);
	}
	
	/**
	 * This method is for checking fullname matches pattern or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 10 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 10 thg 1, 2022
	 * @param fullName
	 * @return boolean
	 */
	public static boolean isFullname(String fullName) {
		return fullName.matches(fullNamePattern);
	}
	
	
}
