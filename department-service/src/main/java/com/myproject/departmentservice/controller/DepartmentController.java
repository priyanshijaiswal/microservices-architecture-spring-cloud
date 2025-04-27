package com.myproject.departmentservice.controller;

import com.myproject.departmentservice.dto.DepartmentDto;
import com.myproject.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    public DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@ModelAttribute DepartmentDto departmentDto)
    {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return  new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto=departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
