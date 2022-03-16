package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {
    Page<Department> getAllDepartments(Pageable pageable);

    boolean isDepartmentExistsByUsername(String name);

    int getDepartmentTotalMemberById(int id);
}
