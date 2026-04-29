package com.azienda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azienda.model.Banca;
import com.azienda.model.ContoCorrente;
import com.azienda.model.Indirizzo;

@Configuration
public class SpringConfiguration {
	@Bean
	public Indirizzo indirizzo() {
		return new Indirizzo("Lacchiarella", "Via Molise", 3);
	}

	@Bean
	public Banca banca1() {
		return new Banca("BCC", indirizzo());
	}

	@Bean
	public Banca banca2() {
		Banca b = new Banca();
		b.setNome("BCC2");
		b.setIndirizzo(indirizzo());
		return b;
	}

	@Bean
	public ContoCorrente conto1() {
		return new ContoCorrente("IT4380920000000043751", banca1());
	}

	@Bean
	public ContoCorrente conto2() {
		ContoCorrente c2 = new ContoCorrente();
		c2.setNumeroConto("IT4380920000000043752");
		c2.setBanca(banca2());
		return c2;
	}

}
