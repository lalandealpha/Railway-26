package com.vti.backend.assignment3;


import java.util.Scanner;

import com.vti.entity.objectInitialization.Student;


public class test {
	public static void main(String[] args) {
//// Data type Casting
//		short a = 1000;
//		byte b = (byte) a;
//		System.out.println(b);
//		
//		int ac = 1;
//		int bc = 2;
//		
//		float c = ac / (float) bc; // or float c = (float) ac / bc
//		System.out.printf("%5.2f", c);
//		System.out.println("");
//		
//// primitive vs wrapper class
//		Integer i = 1000; //  kieu wrapper class
//		byte h = i.byteValue();
//		System.out.println(h);
//		System.out.println(i.MAX_VALUE);
//		
//		String ten = "Nam";  // khai bao kieu primitive
//		
//		String ho = new String ("Nguyen"); // khai bao kieu wrapper class
//		 // con tro            // object
//		
//		// primitive luu trong bo nho stack
//		// object, wrapper class luu trong bo nho heap
//		
//		System.out.println(ten.hashCode());
//
//// con tro va object
//		Student[] students = new Student[10];
//		for (int j = 0; j < students.length; j++) {
//			students[j] = new Student();
//			students[j].id = j;
//			students[j].fullName = "abc" + 1;
//		}
//		
//		for (Student s: students) {
//			System.out.println(s.id);
//			System.out.println(s.fullName);
//		}
//		
//// boxing vs unboxing
//		// boxing: primitive -> wrapper class;
//		int p = 5;
//		Integer p1 = new Integer(p);
// 		
//		// unboxing: wrapper class -> primitive;
//		Integer p2 = 5;
//		int p3 = p2.intValue();
//
//// Comparison: de so sanh 2 phan tu, may tinh so sanh 2 dia chi cua chung trong o nho
//		// doi voi bien primitive, may tinh se so sanh hasCode cua 2 phan tu (1 hasCode co 1 o nho duy nhat)
//		
//		
//		// dung == de so sanh primitive
//		if (p ==5 ) {
//			System.out.println("p = 5");
//		}
//		// dung ham equals de so sanh gia tri 2 String
//		String g  = "Namd";
//		String k = "Nam";
//		k += "d";
//		System.out.println(g.equals(k));
//		
//		// override ham equals trong class cua object de so sanh object
//		// doi voi  cac object va String, may tinh se so sanh dia chi o nho (nhieu object co the co chung 1 hasCode
//		// nhung o nho khac nhau) -> can dinh nghia lai ham equals trong class
//		
//		
////Override
//		// Cac ham co san trong class thi phai override
//		// Override equals (von la so sanh hasCode)
//		// Override toString (von la in ra hasCode)
//
//
//		
//			
//		
////		// Question 4: 
////		Scanner scanner = new Scanner(System.in);
////		System.out.println("Please enter the 1st integer: ");	
////		while (true) {
////			String s1 = scanner.next();
////			if (scanner.hasNextInt()) {
////				System.out.println("Please enter the 2nd integer: ");
////				String s2 = scanner.next();
////				int i1 = Integer.parseInt(s1);
////				int i2 = Integer.parseInt(s2);
////				System.out.println("The quotient of the two numbers just entered is: " + (float) i1 / i2);
////				break;
//////				while (true) {
//////					String s2 = scanner.next();
//////					if (scanner.hasNextInt()) {
//////						int i1 = Integer.parseInt(s1);
//////						int i2 = Integer.parseInt(s2);
//////						System.out.println("The quotient of the two numbers just entered is: " + (float) i1 / i2);
//////						break;
//////					} else {
//////						System.out.println("You did not enter a integer. Please try again!");
//////					}
//////				}
//////			break;
////			} else {
////				System.out.println("You did not enter a integer. Please try again!");
////			}
////		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("psdafsd");
		String s2 = scanner.nextLine();
		System.out.println("sdfg");
		int n = scanner.nextInt();
		if (s2.length() % n == 0) {
			int x =  s2.length() / n;
			for (int j = 0; j < x; j++) {
				System.out.println(s2.substring(n * j, n * (j+1)));			
			}
		} else {
		System.out.println("khong chia het");
		}
	}	
		
}	

	
	


	

 






























