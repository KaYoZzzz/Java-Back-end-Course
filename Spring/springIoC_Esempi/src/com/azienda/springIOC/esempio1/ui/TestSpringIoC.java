package com.azienda.springIOC.esempio1.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.azienda.springIOC.esempio1.config.SpringConfiguration;
import com.azienda.springIOC.esempio1.model.Persona;

public class TestSpringIoC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
			// prima versione
			Persona p1 = context.getBean("persona1", Persona.class);
			System.out.println(p1.toString());
			// seconda versione
			Persona p2 = (Persona) context.getBean("persona2");
			System.out.println(p2.toString());

			// Macchina m1 = context.getBean("macchina1", Macchina.class);
			// System.out.println(m1.toString());
			// seconda versione
			// Macchina m2 = (Macchina) context.getBean("macchina2");
			// System.out.println(m2.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			((AnnotationConfigApplicationContext) context).close();
		}
	}

}
