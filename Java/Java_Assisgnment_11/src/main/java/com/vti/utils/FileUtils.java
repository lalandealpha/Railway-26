package com.vti.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

public class FileUtils {

	public boolean isFileExist(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	public void createNewFile(String filePath) throws Exception {
		File file = new File(filePath);
		if (file.exists()) {
			throw new Exception("Error! File exists.");
		} else {
			file.createNewFile();
//			System.out.println("File created successfully!");
		}
	}

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
//				System.out.println("File created successfully!");
			}
		}
	}

	public void deleteFile(String filePath) throws Exception {
		if (!isFileExist(filePath)) {
			throw new Exception("Error! File not found.");
		} else {
			File file = new File(filePath);
			file.delete();
//			System.out.println("File deleted!");
		}
	}

	public boolean isFolder(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}

	public String[] getAllFileName(String folderPath) throws Exception {
		if (isFolder(folderPath)) {
			File file = new File(folderPath);
			return file.list();
		} else {
			throw new Exception("Error. Path is not a folder!");
		}
	}

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

	public void copyFile(String fileToCopy, String folderPath, String newName) throws Exception {
		File file1 = new File(fileToCopy);
		File file2 = new File(folderPath + "/" + newName);
		if (!file1.exists()) {
			throw new Exception("Error! Source file not found!");
		} else {
			if (!file2.exists()) {
				Files.copy(file1.toPath(), file2.toPath());
//				System.out.println("File copied and renamed successfully!");
			} else {
				throw new Exception("Error! Destination has a file with the same name!");
			}
		}
	}

	public void moveFile(String fileToMove, String newFilePath) throws Exception {
		File file1 = new File(fileToMove);
		File file2 = new File(newFilePath);
		if (!file1.exists()) {
			throw new Exception("Error! Source file not found!");
		} else {
			if (!file2.exists()) {
				Files.move(file1.toPath(), file2.toPath());
//				System.out.println("File moved successfully!");
			} else {
				throw new Exception("Error! Destination has a file with the same name!");
			}
		}
	}

	public void renameFile(String fileToRename, String newNamePath) throws Exception {
		File file1 = new File(fileToRename);
		File file2 = new File(newNamePath);
		if (!file1.exists()) {
			throw new Exception("Error! File not found!");
		} else {
			if (!file2.exists()) {
				file1.renameTo(file2);
//				System.out.println("File renamed successfully!");
			} else {
				throw new Exception("Error! Destination has a file with the same name!");
			}
		}
	}

	public void createNewFolder(String newFolderPath) throws Exception {
		File file = new File(newFolderPath);
		if (!file.exists()) {
			file.mkdirs();
//			System.out.println("Folder created successfully!");
		} else {
			throw new Exception("Error! Folder exists.");
		}
	}

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
