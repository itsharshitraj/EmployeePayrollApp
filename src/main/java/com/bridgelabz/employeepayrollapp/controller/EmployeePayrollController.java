package  com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@RestController
@RequestMapping(value = "/employee",produces = "application/json")
public class EmployeePayrollController {
    private static final Logger log = LoggerFactory.getLogger(EmployeePayrollController.class); // ✅ Manually declare logger

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

    @GetMapping("/logTest")
    public String testLogging() {
        log.debug("This is a DEBUG log message");
        log.info("This is an INFO log message");
        log.warn("This is a WARN log message");
        log.error("This is an ERROR log message");
        return "Logging Test Completed!";
    }
}