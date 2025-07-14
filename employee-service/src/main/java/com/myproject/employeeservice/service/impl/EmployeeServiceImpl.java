package com.myproject.employeeservice.service.impl;

import com.myproject.employeeservice.dto.APIResponseDto;
import com.myproject.employeeservice.dto.DepartmentDto;
import com.myproject.employeeservice.dto.EmployeeDTO;
import com.myproject.employeeservice.dto.OrganizationDto;
import com.myproject.employeeservice.entity.Employee;
import com.myproject.employeeservice.mapper.EmployeeMapper;
import com.myproject.employeeservice.repository.EmployeeRepository;
import com.myproject.employeeservice.service.APIClient;
import com.myproject.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private static  final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;
    private final WebClient webClient;
    //private APIClient apiClient;
    public EmployeeMapper employeeMapper;
   // public RestTemplate restTemplate;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee= employeeMapper.toEmployee(employeeDTO);

         Employee savedEmployee=employeeRepository.save(employee);
         EmployeeDTO savedEmployeeDTO=employeeMapper.toEmployeeDTO(savedEmployee);

        return savedEmployeeDTO;
    }

    @Override
   // @CircuitBreaker(name="${spring.application.name}", fallbackMethod="getDefaultDepartment")
    @Retry(name="${spring.application.name}", fallbackMethod="getDefaultDepartment")
    public APIResponseDto getEmployeebyId(Long Id) {
        LOGGER.info("Inside getEmployeebyId method");
        Employee employee =employeeRepository.findById(Id).get();
       /* *//*ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity
                ("http://localhost:8080/api/departments/" +employee.getDepartmentCode()
                , DepartmentDto.class);
        DepartmentDto departmentDto=responseEntity.getBody();*/
        DepartmentDto departmentDto=webClient.get()
                .uri("http://localhost:8030/api/departments/" +employee.getDepartmentCode())
                .retrieve().bodyToMono(DepartmentDto.class)
                .block();
        OrganizationDto organizationDto=webClient.get()
                .uri("http://localhost:8084/api/organizations/" +employee.getOrganizationCode())
                .retrieve().bodyToMono(OrganizationDto.class)
                .block();
       // DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDTO employeedto= employeeMapper.toEmployeeDTO(employee);

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeedto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long Id, Exception exception) {
        LOGGER.info("Inside getDefaultDepartment method");
        Employee employee =employeeRepository.findById(Id).get();
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentCode("R&D department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Reserach and Development Department");
        EmployeeDTO employeedto= employeeMapper.toEmployeeDTO(employee);

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeedto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }

}
