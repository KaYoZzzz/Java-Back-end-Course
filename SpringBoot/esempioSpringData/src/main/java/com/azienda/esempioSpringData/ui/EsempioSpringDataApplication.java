package com.azienda.esempioSpringData.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azienda.esempioSpringData.service.applicationService;

@SpringBootApplication(scanBasePackages = "com.azienda.esempioSpringData.service")
@EnableJpaRepositories(basePackages = { "com.azienda.esempioSpringData.repository" })
@EntityScan(basePackages = { "com.azienda.esempioSpringData.model" })
public class EsempioSpringDataApplication {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = SpringApplication.run(EsempioSpringDataApplication.class, args)) {
			applicationService service = context.getBean("applicationService", applicationService.class);
			String nomeCitta = "Roma";
			service.createSede(nomeCitta);

			// service.insertSedeWithLavoratori();

			service.insertLavoratoriRuoli();

			// service.updateSede();

			// service.deleteSede();

			// service.updateSedeDue();

			// service.assumiLavoratore("Roma", 1000, 1000f);

			// service.assumiLavoratore("Catanzaro", 1000, 1000f);

			service.assegnaRuolo(2001, 2001f, "Sistemista");

			// in questa maniera si riesce a fare una injection di come Like deve essere
			service.searchRuoliLike("%e%").forEach(System.out::println);
			System.out.println("-- programma terminato --");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}