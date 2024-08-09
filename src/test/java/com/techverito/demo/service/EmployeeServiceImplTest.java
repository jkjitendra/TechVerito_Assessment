package com.techverito.demo.service;

import com.techverito.demo.dto.DepartmentRequestBody;
import com.techverito.demo.dto.DepartmentResponseBody;
import com.techverito.demo.dto.EmployeeRequestBody;
import com.techverito.demo.dto.EmployeeResponseBody;
import com.techverito.demo.entity.Department;
import com.techverito.demo.entity.Employee;
import com.techverito.demo.repository.DepartmentRepository;
import com.techverito.demo.repository.EmployeeRepository;
import com.techverito.demo.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private ModelMapper modelMapper;

    private EmployeeResponseBody employeeResponseBody;

    @BeforeEach
    public void setup() {
        employeeResponseBody = new EmployeeResponseBody();
        employeeResponseBody.setName("Jitendra");
        employeeResponseBody.setEmail("jitendra@gmail.com");
        employeeResponseBody.setSalary(100.00);
        DepartmentResponseBody departmentResponseBody = new DepartmentResponseBody();
        departmentResponseBody.setName("IT");
        employeeResponseBody.setDepartmentName("IT");

    }

    @Test
    public void test_createEmployee() {

        EmployeeRequestBody employee = new EmployeeRequestBody();
        employee.setName("Jitendra");
        employee.setEmail("jitendra@gmail.com");
        employee.setSalary(100.00);
        Department department = new Department();
        department.setName("IT");

        Employee employee1 = new Employee();
        employee1.setName("Jitendra");
        employee1.setEmail("jitendra@gmail.com");
        employee1.setSalary(100.00);
        Department department1 = new Department();
        department1.setName("IT");


        when(employeeRepository.findByEmail(anyString())).thenReturn(Optional.empty());
//        when(modelMapper.map(any(), Employee.class)).thenReturn(employee1);
        when(departmentRepository.findByName("IT")).thenReturn(Optional.of(department));
        when(employeeRepository.save(any())).thenReturn(employee1);

        EmployeeResponseBody actualEmployee = employeeService.createEmployee(employee);
        Assertions.assertEquals(employeeResponseBody.getSalary(), actualEmployee.getSalary());


    }


}
