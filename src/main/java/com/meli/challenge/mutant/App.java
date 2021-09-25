package com.meli.challenge.mutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.meli.challenge.mutant.application.property.SwaggerProperties;

@SpringBootApplication()
@EnableConfigurationProperties({
    SwaggerProperties.class
})
public class App {
	
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}
}
