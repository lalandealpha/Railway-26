package com.vti.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.vti.entity.basic.Department;
import com.vti.entity.basic.Student;

public class StudentRepository implements IStudentRepository {
	private DepartmentRepository departmentRepository;
	private PositionRepository positionRepository;
	
	public StudentRepository() {
		departmentRepository = new DepartmentRepository();
		positionRepository = new PositionRepository();
	}
	
	public List<Student> getStudentList(Connection connection) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM StudentAccount");
		
		List<Student> students = new ArrayList<>();
		while (resultSet.next()) {
			Student student = new Student(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4), resultSet.getDate(7));
			
			// check if departments exist or not
			List<Department> departments = new ArrayList<>();
			Department department = null;
			for (Department d : departments) {
				if(d.getId() == resultSet.getInt(5)) {
					department = d;
				} 
			}
			if (department != null) {
				student.setDepartment(department);
			} else {
				department = departmentRepository.getDeptById(connection, resultSet.getInt(5));
				student.setDepartment(department);
				departments.add(department);
			}
			
			// set Position
			student.setPositon(positionRepository.getPositionById(connection, resultSet.getInt(6)));
			students.add(student);
		}
		return students;
	}
	
	public Student getStuAccById(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM StudentAccount WHERE StudentID = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Student student = null;
		while (resultSet.next()) {
			student = new Student(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4), resultSet.getDate(7));
			
			// check if departments exist or not
			List<Department> departments = new ArrayList<>();
			Department department = null;
			for (Department d : departments) {
				if(d.getId() == resultSet.getInt(5)) {
					department = d;
				} 
			}
			if (department != null) {
				student.setDepartment(department);
			} else {
				department = departmentRepository.getDeptById(connection, resultSet.getInt(5));
				student.setDepartment(department);
				departments.add(department);
			}
			
			// set Position
			student.setPositon(positionRepository.getPositionById(connection, resultSet.getInt(6)));
		}
		return student;
	}

	public boolean isStuNameExist(Connection connection, String name) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT Fullname FROM StudentAccount WHERE Fullname = ?");
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	
	public boolean isStuIdExist(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT StudentID FROM StudentAccount WHERE StudentID = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	
	public void createStudentAcc(Connection connection, String email, String username, String fullname, String department, String position) throws SQLException {
		if(isStuNameExist(connection, fullname)) {
			System.out.println("Student name exists!");
		} else {
			PositionRepository positionRepository = new PositionRepository();
			DepartmentRepository departmentRepository = new DepartmentRepository();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO StudentAccount (Email, Username, Fullname, DepartmentID, PositionID, CreateDate) VALUES (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, fullname);
			preparedStatement.setInt(4, departmentRepository.getDeptByName(connection, department).getId());
			preparedStatement.setInt(5, positionRepository.getPositionIdByName(connection, position));
			preparedStatement.setDate(6, new Date(System.currentTimeMillis()));
			int AffectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Affected record(s) amount:" + AffectedRecordAmount);
		}
	}

	public void updateStudentName(Connection connection, int id, String name) throws SQLException {
		if(!isStuIdExist(connection, id)) {
			System.err.println("Student not found!");
		} else {
			if(isStuNameExist(connection, name)) {
				System.err.println("The new name is the same as the current name.");
			} else {
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE StudentAccount SET Fullname = ? WHERE StudentID =?");
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, id);
				int AffectedRecordAmount = preparedStatement.executeUpdate();
				System.out.println("Affected record(s) amount:" + AffectedRecordAmount);
			}
		}
	}
	
	public void deleteStudent(Connection connection, int id) throws SQLException {
		if(!isStuIdExist(connection, id)) {
			System.err.println("Student not found!");
		} else {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM StudentAccount WHERE StudentID =?");
			preparedStatement.setInt(1, id);
			int AffectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Affected record(s) amount:" + AffectedRecordAmount);
		}
	}

}
