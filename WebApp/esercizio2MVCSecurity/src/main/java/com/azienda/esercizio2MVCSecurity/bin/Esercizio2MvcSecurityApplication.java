package com.azienda.esercizio2MVCSecurity.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azienda.esercizio2MVCSecurity.service.UtenteService;

@SpringBootApplication(scanBasePackages = { "com.azienda.esercizio2MVCSecurity.control",
		"com.azienda.esercizio2MVCSecurity.security", "com.azienda.esercizio2MVCSecurity.service" })
@EnableJpaRepositories(basePackages = "com.azienda.esercizio2MVCSecurity.repos")
@EntityScan(basePackages = "com.azienda.esercizio2MVCSecurity.model")
public class Esercizio2MvcSecurityApplication {

	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext context = SpringApplication.run(Esercizio2MvcSecurityApplication.class,
					args);
			UtenteService service = context.getBean("utenteService", UtenteService.class);
			service.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}