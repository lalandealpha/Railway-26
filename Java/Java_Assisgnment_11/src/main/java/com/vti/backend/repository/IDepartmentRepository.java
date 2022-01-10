package com.vti.backend.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.basic.Department;

public interface IDepartmentRepository {
	public List<Department> getDepartments(Connection connection) throws SQLException;
	
	public Department getDeptById(Connection connection, int id) throws SQLException;
	
	public Department getDeptByName(Connection connection, String name) throws SQLException;
	
	public boolean isDeptNameExist(Connection connection, String name) throws SQLException;
	
	public boolean isDeptIdExist(Connection connection, int id) throws SQLException;
	
	public void createDepartment(Connection connection, String name) throws SQLException;

	public void updateDeptName(Connection connection, int id, String name) throws SQLException;
	
	public void deleteDepartment(Connection connection, int id) throws SQLException;
}
