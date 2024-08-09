package com.techverito.demo.controller;


import com.techverito.demo.dto.DepartmentRequestBody;
import com.techverito.demo.dto.DepartmentResponseBody;
import com.techverito.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentRequestBody departmentRequestBody) {
        DepartmentResponseBody departmentResponseBody = departmentService.createDepartment(departmentRequestBody);
        return new ResponseEntity<>(departmentResponseBody, HttpStatus.CREATED);
    }

}
