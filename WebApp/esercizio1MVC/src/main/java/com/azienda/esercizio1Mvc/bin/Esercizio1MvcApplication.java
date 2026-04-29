package com.azienda.esercizio1Mvc.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.azienda.esercizio1Mvc.controller" })
public class Esercizio1MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio1MvcApplication.class, args);
	}

}
