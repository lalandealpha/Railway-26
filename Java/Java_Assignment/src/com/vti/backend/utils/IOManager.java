package com.vti.backend.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOManager {
	
	public static String readTxtFile(String filePath) throws Exception {
		if(!FileUtils.isFileExist(filePath)) {
			throw new Exception("Error! File not found.");
		} else {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			byte[] b = new byte[1024];
			int length = fileInputStream.read(b);
			String content = "";
			while(length > -1) {
				content += new String(b, 0, length);
				length = fileInputStream.read(b);
			}
			fileInputStream.close();
			return content;	
		}
		
	}

	public static void writeTxtFile(String filePath, String Content, boolean isContinuing) throws Exception {
		if(!FileUtils.isFileExist(filePath)) {
			throw new Exception("Error! File not found.");
		} else {
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, isContinuing);
			fileOutputStream.write(Content.getBytes());
			System.out.println("Content written successfully!");
			fileOutputStream.close();
		}
	}

	public static void convertObjToSer(Object object, String folderPath, String fileName) throws Exception {
		//fileName.ser and class of instance must implement java.io.Serializable
		if(object == null) {
			throw new Exception("Error! Null object pointer.");
		} else {
			if(!FileUtils.isFolder(folderPath)) {
				System.out.println("Creating new Folder...");
				FileUtils.createNewFolder(folderPath);
				String filePath = folderPath + "/" + fileName;
				FileOutputStream fileOutputStream = new FileOutputStream(filePath);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(object);
				System.out.println("Object converted to file successfully!");
				objectOutputStream.close();
			} else {
				String filePath = folderPath + "/" + fileName;
				if(!FileUtils.isFileExist(filePath)) {
					FileOutputStream fileOutputStream = new FileOutputStream(filePath);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
					objectOutputStream.writeObject(object);
					System.out.println("Object converted to file successfully!");
					objectOutputStream.close();
				} else {
					new File(filePath).delete();
					FileOutputStream fileOutputStream = new FileOutputStream(filePath);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
					objectOutputStream.writeObject(object);
					System.out.println("Object converted to file successfully!");
					objectOutputStream.close();
				}
			}
		}
	}
	
	public static Object readObject(String filePath) throws Exception {
		if(!FileUtils.isFileExist(filePath)) {
			throw new Exception("Error! File not found.");
		} else {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			objectInputStream.close();
			return object;
		}
	}
}
