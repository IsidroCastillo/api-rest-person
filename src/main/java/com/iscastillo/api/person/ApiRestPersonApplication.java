package com.iscastillo.api.person;


import com.iscastillo.api.person.config.SegurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@Import(SegurityConfig.class)
public class ApiRestPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestPersonApplication.class, args);
	}

}
