package com.azienda.EsempioRest1.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.azienda.EsempioRest1.control", "com.azienda.EsempioRest1.exceptions" })
public class EsempioRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(EsempioRest1Application.class, args);
	}

}
