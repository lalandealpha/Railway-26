package com.vti.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.basic.Department;
import com.vti.entity.basic.Teacher;
import com.vti.utils.JdbcUtils;

public class TeacherRepository implements ITeacherRepository {
	private DepartmentRepository departmentRepository;

	public TeacherRepository() {
		departmentRepository = new DepartmentRepository();
	}

	public List<Teacher> getTeacherList(Connection connection) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM TeacherAccount");

		List<Teacher> teachers = new ArrayList<>();
		while (resultSet.next()) {
			Teacher teacher = new Teacher(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getDate(6));

			// check if departments exist or not
			List<Department> departments = new ArrayList<>();
			Department department = null;
			for (Department d : departments) {
				if (d.getId() == resultSet.getInt(5)) {
					department = d;
				}
			}
			if (department != null) {
				teacher.setDepartment(department);
			} else {
				department = departmentRepository.getDeptById(connection, resultSet.getInt(5));
				teacher.setDepartment(department);
				departments.add(department);
			}
			teachers.add(teacher);
		}
		return teachers;
	}

	public Teacher getTeacherById(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM TeacherAccount WHERE StudentID = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Teacher teacher = null;
		while (resultSet.next()) {
			teacher = new Teacher(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getDate(7));

			// check if departments exist or not
			List<Department> departments = new ArrayList<>();
			Department department = null;
			for (Department d : departments) {
				if (d.getId() == resultSet.getInt(5)) {
					department = d;
				}
			}
			if (department != null) {
				teacher.setDepartment(department);
			} else {
				department = departmentRepository.getDeptById(connection, resultSet.getInt(5));
				teacher.setDepartment(department);
				departments.add(department);
			}
		}
		return teacher;
	}

	public boolean isTeacherNameExist(Connection connection, String name) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT Fullname FROM TeacherAccount WHERE Fullname = ?");
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	public boolean isTeacherIdExist(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT TeacherID FROM TeacherAccount WHERE TeacherID = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	public void createTeacherAcc(Connection connection, String email, String username, String fullname,
			String department, String position) throws SQLException {
		if (isTeacherNameExist(connection, fullname)) {
			System.out.println("Teacher name exists!");
		} else {
			PositionRepository positionRepository = new PositionRepository();
			DepartmentRepository departmentRepository = new DepartmentRepository();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO TeacherAccount (Email, Username, Fullname, DepartmentID, CreateDate) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, fullname);
			preparedStatement.setInt(4, departmentRepository.getDeptByName(connection, department).getId());
			preparedStatement.setDate(5, new Date(System.currentTimeMillis()));
			int AffectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Affected record(s) amount:" + AffectedRecordAmount);
		}
	}

	public void updateTeacherName(Connection connection, int id, String name) throws SQLException {
		if (!isTeacherIdExist(connection, id)) {
			System.err.println("Teacher not found!");
		} else {
			if (isTeacherNameExist(connection, name)) {
				System.err.println("The new name is the same as the current name.");
			} else {
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE TeacherAccount SET Fullname = ? WHERE TeacherID =?");
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, id);
				int AffectedRecordAmount = preparedStatement.executeUpdate();
				System.out.println("Affected record(s) amount:" + AffectedRecordAmount);
			}
		}
	}

	public void deleteTeacher(Connection connection, int id) throws SQLException {
		if (!isTeacherIdExist(connection, id)) {
			System.err.println("Teacher not found!");
		} else {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM TeacherAccount WHERE TeacherID =?");
			preparedStatement.setInt(1, id);
			int AffectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Affected record(s) amount:" + AffectedRecordAmount);
		}
	}

}
