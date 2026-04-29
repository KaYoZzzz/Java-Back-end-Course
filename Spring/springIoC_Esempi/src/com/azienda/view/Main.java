package com.azienda.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.azienda.config.SpringConfiguration;
import com.azienda.model.ContoCorrente;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringConfiguration.class)) {
			ContoCorrente c1 = context.getBean("conto1", ContoCorrente.class);
			ContoCorrente c2 = context.getBean("conto2", ContoCorrente.class);
			System.out.println(c1.toString());
			System.out.println(c2.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
