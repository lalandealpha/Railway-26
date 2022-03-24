package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> , JpaSpecificationExecutor<Department> {
    boolean existsDepartmentByName(String name);

    @Query(value = "SELECT COUNT(*) FROM `Account` JOIN Department " +
            "ON `Account`.DepartmentID = Department.DepartmentID " +
            "WHERE `Account`.DepartmentID = :DepartmentID " +
            "GROUP BY Department.DepartmentID", nativeQuery = true)
    Integer getDepartmentTotalMemberById(@Param("DepartmentID") int id);

    Department findByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Department WHERE id IN(:ids)")
    void deleteByIds(@Param("ids") List<Integer> ids);
}
