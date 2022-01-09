package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.basic.Teacher;

public interface ITeacherService {
	public List<Teacher> getTeacherList(Connection connection)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	public Teacher getTeacherById(Connection connection, int id) throws SQLException;

	public boolean isTeacherNameExist(Connection connection, String name) throws SQLException;

	public boolean isTeacherIdExist(Connection connection, int id) throws SQLException;

	public void createTeacherAcc(Connection connection, String email, String username, String fullname,
			String department, String position) throws SQLException;

	public void updateTeacherName(Connection connection, int id, String name) throws SQLException;

	public void deleteTeacher(Connection connection, int id) throws SQLException;
}
