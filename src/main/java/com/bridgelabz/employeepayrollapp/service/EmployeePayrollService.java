package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

// Enables logging
@Service
public class EmployeePayrollService {
    private static final Logger log = LoggerFactory.getLogger(EmployeePayrollService.class);
    private final List<Employee> employeeList = new ArrayList<>();

    public String createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        employeeList.add(employee);
        log.info("Employee Created: {}", employee);  // Log employee creation
        return "Employee Created: " + employee.toString();
    }

    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees...");
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return (id >= 0 && id < employeeList.size()) ? employeeList.get(id) : null;
    }

    public String updateEmployee(int id, EmployeeDTO employeeDTO) {
        if (id >= 0 && id < employeeList.size()) {
            Employee updatedEmployee = new Employee(employeeDTO);
            employeeList.set(id, updatedEmployee);
            log.info("Employee Updated: {}", updatedEmployee);
            return "Employee Updated: " + updatedEmployee.toString();
        }
        log.warn("Employee with ID {} not found!", id);
        return "Employee Not Found!";
    }

    public String deleteEmployee(int id) {
        if (id >= 0 && id < employeeList.size()) {
            employeeList.remove(id);
            log.info("Employee Deleted with ID: {}", id);
            return "Employee Deleted Successfully";
        }
        log.warn("Employee with ID {} not found!", id);
        return "Employee Not Found!";
    }
}