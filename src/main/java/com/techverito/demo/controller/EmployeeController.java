package com.techverito.demo.controller;

import com.techverito.demo.dto.EmployeeRequestBody;
import com.techverito.demo.dto.EmployeeResponseBody;
import com.techverito.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequestBody employeeRequestBody) {
        EmployeeResponseBody employeeResponseBody = employeeService.createEmployee(employeeRequestBody);

        return new ResponseEntity<>(employeeResponseBody, HttpStatus.CREATED);
    }
}
