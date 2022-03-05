package com.vti.utils;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is Scanner utils. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 9 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 9 thg 1, 2022
 */
public class ScannerUtils {
	
	private static Scanner scanner = new Scanner(System.in);
	/**
	 * This method is for inputting an integer. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public int inputInt(String errorMessage) {
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.err.println(errorMessage);
			} finally {
				scanner.nextLine();
			}
		}
	}
	
	/**
	 * This method is for inputting an integer with lower and upper limit. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param scanner
	 * @param errorMessage
	 * @param lowerLimit
	 * @param upperLimit
	 * @return
	 */
	public int inputInt(String errorMessage, int lowerLimit, int upperLimit) {
		while (true) {
			try {
				int i = scanner.nextInt();
				if(i >= lowerLimit && i <= upperLimit) {
					return i;
				} else {
					System.err.println(errorMessage);
				}
			} catch (InputMismatchException e) {
				System.err.println(errorMessage);
			} finally {
				scanner.nextLine();
			}
		}
	}

	/**
	 * This method is for inputting an integer as an id. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param scanner
	 * @param errorMessage1
	 * @return
	 */
	public int inputID(String errorMessage1) {
		while (true) {
			int result = inputInt("ID must be an integer and greater than 0. Please try again!");
			if (result > 0) {
				return result;
			} else {
				System.err.println(errorMessage1);
			}
		}
	}

	/**
	 * This method is for inputting a float number. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public float inputFloat(String errorMessage) {
		while (true) {
			try {
				return scanner.nextFloat();
			} catch (InputMismatchException e) {
				System.err.println(errorMessage);
			} finally {
				scanner.nextLine();
			}
		}
	}

	/**
	 * This method is for inputting a double number. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public double inputDouble(String errorMessage) {
		while (true) {
			try {
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.err.println(errorMessage);
			} finally {
				scanner.nextLine();
			}
		}
	}

	/**
	 * This method is for inputting a string. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param scanner
	 * @return
	 */
	public String inputString() {
		while (true) {
			String s = scanner.nextLine().trim();
			if (!s.isEmpty()) {
				return s;
			} else {
				System.err.println("Please try again!");
			}
		}
	}

	/**
	 * This method is for inputting date. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public LocalDate inputDate(String errorMessage) {
		while (true) {
			try {
				return LocalDate.parse(scanner.nextLine());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	public void disconnect() {
		scanner.close();
	}
}
