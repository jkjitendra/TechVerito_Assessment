package com.techverito.demo.service;

import com.techverito.demo.dto.DepartmentRequestBody;
import com.techverito.demo.dto.DepartmentResponseBody;

public interface DepartmentService {

    DepartmentResponseBody createDepartment(DepartmentRequestBody departmentRequestBody);
}
