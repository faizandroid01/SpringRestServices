package com.faiz.springprofiles.configurations;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfiguration {

	@PostConstruct
	public void postConstruct() {
		System.out.println("FROM DEV ENVIRONMENT.");
	}

}
