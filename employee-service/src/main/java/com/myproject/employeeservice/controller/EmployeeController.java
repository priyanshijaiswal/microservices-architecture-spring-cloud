package com.myproject.employeeservice.controller;

import com.myproject.employeeservice.dto.APIResponseDto;
import com.myproject.employeeservice.dto.EmployeeDTO;
import com.myproject.employeeservice.entity.Employee;
import com.myproject.employeeservice.repository.EmployeeRepository;
import com.myproject.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;
    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        EmployeeDTO savedEmployee=employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("{Id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("Id") Long employeeId)
    {
        APIResponseDto apiResponseDto=employeeService.getEmployeebyId(employeeId);
        return  new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        //APIResponseDto apiResponseDto=employeeService.getEmployeebyId(employeeId);

        return  new ResponseEntity<>(employeeRepository.findAll(),HttpStatus.OK);
    }
}
