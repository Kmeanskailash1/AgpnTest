package com.spring.mvc.config;

import java.time.LocalDateTime;
import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class ApplicationConfiguration {
	@PostConstruct
	public void init() {
		// Set the default timezone to IST
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	}

}
