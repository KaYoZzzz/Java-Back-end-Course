package com.azienda.springIOC.esempio2.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.azienda.springIOC.esempio2.config.ComponentConfiguration;
import com.azienda.springIOC.esempio2.model.SimpleBeanImp;

public class TestComponent {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ComponentConfiguration.class)) {
			SimpleBeanImp sbi1 = context.getBean("simpleBeanImp", SimpleBeanImp.class);
			System.out.println(sbi1.toString());
			SimpleBeanImp sbi2 = context.getBean("sbi", SimpleBeanImp.class);
			System.out.println(sbi2.toString());

			String[] beanNames = context.getBeanDefinitionNames();

			for (String s : beanNames) {
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
