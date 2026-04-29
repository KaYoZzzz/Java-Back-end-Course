package com.azienda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.azienda.model.Banca;
import com.azienda.model.BancaImpl;
import com.azienda.model.ContoCorrente;
import com.azienda.model.ContoCorrenteImpl;
import com.azienda.model.Indirizzo;
import com.azienda.model.IndirizzoImpl;

@Configuration
@ComponentScan(basePackages = { "com.azienda.model" })
public class ComponentConfig {

	@Bean
	public Indirizzo indirizzo2() {
		return new IndirizzoImpl("Roma", "Via Appia", 1);
	}

	@Bean
	public Banca banca2() {
		return new BancaImpl("Intesa", indirizzo2());
	}

	@Bean
	public ContoCorrente conto2() {
		return new ContoCorrenteImpl("87654321", banca2());
	}

	@Bean
	public ContoCorrente conto3() {
		return new ContoCorrenteImpl("stringa", null);
	}
}
