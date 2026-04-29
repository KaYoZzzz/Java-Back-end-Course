package com.azienda.EsercizioRest1.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.azienda.EsercizioRest1.control" })
public class EsercizioRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioRest1Application.class, args);
	}

}
