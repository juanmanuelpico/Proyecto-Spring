package com.unla.grupo8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Grupo8Oo22023Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo8Oo22023Application.class, args);
	}

}
