
package  com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public String welcomeMessage() {
        return "Welcome to Employee Payroll Service!";
    }

    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable int id) {
        return "Fetching Employee with ID: " + id;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody String employeeData) {
        return "Creating Employee: " + employeeData;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody String employeeData) {
        return "Updating Employee: " + employeeData;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "Deleting Employee with ID: " + id;
    }
}
