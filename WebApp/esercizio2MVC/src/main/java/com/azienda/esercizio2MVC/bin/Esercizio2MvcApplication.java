package com.azienda.esercizio2MVC.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.azienda.esercizio2MVC")
@EnableJpaRepositories(basePackages = "com.azienda.esercizio2MVC.repos")
@EntityScan(basePackages = "com.azienda.esercizio2MVC.model")
public class Esercizio2MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio2MvcApplication.class, args);
	}

}
