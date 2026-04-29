package com.azienda.esempioRestClient1.bin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import com.azienda.esempioRestClient1.client.PersonaRestClient;

@SpringBootApplication(scanBasePackages = { "com.azienda.esempioRestClient1.client" })
public class EsempioRestClient1Application {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = SpringApplication.run(EsempioRestClient1Application.class,
				args)) {
			PersonaRestClient pClient = context.getBean("personaRestClient", PersonaRestClient.class);
			// pClient.testGetById(1);
			// pClient.testGetById(4);
			// pClient.testAdd(4, "Pippo", "Gialli");
			// pClient.testAdd(-4, "Pippo", "Gialli");
			// pClient.testAdd(5, null, "Gialli");
			// pClient.testAdd(6, "Pippo", "");
			// pClient.testPut(4, null, "Pippo");
			// pClient.testPut(5, null, "Pippo");
			// pClient.testPatch(4, "Pippo", null);
			// pClient.testDelete1(5);
			// pClient.testGetAll();
			// pClient.testDelete1(4);
			// pClient.testGetAll();
			// pClient.testDelete2(5);
			// pClient.testGetAll();
			// pClient.testDelete2(3);

			// pClient.testAdd2(3, "Gianluca", "Neri");
			// pClient.testGetAll();
			// pClient.testDelete3(3);
			pClient.testGetAll2();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Bean
	public RestClient restClient(@Value("${serverUrl}") String serverUrl) {
		return RestClient.builder().baseUrl(serverUrl).build();
	}
}
