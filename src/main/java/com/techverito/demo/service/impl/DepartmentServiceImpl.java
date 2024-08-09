package com.techverito.demo.service.impl;

import com.techverito.demo.dto.DepartmentRequestBody;
import com.techverito.demo.dto.DepartmentResponseBody;
import com.techverito.demo.entity.Department;
import com.techverito.demo.exception.UserAlreadyExistsException;
import com.techverito.demo.repository.DepartmentRepository;
import com.techverito.demo.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentResponseBody createDepartment(DepartmentRequestBody departmentRequestBody) {
        Optional<Department> department = departmentRepository.findByName(departmentRequestBody.getName());
        if (!department.isPresent()) {
            Department department1 = modelMapper.map(departmentRequestBody, Department.class);
            Department savedDepartment = departmentRepository.save(department1);
            return modelMapper.map(savedDepartment, DepartmentResponseBody.class);
        }
        throw new UserAlreadyExistsException("Department", "name", departmentRequestBody.getName());
    }

}
