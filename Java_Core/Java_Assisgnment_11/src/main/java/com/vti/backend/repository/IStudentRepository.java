package com.vti.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.basic.Student;

public interface IStudentRepository {
	List<Student> getStudentList(Connection connection) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	Student getStuAccById(Connection connection, int id) throws SQLException;

	boolean isStuNameExist(Connection connection, String name) throws SQLException;
	
	boolean isStuIdExist(Connection connection, int id) throws SQLException;
	
	void createStudentAcc(Connection connection, String email, String username, String fullname, String department, String position) throws SQLException;

	void updateStudentName(Connection connection, int id, String name) throws SQLException;
	
	void deleteStudent(Connection connection, int id) throws SQLException;
}
