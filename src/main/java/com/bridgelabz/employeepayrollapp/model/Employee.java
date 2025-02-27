package com.bridgelabz.employeepayrollapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 10000, message = "Salary must be at least 10,000")
    private double salary;

    @NotBlank(message = "Gender cannot be empty")
    @Pattern(regexp = "Male|Female|Other", message = "Gender should be Male, Female, or Other")
    private String gender;

    @PastOrPresent(message = "Start date must be in the past or present")
    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile picture cannot be empty")
    private String profilePic;

    // One-to-Many Mapping for Departments
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private List<String> department;


}
