package com.madtech.assessorai;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Assessor App",
				version = "1.0.0",
				description = "This project Assessor App based AI",
				contact = @Contact(
						name = "Mehmet Ali Değirmenci",
						email = "m.alidegirmenci@hotmail.com"
				),
				license = @License(
						name = "licence",
						url = "madtech"
				)

		)
)
public class AssessorAiAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessorAiAppApplication.class, args);
	}

}
