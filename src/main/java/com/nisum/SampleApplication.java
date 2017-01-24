package com.nisum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication	
/*
@ComponentScan(basePackages = {"com.nisum.config","com.nisum.controller",
								"com.nisum.domain","com.nisum.repository"
								,"com.nisum.service"})*/
@ComponentScan(basePackages = {"com.nisum"})
//@ActiveProfiles("prod")
public class SampleApplication {
	
	public static void main(String[] args) {
		//how to set active profile programatically
		//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		SpringApplication.run(SampleApplication.class, args);
	}
	
}
