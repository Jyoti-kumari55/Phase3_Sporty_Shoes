package com.example.sporty.shoes;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigShoe implements WebMvcConfigurer{
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/404").setViewName("404");
		}

	}

