package com.myproject.departmentservice.repository;

import com.myproject.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends
        JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
