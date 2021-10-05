package com.api.api_e_commerce_project_gradute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ApiECommerceProjectGraduteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiECommerceProjectGraduteApplication.class, args);
	}

}
