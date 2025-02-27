package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class EmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartment(employeeDTO.getDepartment());


        employeeRepository.save(employee);
        log.info("Employee created successfully: {}", employee);
        return "Employee Created successfully with ID: " + employee.getId();
    }

    public List<Employee> getAllEmployee() {
        log.info("Fetching all employees from database...");
        List<Employee> employees = employeeRepository.findAll();
        log.info("Total employees found: {}", employees.size());
        return employees;
    }

    public Employee getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    public String updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartment(employeeDTO.getDepartment());

        employeeRepository.save(employee);
        log.info("Employee with ID {} updated successfully", id);
        return "Employee with ID " + id + " updated successfully";
    }

    public String deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        log.info("Employee with ID {} deleted successfully", id);
        return "Employee with ID " + id + " deleted successfully";
    }
}