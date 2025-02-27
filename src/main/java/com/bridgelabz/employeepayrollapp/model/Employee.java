package com.bridgelabz.employeepayrollapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "employee_payroll")
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double salary;
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate startDate;

    private String note;
    private String profilePic;
    private String department;
}
