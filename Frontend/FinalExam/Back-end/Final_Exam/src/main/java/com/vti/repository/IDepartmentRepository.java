package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> , JpaSpecificationExecutor<Department> {
    boolean existsDepartmentByName(String name);

    @Query(value = "SELECT COUNT(*) FROM `Account` JOIN Department " +
            "ON `Account`.DepartmentID = Department.DepartmentID " +
            "WHERE `Account`.DepartmentID = :DepartmentID " +
            "GROUP BY Department.DepartmentID", nativeQuery = true)
    Integer getDepartmentTotalMemberById(@Param("DepartmentID") int id);

    Department findByName(String name);
}
