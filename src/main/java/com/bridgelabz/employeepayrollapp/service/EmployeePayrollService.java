package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import jakarta.transaction.Transactional;
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
        log.info("Creating Employee: {}", employeeDTO.getName());
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartment(new ArrayList<>(employeeDTO.getDepartment()));
        log.info("Saving Employee: Name = {}, Departments = {}", employee.getName(), employee.getDepartment());

        employeeRepository.save(employee);
        log.info("Employee created successfully: {}", employee);
        return "Employee Created successfully with ID: " + employee.getId();
    }

    public List<Employee> getAllEmployee() {
        log.info("Fetching all employees from database...");
        List<Employee> employees = employeeRepository.findAll();
        log.info("Total Employees Found: {}", employees.size());
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        log.info("Fetched Employee: Name = {}, Departments = {}", employee.getName(), employee.getDepartment());
        return employee;
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        log.info("Fetching Employees from Department: {}", department);
        return employeeRepository.findEmployeesByDepartment(department);
    }


    @Transactional
    public String updateEmployee(int id, EmployeeDTO employeeDTO) {
        log.info("Updating Employee with ID: {}", id);
        Employee employee = getEmployeeById(id);

        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartment(new ArrayList<>(employeeDTO.getDepartment()));

        employeeRepository.save(employee);
        log.info("Employee with ID {} updated successfully", id);
        return "Employee with ID " + id + " updated successfully";
    }
    @Transactional
    public String deleteEmployee(int id) {
        log.info("Deleting Employee with ID: {}", id);
        Employee employee = getEmployeeById(id);

        employeeRepository.delete(employee);
        log.info("Employee with ID {} deleted successfully", id);
        return "Employee with ID " + id + " deleted successfully";
    }
}