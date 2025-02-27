package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Data
@Getter
@Setter
@ToString
public class EmployeeDTO {
    @NotBlank(message = "Name cannot be empty")
    private String name;

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

    @NotBlank(message = "Department cannot be empty")
    private String department;
}
