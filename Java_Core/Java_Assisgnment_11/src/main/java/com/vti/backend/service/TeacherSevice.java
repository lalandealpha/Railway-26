package com.vti.backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.repository.ITeacherRepository;
import com.vti.backend.repository.TeacherRepository;
import com.vti.entity.basic.Teacher;

public class TeacherSevice implements ITeacherService {
	private ITeacherRepository teacherRepository;

	public TeacherSevice() {
		teacherRepository = new TeacherRepository();
	}

	public List<Teacher> getTeacherList(Connection connection)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return teacherRepository.getTeacherList(connection);
	}

	public Teacher getTeacherById(Connection connection, int id) throws SQLException {
		return teacherRepository.getTeacherById(connection, id);
	}

	public boolean isTeacherNameExist(Connection connection, String name) throws SQLException {
		return teacherRepository.isTeacherNameExist(connection, name);
	}

	public boolean isTeacherIdExist(Connection connection, int id) throws SQLException {
		return teacherRepository.isTeacherIdExist(connection, id);
	}

	public void createTeacherAcc(Connection connection, String email, String username, String fullname,
			String department, String position) throws SQLException {
		teacherRepository.createTeacherAcc(connection, email, username, fullname, department, position);
	}

	public void updateTeacherName(Connection connection, int id, String name) throws SQLException {
		teacherRepository.updateTeacherName(connection, id, name);
	}

	public void deleteTeacher(Connection connection, int id) throws SQLException {
		teacherRepository.deleteTeacher(connection, id);
	}

}
