package com.faiz.learn;

import java.util.Iterator;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyAppApplication.class, args);

		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}

	}

}
