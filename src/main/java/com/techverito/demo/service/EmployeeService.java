package com.techverito.demo.service;

import com.techverito.demo.dto.EmployeeRequestBody;
import com.techverito.demo.dto.EmployeeResponseBody;

public interface EmployeeService {

    EmployeeResponseBody createEmployee(EmployeeRequestBody employeeRequestBody);
}
