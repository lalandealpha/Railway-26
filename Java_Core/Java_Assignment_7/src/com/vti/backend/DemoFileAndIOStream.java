package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.backend.utils.FileUtils;
import com.vti.backend.utils.IOManager;
import com.vti.entity.demoFileAndIOStream.Student;

public class DemoFileAndIOStream {

	public void Question1() throws Exception {
		System.out.println("Create 3 students.");
		List<Student> students = new ArrayList<Student>();
		students.add(new Student());
		students.add(new Student());
		students.add(new Student());
		System.out.println("Students created successfully!");
		String toString = "";
		for (int i = 0; i < students.size(); i++) {
			toString += "Student 1:\n" + "    ID: " + students.get(i).getId() + "\n" + "    Name: "
					+ students.get(i).getName() + "\n\n";
		}
		FileUtils.createNewFile("/Users/user/Documents/TestCode/ConvertObjToFile/StudentInfo.txt");
		IOManager.writeTxtFile("/Users/user/Documents/TestCode/ConvertObjToFile/StudentInfo.txt", toString, true);
		System.out.println(IOManager.readTxtFile("/Users/user/Documents/TestCode/ConvertObjToFile/StudentInfo.txt"));
	}
}
