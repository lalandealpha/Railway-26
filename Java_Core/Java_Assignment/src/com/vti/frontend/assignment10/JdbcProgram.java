package com.vti.frontend.assignment10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.assignment10.Jdbc;

public class JdbcProgram {
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Jdbc pro = new Jdbc();
		pro.Question1();
		pro.Question2();
	}
}
