package com.azienda.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.azienda.config.ComponentConfig;
import com.azienda.model.ContoCorrenteImpl;

public class Main {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ComponentConfig.class)) {

			ContoCorrenteImpl conto1 = context.getBean("contoCorrenteImpl", ContoCorrenteImpl.class);
			System.out.println(conto1.toString());
			ContoCorrenteImpl conto2 = context.getBean("conto2", ContoCorrenteImpl.class);
			System.out.println(conto2.toString());
			ContoCorrenteImpl conto3 = context.getBean("conto3", ContoCorrenteImpl.class);
			System.out.println(conto3.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
