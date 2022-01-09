package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.basic.Teacher;

public interface ITeacherRepository {
	List<Teacher> getTeacherList(Connection connection) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	Teacher getTeacherById(Connection connection, int id) throws SQLException;

	boolean isTeacherNameExist(Connection connection, String name) throws SQLException;

	boolean isTeacherIdExist(Connection connection, int id) throws SQLException;

	void createTeacherAcc(Connection connection, String email, String username, String fullname, String department, String position) throws SQLException;

	void updateTeacherName(Connection connection, int id, String name) throws SQLException;

	void deleteTeacher(Connection connection, int id) throws SQLException;

}
