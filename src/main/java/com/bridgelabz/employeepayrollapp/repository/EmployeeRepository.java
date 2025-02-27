package com.bridgelabz.employeepayrollapp.repository;



import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.department WHERE e.id = :id")
    Optional<Employee> findByIdWithDepartments(@Param("id") int id);
}
