package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class EmployeePayrollApplication {
	private static final Logger log = LoggerFactory.getLogger(EmployeePayrollApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollApplication.class, args);
		log.info("EmployeePayrollApplication started");
	}

}
