package com.myproject.departmentservice.mapper;

import com.myproject.departmentservice.dto.DepartmentDto;
import com.myproject.departmentservice.entity.Department;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-14T00:19:26+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto toDepatmentDTO(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( department.getId() );
        departmentDto.setDepartmentName( department.getDepartmentName() );
        departmentDto.setDepartmentDescription( department.getDepartmentDescription() );
        departmentDto.setDepartmentCode( department.getDepartmentCode() );

        return departmentDto;
    }

    @Override
    public Department toDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( departmentDto.getId() );
        department.setDepartmentName( departmentDto.getDepartmentName() );
        department.setDepartmentDescription( departmentDto.getDepartmentDescription() );
        department.setDepartmentCode( departmentDto.getDepartmentCode() );

        return department;
    }
}
