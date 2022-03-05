package com.vti.backend.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.service.DepartmentService;
import com.vti.backend.service.IDepartmentService;
import com.vti.entity.basic.Department;

public class DepartmentController {
	private IDepartmentService departmentService;
	
	public DepartmentController() {
		departmentService = new DepartmentService();
	}
	
	public  List<Department> getDepartments(Connection connection) throws SQLException {
		return departmentService.getDepartments(connection);
	}
	
	public Department getDeptById(Connection connection, int id) throws SQLException {
		return departmentService.getDeptById(connection, id);
	}
	
	public boolean isDeptNameExist(Connection connection, String name) throws SQLException {
		return departmentService.isDeptNameExist(connection, name);
	}
	
	public boolean isDeptIdExist(Connection connection, int id) throws SQLException {
		return departmentService.isDeptIdExist(connection, id);
	}
	
	public void createDepartment(Connection connection, String name) throws SQLException {
		departmentService.createDepartment(connection, name);
	}

	public void updateDeptName(Connection connection, int id, String name) throws SQLException {
		departmentService.updateDeptName(connection, id, name);
	}
	
	public void deleteDepartment(Connection connection, int id) throws SQLException {
		departmentService.deleteDepartment(connection, id);
	}
}
