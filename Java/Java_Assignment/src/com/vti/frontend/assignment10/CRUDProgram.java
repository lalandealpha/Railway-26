package com.vti.frontend.assignment10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.assignment10.CRUD;

public class CRUDProgram {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		CRUD pro = new CRUD();
//		pro.Question1();
//		pro.Question2();
		pro.Question3();
	}
}
