package com.myproject.employeeservice.service;

import com.myproject.employeeservice.dto.APIResponseDto;
import com.myproject.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    public APIResponseDto getEmployeebyId(Long Id);

}
