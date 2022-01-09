package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.IStudentRepository;
import com.vti.backend.datalayer.PositionRepository;
import com.vti.backend.datalayer.StudentRepository;
import com.vti.entity.basic.Department;
import com.vti.entity.basic.Student;
import com.vti.utils.JdbcUtils;

public class StudentService implements IStudentService {
	
	private IStudentRepository studentRepository;
	
	public StudentService() {
		studentRepository = new StudentRepository();
	}
	
	public List<Student> getStudentList(Connection connection) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return studentRepository.getStudentList(connection);
	}
	
	public Student getStuAccById(Connection connection, int id) throws SQLException {
		return studentRepository.getStuAccById(connection, id);
	}

	public boolean isStuNameExist(Connection connection, String name) throws SQLException {
		return studentRepository.isStuNameExist(connection, name);
	}
	
	public boolean isStuIdExist(Connection connection, int id) throws SQLException {
		return studentRepository.isStuIdExist(connection, id);
	}
	
	public void createStudentAcc(Connection connection, String email, String username, String fullname, String department, String position) throws SQLException {
		studentRepository.createStudentAcc(connection, email, username, fullname, department, position);
	}

	public void updateStudentName(Connection connection, int id, String name) throws SQLException {
		studentRepository.updateStudentName(connection, id, name);
	}
	
	public void deleteStudent(Connection connection, int id) throws SQLException {
		studentRepository.deleteStudent(connection, id);
	}
}
