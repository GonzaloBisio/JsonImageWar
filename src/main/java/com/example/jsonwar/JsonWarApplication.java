package com.example.jsonwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JsonWarApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonWarApplication.class, args);
	}

}
