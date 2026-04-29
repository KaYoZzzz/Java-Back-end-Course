package com.azienda.esempioRestClient1.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;

import com.azienda.esempioRestClient1.dto.PersonaDto;

@Component
public class PersonaRestClient {
	@Autowired
	private RestClient restClient;

	public void testGetById(Integer id) {
		try {
			PersonaDto pDto = restClient.get().uri("/getById/{id}", id).retrieve().body(PersonaDto.class);
			System.out.println(pDto.toString());
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

	public void testGetAll() {
		try {
			List<PersonaDto> pDtoList = restClient.get().uri("/getAll").retrieve()
					.body(new ParameterizedTypeReference<>() {
					});
			pDtoList.forEach(System.out::println);
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

	public void testAdd(Integer id, String nome, String cognome) {
		try {
			PersonaDto pDto = restClient.post().uri("/add").contentType(MediaType.APPLICATION_JSON)
					.body(new PersonaDto(id, nome, cognome)).retrieve().body(PersonaDto.class);
			System.out.println(pDto.toString());
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

	public void testPut(Integer id, String nome, String cognome) {
		try {
			PersonaDto pDto = restClient.put().uri("/update/{id}", id).contentType(MediaType.APPLICATION_JSON)
					.body(new PersonaDto(null, nome, cognome)).retrieve().body(PersonaDto.class);
			System.out.println(pDto.toString());
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

	public void testPatch(Integer id, String nome, String cognome) {
		try {
			PersonaDto pDto = restClient.patch().uri("/patch/{id}", id).contentType(MediaType.APPLICATION_JSON)
					.body(new PersonaDto(null, nome, cognome)).retrieve().body(PersonaDto.class);
			System.out.println(pDto.toString());
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

	public void testDelete1(Integer id) {
		try {
			restClient.delete().uri("/delete1/{id}", id).retrieve().body(Void.class);
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

	public void testDelete2(Integer id) {
		try {
			restClient.delete().uri("/delete2/{id}", id).retrieve().body(Void.class);
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

	public void testDelete3(Integer id) {
		try {
			ResponseEntity<Void> re = restClient.delete().uri("/delete2/{id}", id).retrieve().toBodilessEntity();
			System.out.println(re.getStatusCode());
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

	public void testAdd2(Integer id, String nome, String cognome) {
		try {
			ResponseEntity<PersonaDto> re = restClient.post().uri("/add").contentType(MediaType.APPLICATION_JSON)
					.body(new PersonaDto(id, nome, cognome)).retrieve().toEntity(PersonaDto.class);
			System.out.println(re.getBody());
			System.out.println(re.getStatusCode());
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

	public void testGetAll2() {
		try {
			List<PersonaDto> pDtoList = restClient.get().uri("/getAll").header("pippo", "Pluto").retrieve()
					.body(new ParameterizedTypeReference<>() {
					});
			pDtoList.forEach(System.out::println);
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
