package com.techverito.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestBody {

    private String name;
    private String email;
    private double salary;
    private String departmentName;
}
