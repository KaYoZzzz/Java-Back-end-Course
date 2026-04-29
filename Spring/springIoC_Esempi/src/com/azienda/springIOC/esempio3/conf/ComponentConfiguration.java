package com.azienda.springIOC.esempio3.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.azienda.springIOC.esempio3.model.Persona;

@Configuration
@ComponentScan(basePackages = { "com.azienda.springIOC.esempio3.model" })
public class ComponentConfiguration {

	@Bean
	public Persona persona() {
		return new Persona("Paolo", "Bianchi", 3);
	}
}
