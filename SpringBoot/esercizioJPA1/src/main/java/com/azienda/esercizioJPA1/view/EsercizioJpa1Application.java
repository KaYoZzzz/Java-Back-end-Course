package com.azienda.esercizioJPA1.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azienda.esercizioJPA1.model.Profilo;
import com.azienda.esercizioJPA1.model.Utente;
import com.azienda.esercizioJPA1.service.AppService;

@SpringBootApplication(scanBasePackages = "com.azienda.esercizioJPA1")
@EnableJpaRepositories(basePackages = { "com.azienda.esercizioJPA1.repository" })
@EntityScan(basePackages = { "com.azienda.esercizioJPA1.model" })
public class EsercizioJpa1Application {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(EsercizioJpa1Application.class, args)) {
			AppService service = ctx.getBean(AppService.class);

			// Creazione Profili
			String adminNameString = "mario";
			String standardUserNameString = "luigi";
			Profilo pAdmin = service.createAdminProfile(adminNameString);
			Profilo pStandardUser = service.createStandardUserProfile(standardUserNameString);

			// Creazione Utenti (il service aggiungerà i suffissi nel DB)
			service.createUser("mario", "123", pAdmin); // Nel DB: mario_AMMINISTRATORE
			service.createUser("luigi", "456", pStandardUser); // Nel DB: luigi_STANDARD_USER

			// TEST 1: Login Mario (lo trova come admin al primo colpo)
			Utente login1 = service.checkUtenteExists("mario", "123");
			System.out.println("Login 1 riuscito: " + login1.getUsername());

			// TEST 2: Login Luigi (non lo trova come admin, scatta il fallback su user)
			Utente login2 = service.checkUtenteExists("luigi", "456");
			System.out.println("Login 2 riuscito (via fallback): " + login2.getUsername());

			// TEST 3: Verifica Admin specifica
			try {
				service.isUserAdmin("mario", "123");
				System.out.println("Mario confermato Admin.");

				service.isUserAdmin("luigi", "456"); // Questo lancerà eccezione
			} catch (RuntimeException e) {
				System.out.println("Verifica fallita per Luigi: " + e.getMessage());
			}

		} catch (Exception e) {
			System.err.println("Errore fatale: " + e.getMessage());
		}
	}
}