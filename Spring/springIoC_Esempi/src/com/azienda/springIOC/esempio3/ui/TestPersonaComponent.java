package com.azienda.springIOC.esempio3.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.azienda.springIOC.esempio3.conf.ComponentConfiguration;
import com.azienda.springIOC.esempio3.model.Macchina;
import com.azienda.springIOC.esempio3.model.Persona;

public class TestPersonaComponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ComponentConfiguration.class)) {
			Persona persona = context.getBean("pers", Persona.class);
			System.out.println(persona);

			Macchina macchina = context.getBean("mac", Macchina.class);
			System.out.println(macchina);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
