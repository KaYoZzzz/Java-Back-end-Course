package com.azienda.springIOC.esempio1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azienda.springIOC.esempio1.model.Macchina;
import com.azienda.springIOC.esempio1.model.Persona;

@Configuration
public class SpringConfiguration {

	@Bean
	public Persona persona1() {
		Persona persona = new Persona();
		persona.setId(1);
		persona.setNome("Paolo");
		persona.setCognome("Bianchi");
		return persona;
	}

	@Bean
	public Persona persona2() {
		return new Persona(2, "Mario", "Rossi");
	}

	// anche se non creo l'oggetto del bean, i metodi vengono comunque eseguiti
	@Bean
	public Macchina macchina1() {
		Macchina macchina = new Macchina();
		macchina.setId(3);
		macchina.setMarca("Ferrari");
		macchina.setModello("F40");
		return macchina;
	}

	@Bean
	public Macchina macchina2() {
		return new Macchina(4, "Ferrari", "F1");
	}
}
