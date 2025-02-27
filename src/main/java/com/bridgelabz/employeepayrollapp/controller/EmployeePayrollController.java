package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value = "/employee", produces = "application/json")
public class EmployeePayrollController {
    private static final Logger log = LoggerFactory.getLogger(EmployeePayrollController.class);

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Received request to create employee: Name = {}, Salary = {}, Department = {}",
                employeeDTO.getName(), employeeDTO.getSalary(), employeeDTO.getDepartment());
        String response = employeePayrollService.createEmployee(employeeDTO);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeePayrollService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeePayrollService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Received request to update employee: ID = {}, Data = {}", id, employeeDTO);
        String response = employeePayrollService.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        String response = employeePayrollService.deleteEmployee(id);
        return ResponseEntity.ok(response);
    }

}
