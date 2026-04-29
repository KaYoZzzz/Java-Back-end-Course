package com.azienda.esercizioJPA2.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azienda.esercizioJPA2.model.Banca;
import com.azienda.esercizioJPA2.model.Conto;
import com.azienda.esercizioJPA2.model.Persona;
import com.azienda.esercizioJPA2.service.AppService;

@SpringBootApplication(scanBasePackages = "com.azienda.esercizioJPA2.service")
@EnableJpaRepositories(basePackages = { "com.azienda.esercizioJPA2.repos" })
@EntityScan(basePackages = { "com.azienda.esercizioJPA2.model" })
public class EsercizioJpa2Application {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(EsercizioJpa2Application.class, args)) {
			AppService service = ctx.getBean(AppService.class);

			Persona p1 = new Persona();
			p1.setNome("Mario");
			p1.setCognome("Rossi");

			Conto c1_1 = new Conto();
			c1_1.setNumeroConto("IT0001");
			c1_1.setSaldo(1000f);
			Conto c1_2 = new Conto();
			c1_2.setNumeroConto("IT0002");
			c1_2.setSaldo(2500f);

			Banca banca = new Banca();
			banca.setNome("Intesa San Paolo");

			List<Conto> conti1 = new ArrayList<>(Arrays.asList(c1_1, c1_2));

			service.create(p1, conti1, banca);

			Persona p2 = new Persona();
			p2.setNome("Luigi");
			p2.setCognome("Verdi");

			Conto c2_1 = new Conto();
			c2_1.setNumeroConto("IT0003");
			c2_1.setSaldo(500f);
			Conto c2_2 = new Conto();
			c2_2.setNumeroConto("IT0004");
			c2_2.setSaldo(0f);

			List<Conto> conti2 = new ArrayList<>(Arrays.asList(c2_1, c2_2));

			service.create(p2, conti2, banca);

			// 3. Spostamento fondi
			service.spostaFondi("Mario", "Rossi", "Luigi", "Verdi", 200f);

		} catch (Exception e) {
			System.err.println("Si è verificato un errore durante l'esecuzione: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
