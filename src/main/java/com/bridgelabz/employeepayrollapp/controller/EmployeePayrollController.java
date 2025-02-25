package  com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/employee",produces = "application/json")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @PostMapping("/create")
    public String createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.createEmployee(employeeDTO);
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Employee> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeePayrollService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeePayrollService.deleteEmployee(id);
    }
}