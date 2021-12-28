package com.vti.backend.assignment7;

import com.vti.backend.utils.IOManager;
import com.vti.entity.IOStreamTest.Student;

public class ioStream {

	public void Question1() throws Exception {
		System.out.println("-------Question 1-------");
		System.out.println(IOManager.readTxtFile("/Users/user/Downloads/2979650.txt"));
	}

	public void Question2() throws Exception {
		System.out.println("-------Question 2-------");
		IOManager.writeTxtFile("/Users/user/Downloads/2979.txt", "Testing IOManager's writter methord.......", false);
	}

	public void Question3() throws Exception {
		System.out.println("-------Question 3-------");
		Student student = new Student(1, "Ardelis Lewisham", 1);
		IOManager.convertObjToSer(student, "/Users/user/Documents/TestCode/ConvertObjToFile", "Student.ser");
	}

	public void Question4() throws Exception {
		System.out.println("-------Question 4-------");
		Student student = (Student) IOManager.readObject("/Users/user/Documents/TestCode/ConvertObjToFile/Student.ser");
		System.out.println("ID: " + student.getId());
		System.out.println("Name: " + student.getName());
		System.out.println("Group: " + student.getGroup());
	}
}
