package com.vti.backend.assignment7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.vti.backend.utils.FileUtils;

public class FileTest {
	
	public void Question1() {
		System.out.println("-------Question 1-------");
		if(FileUtils.isFileExist("/Users/user/Code/Java_Assignment/src/com/vti/entity/finalTestz")) {
			System.out.println("File exists!");
		} else {
			System.out.println("File does not exist!");
		}
	}
	
	public void Question2() throws Exception {
		System.out.println("-------Question 2-------");
		FileUtils.createNewFile("/Users/user/Downloads/2979650z.txt");
		
		FileUtils.createNewFile("/Users/user/Downloads/ide-eval-resetter", "test.txt");
	}
	
	public void Question4() throws Exception {
		System.out.println("-------Question 4-------");
		FileUtils.deleteFile("/Users/user/Downloads/2979650z.txt");
	}
	
	public void Question5() {
		System.out.println("-------Question 5-------");
		if(FileUtils.isFolder("/Users/user/Downloads")) {
			System.out.println("This is a folder.");
		} else {
			System.out.println("This is not a folder.");
		}
	}
	
	public void Question6() throws Exception {
		System.out.println("-------Question 6-------");
		String[] files = FileUtils.getAllFileName("/Users/user/Downloads");
		for (String file : files) {
			System.out.println(file);
		}
	}
	
	public void Question7() throws Exception {
		System.out.println("-------Question 7-------");
		FileUtils.copyFile("/Users/user/Downloads/2979650.txt", "/Users/user/Downloads/ide-eval-resetter/2979650.txt");
	}
	
	public void Question7Optional() throws Exception {
		System.out.println("-------Question 7a-------");
		FileUtils.copyFile("/Users/user/Downloads/2979650.txt", "/Users/user/Downloads/ide-eval-resetter", "2979650z.txt");
	}
	
	public void Question8() throws Exception {
		System.out.println("-------Question 8-------");
		FileUtils.moveFile("/Users/user/Downloads/test2.txt", "/Users/user/Downloads/ide-eval-resetter/test2.txt");
	}

	public void Question9() throws Exception {
		System.out.println("-------Question 9-------");
		FileUtils.renameFile("/Users/user/Downloads/test3.txt", "/Users/user/Downloads/test3renamed.txt");
	}

	public void Question10() throws Exception {
		System.out.println("-------Question 10-------");
		FileUtils.createNewFolder("/Users/user/Downloads/Test");
	}
	
	public void Question11() throws Exception {
		System.out.println("-------Question 11-------");
		FileUtils.downloadFile("/Users/user/Downloads/IMG_6627.jpg", "https://doc-0g-bo-docs.googleusercontent.com/docs/securesc/0spdh4i6lq671aa0r3ijh7oune33i3c2/qklfgiuep9auibqh0ssov2aojn303qrv/1640484225000/05012996961637966793/05012996961637966793/12Ctqpmowxggsx-kGi0jFVoJNGiO9tOfB?e=download&authuser=0");
	}
}
