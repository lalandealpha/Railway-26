package com.vti.backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.service.IStudentService;
import com.vti.backend.service.StudentService;
import com.vti.entity.basic.Student;

public class StudentController {
	private IStudentService studentService;
	
	public StudentController() {
		studentService = new StudentService();
	}
	
	public List<Student> getStudentList(Connection connection) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return studentService.getStudentList(connection);
	}
	
	public Student getStuAccById(Connection connection, int id) throws SQLException {
		return studentService.getStuAccById(connection, id);
	}

	public boolean isStuNameExist(Connection connection, String name) throws SQLException {
		return studentService.isStuNameExist(connection, name);
	}
	
	public boolean isStuIdExist(Connection connection, int id) throws SQLException {
		return studentService.isStuIdExist(connection, id);
	}
	
	public void createStudentAcc(Connection connection, String email, String username, String fullname, String department, String position) throws Exception {
		if (username.length() > 3 && username.length() < 10) {
			if (fullname.length() > 3 && username.length() < 30) {
				studentService.createStudentAcc(connection, email, username, fullname, department, position);
			} else {
				throw new Exception("Length of the fullname must be greater than 3 and less than 30");
			}
		} else {
			throw new Exception("Length of the username  must be greater than 3 and less than 10");
		}
	}

	public void updateStudentName(Connection connection, int id, String name) throws SQLException {
		studentService.updateStudentName(connection, id, name);
	}
	
	public void deleteStudent(Connection connection, int id) throws SQLException {
		studentService.deleteStudent(connection, id);
	}
}
