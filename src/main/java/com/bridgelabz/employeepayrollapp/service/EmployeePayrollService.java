package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService {
    public String createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        return "Employee Created: " + employee.toString();
    }
}
