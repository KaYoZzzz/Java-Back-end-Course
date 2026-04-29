package com.azienda.EsercizioRestClient1.bin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import com.azienda.EsercizioRestClient1.client.LocalitaRestClient;

@SpringBootApplication(scanBasePackages = { "com.azienda.EsercizioRestClient1.client" })
public class EsercizioRestClient1Application {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = SpringApplication.run(EsercizioRestClient1Application.class,
				args)) {
			LocalitaRestClient lClient = context.getBean("localitaRestClient", LocalitaRestClient.class);

			System.out.println("--- INIZIO TEST REST CLIENT ---");

			// 1. Test Inserimento (Add)
			System.out.println("\n>> 1. Test Aggiunta Località (Milano, 15.5):");
			lClient.testAdd("Milano", 15.5f);
			lClient.testGetAll();

			// 2. Test Recupero per ID (GetById)
			// Assumendo che l'ID generato sia 1 (dipende dal database/server)
			System.out.println("\n>> 2. Test GetById (ID: 1):");
			lClient.testGetById(1);
			lClient.testGetAll();

			// 3. Test Aggiornamento Completo (Put)
			System.out.println("\n>> 3. Test Aggiornamento Completo (ID 1 -> Milano Sud, 20.0):");
			lClient.testPut(1, "Milano Sud", 20.0f);
			lClient.testGetAll();

			// 4. Test Aggiornamento Parziale (Patch)
			// Nota: Nel tuo client il metodo testPatch usa .put(), assicurati che il server
			// accetti PUT su /patch/
			System.out.println("\n>> 4. Test Aggiornamento Parziale (ID 1 -> Milano Centro):");
			lClient.testPatch(1, "Milano Centro", 22.0f);
			lClient.testGetAll();

			// 5. Test Cancellazione sotto una temperatura (Delete)
			// Aggiungiamo prima una località fredda per testare la cancellazione
			System.out.println("\n>> 5. Test Cancellazione (Elimino sotto i 10 gradi):");
			lClient.testAdd("Stelvio", 2.0f); // Aggiunta per il test
			System.out.println("Stato prima della cancellazione:");
			lClient.testGetAll();

			lClient.testDeleteBelowTemp(10.0f);
			System.out.println("Stato dopo la cancellazione:");
			lClient.testGetAll();

			System.out.println("\n--- FINE TEST ---");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	// creo il bean di restclient, classe che si occupa di fare le query
	@Bean
	public RestClient restClient(@Value("${serverUrl}") String serverUrl) {
		return RestClient.builder().baseUrl(serverUrl).build();
	}
}
