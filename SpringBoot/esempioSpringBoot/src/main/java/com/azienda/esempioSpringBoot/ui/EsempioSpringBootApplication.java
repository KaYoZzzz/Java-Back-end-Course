package com.azienda.esempioSpringBoot.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EsempioSpringBootApplication {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = SpringApplication.run(EsempioSpringBootApplication.class, args)) {
			String[] beanIds = context.getBeanDefinitionNames();
			for (String s : beanIds) {
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

	}

}
