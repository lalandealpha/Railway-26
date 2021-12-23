package com.vti.backend.assignment7;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	public void Question1() {
		System.out.println("-------Question 1-------");
		String path = "/Users/user/Code/Java_Assignment/src/com/vti/entity/finalTest";
		File file = new File(path);
		if(file.exists()) {
			System.out.println("File exists!");
		} else {
			System.out.println("File not exists!");
		}
	}
	
	public void Question2() throws IOException {
		String path = "/Users/user/Downloads/2979650.txt";
		File file = new File(path);
		if(file.createNewFile()) {
			System.out.println("Created the file: " + file.getName());
		} else {
			System.out.println("File exists!");
		}
	}
	
	public void Question4() {
		String path = "/Users/user/Downloads/movie-fan-art-spider-man-into-the-spider-verse.jpg";
		File file = new File(path);
		if(file.exists()) {
			file.delete();
			System.out.println("Deleted the file: " + file.getName());
		} else {
			System.out.println("File not exists!");
		}
	}
	
	
}
