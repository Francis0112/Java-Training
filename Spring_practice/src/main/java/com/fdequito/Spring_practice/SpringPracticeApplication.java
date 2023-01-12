package com.fdequito.Spring_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringPracticeApplication.class, args);
		Spring_component sp = applicationContext.getBean(Spring_component.class);
		System.out.println(sp.GetMessage());
	}
}
