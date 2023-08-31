package com.rrojas.SpringWebEmpleos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rrojas.SpringWebEmpleos"})
public class SpringWebEmpleosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebEmpleosApplication.class, args);
		System.out.println("========== SERVER UP ==========");
	}

}
