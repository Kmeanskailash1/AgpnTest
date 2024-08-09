package com.spring.mvc;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWithFrontEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithFrontEndApplication.class, args);
		System.out.println("#######"+LocalDateTime.now());
	}

	
}
