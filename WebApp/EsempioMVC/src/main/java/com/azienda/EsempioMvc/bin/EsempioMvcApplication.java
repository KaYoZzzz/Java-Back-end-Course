package com.azienda.EsempioMvc.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.azienda.EsempioMvc.controller" })
public class EsempioMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsempioMvcApplication.class, args);
	}

}
