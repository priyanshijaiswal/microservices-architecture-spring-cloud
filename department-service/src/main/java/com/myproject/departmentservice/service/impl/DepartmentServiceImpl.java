package com.myproject.departmentservice.service.impl;

import com.myproject.departmentservice.dto.DepartmentDto;
import com.myproject.departmentservice.entity.Department;
import com.myproject.departmentservice.mapper.DepartmentMapper;
import com.myproject.departmentservice.repository.DepartmentRepository;
import com.myproject.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    public DepartmentRepository departmentRepository;
    public DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department= departmentMapper.toDepartment(departmentDto);
        Department savedDepartment= departmentRepository.save(department);
        DepartmentDto savedDepartmentdto = departmentMapper.toDepatmentDTO(savedDepartment);

        return savedDepartmentdto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = departmentMapper.toDepatmentDTO(department);
        return departmentDto;
    }
}
