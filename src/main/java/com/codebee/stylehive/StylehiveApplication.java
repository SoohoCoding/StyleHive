package com.codebee.stylehive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
public class StylehiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(StylehiveApplication.class, args);
	}

}




