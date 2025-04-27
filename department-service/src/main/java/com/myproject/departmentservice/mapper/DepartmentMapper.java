package com.myproject.departmentservice.mapper;

import com.myproject.departmentservice.dto.DepartmentDto;
import com.myproject.departmentservice.entity.Department;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface DepartmentMapper {
        DepartmentDto toDepatmentDTO(Department department);
        Department toDepartment (DepartmentDto departmentDto);
    }
//    public static DepartmentDto mapToDepartmentDto(Department department) {
//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
//        return departmentDto;
//    }
//
//    public static Department mapToDepartment(DepartmentDto departmentDto) {
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );
//        return department;
//    }

