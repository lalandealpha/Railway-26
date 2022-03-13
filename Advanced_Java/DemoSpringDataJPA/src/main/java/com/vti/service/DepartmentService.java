package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	public List<Department> getAllDepartments() {
		return repository.findAll();
	}

	public Department getDepartmentByID(int id) {
		return repository.findById(id).get();
	}

	public void createDepartment(Department department) {
		repository.save(department);
	}

	public void updateDepartment(Department department) {
		repository.save(department);
	}

	public void deleteDepartment(int id) {
		repository.deleteById(id);
	}

	public boolean isDepartmentExistsByID(int id) {
		return repository.existsById(id);
	}

	@Override
	public boolean existsByName(String name) {
		return repository.existsByName(name);
	}

	@Override
	public List<Department> findByNameOrTotalMemberGreaterThan(String name, int totalMember) {
		return repository.findByNameOrTotalMemberGreaterThan(name, totalMember);
	}

	@Override
	public void deleteDepartmentByName(String name) {
		repository.deleteDepartmentByName(name);
	}

}
