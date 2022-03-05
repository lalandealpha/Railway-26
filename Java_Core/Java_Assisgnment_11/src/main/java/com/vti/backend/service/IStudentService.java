package com.vti.backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.basic.Student;

public interface IStudentService {
	public List<Student> getStudentList(Connection connection) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public Student getStuAccById(Connection connection, int id) throws SQLException;

	public boolean isStuNameExist(Connection connection, String name) throws SQLException;
	
	public boolean isStuIdExist(Connection connection, int id) throws SQLException;
	
	public void createStudentAcc(Connection connection, String email, String username, String fullname, String department, String position) throws SQLException;

	public void updateStudentName(Connection connection, int id, String name) throws SQLException;
	
	public void deleteStudent(Connection connection, int id) throws SQLException;
}
