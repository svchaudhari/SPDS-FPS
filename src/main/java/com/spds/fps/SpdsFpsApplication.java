package com.spds.fps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "SPDS FPS", description = "All API definitions for SPDS FPS", version = "1.0.0"))
public class SpdsFpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpdsFpsApplication.class, args);
	}

}
