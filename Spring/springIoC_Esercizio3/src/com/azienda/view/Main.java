package com.azienda.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.azienda.config.ComponentConfig;
import com.azienda.model.ContoCorrente;

public class Main {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ComponentConfig.class)) {
			ContoCorrente conto1 = context.getBean("contoCorrenteImpl", ContoCorrente.class);
			ContoCorrente conto2 = context.getBean("conto2", ContoCorrente.class);
			System.out.println("Conto 1 (@Component): " + conto1);
			System.out.println("Conto 2 (@Bean): " + conto2);

			System.out.println("\n--- Verifica Requisiti ---");
			System.out.println("Numeri di conto differenti? " + (!conto1.getNumero().equals(conto2.getNumero())));
			System.out.println("Istanze banca diverse? " + (conto1.getBanca() != conto2.getBanca()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
