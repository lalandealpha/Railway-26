package com.vti.frontend.assignment10;

import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.assignment10.Basic;

public class BasicProgram {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Basic pro = new Basic();
		pro.Question1();
		pro.Question2();
		pro.Question3();
		pro.Question4();
		pro.Question5();
	}
}
