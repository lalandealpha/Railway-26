package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Jdbc;


public class JdbcProgram {
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Jdbc pro = new Jdbc();
		pro.Question1();
//		pro.Question2();
	}
}
