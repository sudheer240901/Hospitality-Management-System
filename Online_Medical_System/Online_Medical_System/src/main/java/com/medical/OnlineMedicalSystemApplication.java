package com.medical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.medical.controller","com.medical.repository","com.medical.service","com.medical.model"})
public class OnlineMedicalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMedicalSystemApplication.class, args);
		System.out.println("HelloWorld");
	}

}
