package com.vti.backend.utils;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {
	static Scanner scanner = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
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
	
	public static int inputInt(String errorMessage, int lowerLimit, int upperLimit) {
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

	public static int inputID(String errorMessage1) {
		while (true) {
			int result = inputInt("ID must be an integer and greater than 0. Please try again!");
			if (result > 0) {
				return result;
			} else {
				System.err.println(errorMessage1);
			}

		}
	}

	public static float inputFloat(String errorMessage) {
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

	public static double inputDouble(String errorMessage) {
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

	public static String inputString() {
		while (true) {
			String s = scanner.nextLine().trim();
			if (!s.isEmpty()) {
				return s;
			} else {
				System.err.println("Please try again!");
			}
		}
	}

	public static LocalDate inputDate(String errorMessage) {
		while (true) {
			try {
				return LocalDate.parse(scanner.nextLine());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
}
