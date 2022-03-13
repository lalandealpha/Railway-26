package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    boolean existsByName(String name);
    List<Department> findByNameOrTotalMemberGreaterThan(String name, int totalMember);

    @Modifying
    @Query("DELETE FROM Department WHERE name = :name")
    void deleteDepartmentByName(@Param("name") String name);
}
