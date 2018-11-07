package com.att.ssot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-config.xml")
public class JmxSpringDemoApplication {

	public static void main(String[] args) {
	//	SpringJolokiaAgent a;
		SpringApplication.run(JmxSpringDemoApplication.class, args);
	}
}
