package com.example.egudanna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EgudannaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgudannaApplication.class, args);
	}

}
