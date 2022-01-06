package com.vti.backend.utils;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {

	public static int inputInt(Scanner scanner, String errorMessage) {
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
	
	public static int inputInt(Scanner scanner, String errorMessage, int lowerLimit, int upperLimit) {
		while (true) {
			try {
				int i = scanner.nextInt();
				if(i > lowerLimit && i < upperLimit) {
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

	public static int inputID(Scanner scanner, String errorMessage1) {
		while (true) {
			int result = inputInt(scanner, "ID must be an integer and greater than 0. Please try again!");
			if (result > 0) {
				return result;
			} else {
				System.err.println(errorMessage1);
			}
		}
	}

	public static float inputFloat(Scanner scanner, String errorMessage) {
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

	public static double inputDouble(Scanner scanner, String errorMessage) {
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

	public static String inputString(Scanner scanner) {
		while (true) {
			String s = scanner.nextLine().trim();
			if (!s.isEmpty()) {
				return s;
			} else {
				System.err.println("Please try again!");
			}
		}
	}

	public static LocalDate inputDate(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				return LocalDate.parse(scanner.nextLine());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
}
