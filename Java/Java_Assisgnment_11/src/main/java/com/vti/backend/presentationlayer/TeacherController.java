package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.ITeacherService;
import com.vti.backend.businesslayer.TeacherSevice;
import com.vti.entity.basic.Teacher;

public class TeacherController {
	private ITeacherService teacherService;

	public TeacherController() {
		teacherService = new TeacherSevice();
	}

	public List<Teacher> getTeacherList(Connection connection)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		return teacherService.getTeacherList(connection);
	}

	public Teacher getTeacherById(Connection connection, int id) throws SQLException {
		return teacherService.getTeacherById(connection, id);
	}

	public boolean isTeacherNameExist(Connection connection, String name) throws SQLException {
		return teacherService.isTeacherNameExist(connection, name);
	}

	public boolean isTeacherIdExist(Connection connection, int id) throws SQLException {
		return teacherService.isTeacherIdExist(connection, id);
	}

	public void createTeacherAcc(Connection connection, String email, String username, String fullname,
			String department, String position) throws SQLException {
		teacherService.createTeacherAcc(connection, email, username, fullname, department, position);
	}

	public void updateTeacherName(Connection connection, int id, String name) throws SQLException {
		teacherService.updateTeacherName(connection, id, name);
	}

	public void deleteTeacher(Connection connection, int id) throws SQLException {
		teacherService.deleteTeacher(connection, id);
	}

}
