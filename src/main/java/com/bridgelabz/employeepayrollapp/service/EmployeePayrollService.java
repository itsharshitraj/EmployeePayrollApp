package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {
    private final List<Employee> employeeList = new ArrayList<>();

    public String createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        employeeList.add(employee);
        return "Employee Created: " + employee.toString();
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        return (id >= 0 && id < employeeList.size()) ? employeeList.get(id) : null;
    }

    public String updateEmployee(int id, EmployeeDTO employeeDTO) {
        if (id >= 0 && id < employeeList.size()) {
            Employee updatedEmployee = new Employee(employeeDTO);
            employeeList.set(id, updatedEmployee);
            return "Employee Updated: " + updatedEmployee.toString();
        }
        return "Employee Not Found!";
    }

    public String deleteEmployee(int id) {
        if (id >= 0 && id < employeeList.size()) {
            employeeList.remove(id);
            return "Employee Deleted Successfully";
        }
        return "Employee Not Found!";
    }
}