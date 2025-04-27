package com.myproject.employeeservice.mapper;

import com.myproject.employeeservice.dto.EmployeeDTO;
import com.myproject.employeeservice.entity.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-18T18:06:41+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO toEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employee.getId() );
        employeeDTO.setFirstName( employee.getFirstName() );
        employeeDTO.setLastName( employee.getLastName() );
        employeeDTO.setEmail( employee.getEmail() );
        employeeDTO.setDepartmentCode( employee.getDepartmentCode() );
        employeeDTO.setOrganizationCode( employee.getOrganizationCode() );

        return employeeDTO;
    }

    @Override
    public Employee toEmployee(EmployeeDTO employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setFirstName( employeeDto.getFirstName() );
        employee.setLastName( employeeDto.getLastName() );
        employee.setEmail( employeeDto.getEmail() );
        employee.setDepartmentCode( employeeDto.getDepartmentCode() );
        employee.setOrganizationCode( employeeDto.getOrganizationCode() );

        return employee;
    }
}
