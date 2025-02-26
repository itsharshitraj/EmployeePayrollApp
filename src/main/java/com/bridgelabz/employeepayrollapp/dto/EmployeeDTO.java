package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Name must start with a capital letter and have at least 3 characters")

    private String name;
    public String getName() {
        return name;
    }
    private double salary;
    public double getSalary() {
        return salary;
    }
}