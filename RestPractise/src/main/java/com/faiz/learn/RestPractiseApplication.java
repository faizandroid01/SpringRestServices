package com.faiz.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestPractiseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RestPractiseApplication.class, args);

		for (String beanName : context.getBeanDefinitionNames()) {

			System.out.println(beanName);
		}

	}

}
