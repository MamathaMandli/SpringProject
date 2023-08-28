package com.example.mamatha.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.mamatha.student.*"})
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
		MobileServiceImpl mobileService=new MobileServiceImpl();
		System.out.println(mobileService.getUsername());
	}
}
