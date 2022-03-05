package com.vti.backend.assignment7;

import com.vti.backend.utils.FileUtils;

public class FileTest {

	public void Question1() {
		System.out.println("-------Question 1-------");
		if (FileUtils.isFileExist("/Users/user/Documents/TestCode/FileFolderExist/Test1.txt")) {
			System.out.println("File exists!");
		} else {
			System.out.println("File does not exist!");
		}
	}

	public void Question2() throws Exception {
		System.out.println("-------Question 2-------");
		FileUtils.createNewFile("/Users/user/Documents/TestCode/FileFolderExist/Test2.txt");

		FileUtils.createNewFile("/Users/user/Documents/TestCode/FileFolderExist", "Test3.txt");
	}

	public void Question4() throws Exception {
		System.out.println("-------Question 4-------");
		FileUtils.deleteFile("/Users/user/Documents/TestCode/FileFolderExist/Test3.txt");
	}

	public void Question5() {
		System.out.println("-------Question 5-------");
		if (FileUtils.isFolder("/Users/user/Documents/TestCode/FileFolderExist")) {
			System.out.println("This is a folder.");
		} else {
			System.out.println("This is not a folder.");
		}
	}

	public void Question6() throws Exception {
		System.out.println("-------Question 6-------");
		String[] files = FileUtils.getAllFileName("/Users/user/Documents/TestCode/FileFolderExist");
		for (String file : files) {
			System.out.println(file);
		}
	}

	public void Question7() throws Exception {
		System.out.println("-------Question 7-------");
		FileUtils.copyFile("/Users/user/Documents/TestCode/FileFolderExist/Test1.txt",
				"/Users/user/Documents/TestCode/CopiedFile/Test1.txt");
	}

	public void Question7Optional() throws Exception {
		System.out.println("-------Question 7a-------");
		FileUtils.copyFile("/Users/user/Documents/TestCode/FileFolderExist/Test2.txt",
				"/Users/user/Documents/TestCode/CopiedFile", "Test2renamed.txt");
	}

	public void Question8() throws Exception {
		System.out.println("-------Question 8-------");
		FileUtils.moveFile("/Users/user/Documents/TestCode/CopiedFile/Test2renamed.txt",
				"/Users/user/Documents/TestCode/FileFolderExist/Test2renamed.txt");
	}

	public void Question9() throws Exception {
		System.out.println("-------Question 9-------");
		FileUtils.renameFile("/Users/user/Documents/TestCode/FileFolderExist/Test4.txt",
				"/Users/user/Documents/TestCode/FileFolderExist/Test4renamed.txt");
	}

	public void Question10() throws Exception {
		System.out.println("-------Question 10-------");
		FileUtils.createNewFolder("/Users/user/Documents/TestCode/TestCreateNewFolder");
	}

	public void Question11() throws Exception {
		System.out.println("-------Question 11-------");
		FileUtils.downloadFile("/Users/user/Documents/TestCode/FileFolderExist/IMG_6627.jpg",
				"https://cdn.crunchify.com/wp-content/uploads/2014/08/Java-How-to-Sort-a-MapK-V-on-the-Values.png");
	}
}
