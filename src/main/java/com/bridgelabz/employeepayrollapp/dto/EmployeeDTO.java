package com.bridgelabz.employeepayrollapp.dto;


import lombok.Data;

@Data
public class EmployeeDTO {
    private String name;
    public String getName() {
        return name;
    }
    private double salary;
    public double getSalary() {
        return salary;
    }
}