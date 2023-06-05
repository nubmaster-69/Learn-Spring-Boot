package com.hisu.dev.fundamental;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Fundamental",
				version = "1.0.0",
				description = "This project is for learning SpringBoot"
		)
)
public class FundamentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundamentalApplication.class, args);
	}

}
