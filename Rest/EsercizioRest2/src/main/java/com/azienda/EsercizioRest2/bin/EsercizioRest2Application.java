package com.azienda.EsercizioRest2.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.azienda.EsercizioRest2.control",
		"com.azienda.EsercizioRest2.service" })
@EnableJpaRepositories(basePackages = "com.azienda.EsercizioRest2.repos")
@EntityScan(basePackages = "com.azienda.EsercizioRest2.model")
public class EsercizioRest2Application {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioRest2Application.class, args);
	}

}
