package com.vti.frontend;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.*;
import com.vti.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();

//        // Get all department
//        Short emulationPoint = null;
//        String name = "Sale";
//
//        List<DepartmentDTO> departmentDTOS = departmentRepository.getAllDepartments(1, 5, name, emulationPoint);
//        for (DepartmentDTO departmentDTO : departmentDTOS) {
//            System.out.println(departmentDTO);
//        }null


//        // Get total Department counts
//        Short emulationPoint = 3;
//        String name = null;
//        System.out.println("Tổng số bản ghi: " + departmentRepository.getToTalDepartment(name, emulationPoint));

//        // Get Department by Id
//        System.out.println(departmentRepository.getDepartmentByID((short) 5));

//        // Get Department by Name
//        System.out.println(departmentRepository.getDepartmentByName("Sale"));

//        // Update Department
//        departmentRepository.updateDepartment((short) 1, "updated Marketing");

//        // Delete Department
//        List<Short> ids = new ArrayList<>();
//        ids.add((short) 3);
//        ids.add((short) 10);
//        departmentRepository.deleteDepartment(ids);

        // Check if Department exists or not
        System.out.println(departmentRepository.isDepartmentExistsById((short) 4));
        System.out.println(departmentRepository.isDepartmentExistsByName("Sales"));



    }
}
