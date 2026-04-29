package com.azienda.springIOC.esempio2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.azienda.springIOC.esempio2.model.SimpleBeanImp;

@Configuration
@ComponentScan(basePackages = { "com.azienda.springIOC.esempio2.model" })
public class ComponentConfiguration {

	@Bean
	public SimpleBeanImp sbi() {
		return new SimpleBeanImp("Pippo");
	}
}
