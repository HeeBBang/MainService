package com.Beaver.MainService;

import com.Beaver.MainService.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableConfigurationProperties(AppProperties.class)
public class MainServiceApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(MainServiceApplication.class, args);
	}
}
