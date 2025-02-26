package com.bridgelabz.employeepayrollapp;


import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeePayrollServiceTest {

    private EmployeePayrollService employeePayrollService;

    @BeforeEach
    void setUp() {
        employeePayrollService = new EmployeePayrollService();
    }

    @Test
    void testGetEmployeeById_NotFound() {
        // Trying to fetch an employee that does not exist
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
            employeePayrollService.getEmployeeById(100);
        });

        // Validate Exception Message
        String expectedMessage = "Employee with ID 100 not found";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
