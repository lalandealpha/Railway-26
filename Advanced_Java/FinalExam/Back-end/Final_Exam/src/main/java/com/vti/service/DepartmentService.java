package com.vti.service;

import com.vti.entity.Department;
import com.vti.form.department.CreatingDepartmentForm;
import com.vti.form.department.DepartmentFilterForm;
import com.vti.form.department.UpdatingDepartmentForm;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.department.DepartmentSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDepartmentRepository repository;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm filterForm) {
        Specification<Department> where = DepartmentSpecification.buildWhere(search, filterForm);
        return repository.findAll(where, pageable);
    }

    @Override
    public List<Department> getDepartmentList() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Department getDepartmentByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createDepartment(CreatingDepartmentForm form) {
        // convert form to entity
        TypeMap<CreatingDepartmentForm, Department> typeMap = modelMapper.getTypeMap(CreatingDepartmentForm.class, Department.class);
        if(typeMap == null) {
            modelMapper.addMappings(new PropertyMap<CreatingDepartmentForm, Department>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }

        Department department = modelMapper.map(form, Department.class);

        repository.save(department);
    }

    @Override
    public void updateDepartment(int id, UpdatingDepartmentForm form) {
        // convert form to entity
        TypeMap<UpdatingDepartmentForm, Department> typeMap = modelMapper.getTypeMap(UpdatingDepartmentForm.class, Department.class);
        if(typeMap == null) {
            modelMapper.addMappings(new PropertyMap<UpdatingDepartmentForm, Department>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }

        Department newDepartment = modelMapper.map(form, Department.class);
        newDepartment.setId(id);

        //Get department's old properties
        Department oldDepartment = getDepartmentById(id);
        newDepartment.setName(oldDepartment.getName());
        newDepartment.setAccounts(oldDepartment.getAccounts());
        newDepartment.setCreateDate(oldDepartment.getCreateDate());

        repository.save(newDepartment);
    }

    @Override
    public void deleteDepartment(int id) {
        Department department = getDepartmentById(id);
        repository.delete(department);
    }

    @Override
    public boolean isDepartmentExistsByName(String name) {
        return repository.existsDepartmentByName(name);
    }

    @Override
    public Integer getDepartmentTotalMemberById(int id) {
        return repository.getDepartmentTotalMemberById(id);
    }
}
