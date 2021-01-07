package com.faiz.springprofiles.configurations;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProdConfiguration {

	@PostConstruct
	public void postConstruct() {
		System.out.println("FROM PROD ENVIRONMENT.");
	}

}