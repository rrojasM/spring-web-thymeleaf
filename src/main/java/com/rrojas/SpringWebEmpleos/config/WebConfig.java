package com.rrojas.SpringWebEmpleos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${spring.servlet.multipart.location}")
	private String rutaImagenes;
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/logos/**").addResourceLocations("file:/empleos/img-vacantes/");
		// // Linux C:\Users\Ruf Rojas\Documents\thymeleaf-image
		registry.addResourceHandler("/logos/**").addResourceLocations("file:C:/Users/thymeleaf-image/"); // Windows
	}

}
