package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
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


    @NotEmpty(message = "Department cannot be empty")
    private List<String> department;  // Change from String to List<String>


}
