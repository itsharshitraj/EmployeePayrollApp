package com.bridgelabz.employeepayrollapp.repository;



import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   // Custom Query to fetch employees by department
   @Query(value = "SELECT e.* FROM employee_payroll e " +
           "JOIN employee_department d ON e.id = d.employee_id " +
           "WHERE d.department = :department", nativeQuery = true)
   List<Employee> findEmployeesByDepartment(String department);
}
