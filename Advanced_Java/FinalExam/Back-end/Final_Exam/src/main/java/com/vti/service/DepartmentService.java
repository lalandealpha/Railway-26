package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository repository;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public boolean isDepartmentExistsByUsername(String name) {
        return repository.existsDepartmentByName(name);
    }

    @Override
    public int getDepartmentTotalMemberById(int id) {
        return repository.getDepartmentTotalMemberById(id);
    }
}
