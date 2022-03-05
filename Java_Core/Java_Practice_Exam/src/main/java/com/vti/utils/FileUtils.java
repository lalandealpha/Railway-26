package com.vti.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

/**
 * This class is file utils. 
 * 
 * @Description: .
 * @author: LuanNT
 * @create_date: 9 thg 1, 2022
 * @version: 1.0
 * @modifer: LuanNT
 * @modifer_date: 9 thg 1, 2022
 */
public class FileUtils {

	/**
	 * This method is for checking if file exists or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param filePath
	 * @return
	 */
	public boolean isFileExist(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is for creating a new file. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param filePath
	 * @throws Exception
	 */
	public void createNewFile(String filePath) throws Exception {
		File file = new File(filePath);
		if (file.exists()) {
			throw new Exception("Error! File exists.");
		} else {
			file.createNewFile();
		}
	}

	/**
	 * This method is for creating a new file. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param folderPath
	 * @param fileName
	 * @throws Exception
	 */
	public void createNewFile(String folderPath, String fileName) throws Exception {
		File file1 = new File(folderPath);
		if (!file1.isDirectory()) {
			throw new Exception("Error! Destination path is not a folder.");
		} else {
			String filePath = folderPath + "/" + fileName;
			if (isFileExist(filePath)) {
				throw new Exception("Error! File exists.");
			} else {
				File file2 = new File(filePath);
				file2.createNewFile();
			}
		}
	}

	/**
	 * This method is for deleting a file. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param filePath
	 * @throws Exception
	 */
	public void deleteFile(String filePath) throws Exception {
		if (!isFileExist(filePath)) {
			throw new Exception("Error! File not found.");
		} else {
			File file = new File(filePath);
			file.delete();
		}
	}

	/**
	 * This method is for checking if path is a folder path or not. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param path
	 * @return
	 */
	public boolean isFolder(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is for getting a list of all files in the folder. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param folderPath
	 * @return
	 * @throws Exception
	 */
	public String[] getAllFileName(String folderPath) throws Exception {
		if (isFolder(folderPath)) {
			File file = new File(folderPath);
			return file.list();
		} else {
			throw new Exception("Error. Path is not a folder!");
		}
	}

	/**
	 * This method is for copying a file. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param fileToCopy
	 * @param destPath
	 * @throws Exception
	 */
	public void copyFile(String fileToCopy, String destPath) throws Exception {
		File file1 = new File(fileToCopy);
		File file2 = new File(destPath);
		if (!file1.exists()) {
			throw new Exception("Error! Source file does not exist!");
		} else {
			if (!file2.exists()) {
				Files.copy(file1.toPath(), file2.toPath());
//				System.out.println("File copied successfully!");
			} else {
				throw new Exception("Error! Destination has a file with the same name!");
			}
		}
	}

	/**
	 * This method is for copying a file. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param fileToCopy
	 * @param folderPath
	 * @param newName
	 * @throws Exception
	 */
	public void copyFile(String fileToCopy, String folderPath, String newName) throws Exception {
		File file1 = new File(fileToCopy);
		File file2 = new File(folderPath + "/" + newName);
		if (!file1.exists()) {
			throw new Exception("Error! Source file not found!");
		} else {
			if (!file2.exists()) {
				Files.copy(file1.toPath(), file2.toPath());
			} else {
				throw new Exception("Error! Destination has a file with the same name!");
			}
		}
	}

	/**
	 * This method is for moving a file. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param fileToMove
	 * @param newFilePath
	 * @throws Exception
	 */
	public void moveFile(String fileToMove, String newFilePath) throws Exception {
		File file1 = new File(fileToMove);
		File file2 = new File(newFilePath);
		if (!file1.exists()) {
			throw new Exception("Error! Source file not found!");
		} else {
			if (!file2.exists()) {
				Files.move(file1.toPath(), file2.toPath());
			} else {
				throw new Exception("Error! Destination has a file with the same name!");
			}
		}
	}

	/**
	 * This method is for renaming a file. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param fileToRename
	 * @param newNamePath
	 * @throws Exception
	 */
	public void renameFile(String fileToRename, String newNamePath) throws Exception {
		File file1 = new File(fileToRename);
		File file2 = new File(newNamePath);
		if (!file1.exists()) {
			throw new Exception("Error! File not found!");
		} else {
			if (!file2.exists()) {
				file1.renameTo(file2);
			} else {
				throw new Exception("Error! Destination has a file with the same name!");
			}
		}
	}

	/**
	 * This method is for creating a new folder. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param newFolderPath
	 * @throws Exception
	 */
	public void createNewFolder(String newFolderPath) throws Exception {
		File file = new File(newFolderPath);
		if (!file.exists()) {
			file.mkdirs();
		} else {
			throw new Exception("Error! Folder exists.");
		}
	}

	/**
	 * This method is for downloading a file from internet. 
	 * 
	 * @Description: .
	 * @author: LuanNT
	 * @create_date: 9 thg 1, 2022
	 * @version: 1.0
	 * @modifer: LuanNT
	 * @modifer_date: 9 thg 1, 2022
	 * @param filePath
	 * @param urlString
	 * @throws Exception
	 */
	public void downloadFile(String filePath, String urlString) throws Exception {
		File file = new File(filePath);
		if (!file.exists()) {
			URL fetchWebsite = new URL(urlString);
			ReadableByteChannel readableByteChannel = Channels.newChannel(fetchWebsite.openStream());

			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		} else {
			throw new Exception("Error! Destination has a file with the same name!");
		}
	}
}
