package com.vti.backend.businesslayer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.IDepartmentRepository;
import com.vti.entity.basic.Department;

public class DepartmentService implements IDepartmentService  {
	private IDepartmentRepository departmentRepository;
	
	public DepartmentService() {
		departmentRepository = new DepartmentRepository();
	}
	
	public  List<Department> getDepartments(Connection connection) throws SQLException {
		return departmentRepository.getDepartments(connection);
	}
	
	public Department getDeptById(Connection connection, int id) throws SQLException {
		return departmentRepository.getDeptById(connection, id);
	}
	
	public boolean isDeptNameExist(Connection connection, String name) throws SQLException {
		return departmentRepository.isDeptNameExist(connection, name);
	}
	
	public boolean isDeptIdExist(Connection connection, int id) throws SQLException {
		return departmentRepository.isDeptIdExist(connection, id);
	}
	
	public void createDepartment(Connection connection, String name) throws SQLException {
		departmentRepository.createDepartment(connection, name);
	}

	public void updateDeptName(Connection connection, int id, String name) throws SQLException {
		departmentRepository.updateDeptName(connection, id, name);
	}
	
	public void deleteDepartment(Connection connection, int id) throws SQLException {
		departmentRepository.deleteDepartment(connection, id);
	}

	public Department getDeptByName(Connection connection, String name) throws SQLException {
		return departmentRepository.getDeptByName(connection, name);
	}
}
