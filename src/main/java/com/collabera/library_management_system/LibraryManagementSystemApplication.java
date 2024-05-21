package com.collabera.library_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {

		//This is how configurable to run in multiple environments
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

}
