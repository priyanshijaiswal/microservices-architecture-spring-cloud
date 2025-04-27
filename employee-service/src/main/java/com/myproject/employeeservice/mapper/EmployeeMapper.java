package com.myproject.employeeservice.mapper;

import com.myproject.employeeservice.dto.EmployeeDTO;
import com.myproject.employeeservice.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO toEmployeeDTO(Employee employee);
    Employee toEmployee (EmployeeDTO employeeDto);

}
//public class EmployeeMapper {
//    public static EmployeeDTO mapToEmployeeDto(Employee employee){
//        EmployeeDTO employeeDto = new EmployeeDTO(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//               // employee.getOrganizationCode()
//        );
//        return employeeDto;
//    }
//
//    public static Employee mapToEmployee(EmployeeDTO employeeDto){
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail(),
//                employeeDto.getDepartmentCode()
//               // employeeDto.getOrganizationCode()
//        );
//        return employee;
//    }
//}
