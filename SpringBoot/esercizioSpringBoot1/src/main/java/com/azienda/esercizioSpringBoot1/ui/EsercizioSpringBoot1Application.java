package com.azienda.esercizioSpringBoot1.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.azienda.esercizioSpringBoot1.model.Banca;
import com.azienda.esercizioSpringBoot1.model.BancaImpl;
import com.azienda.esercizioSpringBoot1.model.ContoCorrente;
import com.azienda.esercizioSpringBoot1.model.ContoCorrenteImpl;
import com.azienda.esercizioSpringBoot1.model.Indirizzo;
import com.azienda.esercizioSpringBoot1.model.IndirizzoImpl;

@SpringBootApplication
@ComponentScan(basePackages = "com.azienda.esercizioSpringBoot1.model")
public class EsercizioSpringBoot1Application {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = SpringApplication.run(EsercizioSpringBoot1Application.class,
				args)) {

			ContoCorrente conto1 = context.getBean("contoCorrenteImpl", ContoCorrente.class);
			ContoCorrente conto2 = context.getBean("conto2", ContoCorrente.class);
			ContoCorrente conto3 = context.getBean("conto3", ContoCorrente.class);

			Banca banca1 = conto1.getBanca();
			Banca banca2 = conto2.getBanca();
			Banca banca3 = conto3.getBanca();

			System.out.println("\nBanca1 \t" + banca1);
			System.out.println("Banca2 \t" + banca2);
			System.out.println("Banca3 \t" + banca3);

			Indirizzo indirizzo1 = banca1.getIndirizzo();
			Indirizzo indirizzo2 = banca2.getIndirizzo();
			Indirizzo indirizzo3 = banca3.getIndirizzo();

			System.out.println("\nIndirizzo1 \t" + indirizzo1);
			System.out.println("Indirizzo2 \t" + indirizzo2);
			System.out.println("Indirizzo3 \t" + indirizzo3);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Bean
	public Indirizzo indirizzo2() {
		return new IndirizzoImpl("Milano", "Via Toscana", 2);
	}

	@Bean
	public Banca banca2() {
		return new BancaImpl("Intesa", indirizzo2());
	}

	@Bean
	public Banca banca3() {
		Banca b = new BancaImpl();
		b.setNome("BCC");
		b.setIndirizzo(indirizzo2());
		return b;
	}

	@Bean
	public ContoCorrente conto2() {
		return new ContoCorrenteImpl("324234342", banca2());
	}

	@Bean
	public ContoCorrente conto3() {
		return new ContoCorrenteImpl("435345324", banca3());
	}
}
