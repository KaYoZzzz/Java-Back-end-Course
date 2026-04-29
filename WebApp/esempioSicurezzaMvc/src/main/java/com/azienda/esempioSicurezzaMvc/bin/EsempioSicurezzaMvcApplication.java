package com.azienda.esempioSicurezzaMvc.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azienda.esempioSicurezzaMvc.service.UtenteService;

@SpringBootApplication(scanBasePackages = {"com.azienda.esempioSicurezzaMvc.controller", "com.azienda.esempioSicurezzaMvc.security", "com.azienda.esempioSicurezzaMvc.service"})
@EnableJpaRepositories(basePackages = "com.azienda.esempioSicurezzaMvc.repository")
@EntityScan (basePackages = "com.azienda.esempioSicurezzaMvc.model")
public class EsempioSicurezzaMvcApplication {

	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext context = SpringApplication.run(EsempioSicurezzaMvcApplication.class, args);
			UtenteService service = context.getBean("utenteService", UtenteService.class);
			
			service.init();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
