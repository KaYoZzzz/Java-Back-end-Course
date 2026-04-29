package com.azienda.EsercizioRestClient1.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;

import com.azienda.EsercizioRestClient1.dto.LocalitaDto;

@Component
public class LocalitaRestClient {

	// setup del restClient di cui ne ho creato il bean nel main
	@Autowired
	private RestClient restClient;

	// 1 recupero di una località in base all’id
	public void testGetById(Integer id) {
		try {
			// utilizzo l'oggetto della classe RestClient per fare partire una richiesta get
			// in HTTP
			LocalitaDto lDto = restClient.get()
					// Definisce l'URI della risorsa, iniettando dinamicamente il parametro {id}
					.uri("/getById/{id}", id)
					// 3. Invia la richiesta e dichiara come gestire la risposta (retrieve)
					// 4. Estrae il corpo della risposta (body) deserializzandolo in LocalitaDto
					.retrieve().body(LocalitaDto.class);
			System.out.println(lDto.toString());
		} catch (HttpClientErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (HttpServerErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 2 recupero di tutte le località
	public void testGetAll() {
		try {
			List<LocalitaDto> lDtoList = restClient.get().uri("/getAll").retrieve()
					.body(new ParameterizedTypeReference<>() {
					});
			lDtoList.forEach(System.out::println);
		} catch (HttpClientErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (HttpServerErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 3 inserimento di una località
	public void testAdd(String nome, Float temperautra) {
		try {
			LocalitaDto lDto = restClient.post().uri("/add").contentType(MediaType.APPLICATION_JSON)
					.body(new LocalitaDto(nome, temperautra)).retrieve().body(LocalitaDto.class);
			System.out.println(lDto.toString());
		} catch (HttpClientErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (HttpServerErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 4 aggiornamento completo di una località
	public void testPut(Integer id, String nome, Float temperautra) {
		try {
			// 1. Inizializza una richiesta con metodo HTTP PUT (utilizzato per la
			// sostituzione completa)
			LocalitaDto lDto = restClient.put()
					// 2. Specifica l'URI dell'endpoint con il segnaposto per l'ID
					.uri("/put/{id}", id)
					// 3. Imposta l'header 'Content-Type' per comunicare al server che stiamo
					// inviando dati JSON (OPZIONALE)
					.contentType(MediaType.APPLICATION_JSON)
					// 4. Inserisce nel corpo della richiesta il nuovo oggetto LocalitaDto
					// serializzato in JSON
					.body(new LocalitaDto(nome, temperautra))
					// 5. Invia la richiesta, riceve la risposta e ne estrae il body convertito in
					// LocalitaDto
					.retrieve().body(LocalitaDto.class);
			System.out.println(lDto.toString());
		} catch (HttpClientErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (HttpServerErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 5 aggiornamento parziale di una località

	public void testPatch(Integer id, String nome, Float temperautra) {
		try {
			LocalitaDto lDto = restClient.patch().uri("/patch/{id}", id).contentType(MediaType.APPLICATION_JSON)
					.body(new LocalitaDto(nome, temperautra)).retrieve().body(LocalitaDto.class);
			System.out.println(lDto.toString());
		} catch (HttpClientErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (HttpServerErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 6 cancellazione di tutte le località con temperatura inferiore ad un
	// parametro
	public void testDeleteBelowTemp(Float maxTemp) {
		try {
			restClient.delete().uri("/deleteBelowTemp/{temperature}", maxTemp).retrieve().body(Void.class);
		} catch (HttpClientErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (HttpServerErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
