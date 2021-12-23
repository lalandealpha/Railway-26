package com.vti.backend.assignment6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {
	static Scanner scanner = new Scanner(System.in);
	
	public static int inputInt(String errorMessage) {
		while(true) {
			try {
				int i = scanner.nextInt();
				return i;
			} catch (InputMismatchException e) {
				System.err.println(errorMessage);
			} finally {
				scanner.nextLine();
			}
		}

	}
	
	public static float inputFloat(String errorMessage) {
		while(true) {
			try {
				float f = scanner.nextFloat();
				return f;
			} catch (InputMismatchException e) {
				System.err.println(errorMessage);
			}finally {
				scanner.nextLine();
			}
		}
	}
	
	public static double inputDouble(String errorMessage) {
		while(true) {
			try {
				double d = scanner.nextDouble();
				return d;
			} catch (InputMismatchException e) {
				System.err.println(errorMessage);
			} finally {
				scanner.nextLine();
			}
		}
	}
	
	public static String inputString() {
		while(true) {
			String s = scanner.nextLine().trim();
			if(!s.isEmpty()) {
				return s;
			} else {
				System.err.println("Please try again!");
			}
		}
	}
}
