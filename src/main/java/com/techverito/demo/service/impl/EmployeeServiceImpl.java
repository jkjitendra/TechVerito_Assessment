package com.techverito.demo.service.impl;

import com.techverito.demo.dto.EmployeeRequestBody;
import com.techverito.demo.dto.EmployeeResponseBody;
import com.techverito.demo.dto.MailBody;
import com.techverito.demo.entity.Department;
import com.techverito.demo.entity.Employee;
import com.techverito.demo.exception.ResourceNotFoundException;
import com.techverito.demo.exception.UserAlreadyExistsException;
import com.techverito.demo.repository.DepartmentRepository;
import com.techverito.demo.repository.EmployeeRepository;
import com.techverito.demo.service.EmailService;
import com.techverito.demo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeResponseBody createEmployee(EmployeeRequestBody employeeRequestBody) {
        Optional<Employee> employee = employeeRepository.findByEmail(employeeRequestBody.getEmail());
        if (!employee.isPresent()) {
            Employee employee1 = modelMapper.map(employeeRequestBody, Employee.class);
            Optional<Department> department = departmentRepository.findByName(employeeRequestBody.getDepartmentName());
            if (department.isPresent()) {
                employee1.setDepartment(department.get());
                Employee savedEmployee = employeeRepository.save(employee1);
                EmployeeResponseBody responseBody = modelMapper.map(savedEmployee, EmployeeResponseBody.class);
                responseBody.setDepartmentName(department.get().getName());

//                notificationService.send(NotificationType.SMS, body);

                return responseBody;
            }
            throw new ResourceNotFoundException("Department", "name", employeeRequestBody.getDepartmentName());
        }
        throw new UserAlreadyExistsException("Employee", "email", employeeRequestBody.getEmail());
    }

    // get all employees sorted by salary grouped by department

    public Map<Department, List<Employee>> getAllEmployeeGroupByDepartmentSortBySalary() {
        List<Employee> employeeList = employeeRepository.findAll();

        Map<Department, List<Employee>> collect = employeeList.stream().sorted().collect(Collectors.groupingBy(Employee::getDepartment));
        return collect;
    }

    // printer  which will print all kinds of objects and any type of formats
    // Printer class -> print method T
    public interface ObjectPrinter<T> {
        void print(T t);
    }
}
