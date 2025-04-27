package com.myproject.departmentservice.service;

import com.myproject.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

   public DepartmentDto saveDepartment(DepartmentDto departmentDto);

   public  DepartmentDto getDepartmentByCode(String Code);

}
