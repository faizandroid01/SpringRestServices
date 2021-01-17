package com.faiz.mmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.faiz.mmp")
public class MmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmpApplication.class, args);
	}
}
