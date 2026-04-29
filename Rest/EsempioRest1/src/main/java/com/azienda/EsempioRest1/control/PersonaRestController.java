package com.azienda.EsempioRest1.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.azienda.EsempioRest1.model.Persona;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

//come i controller in MVC, ma gli input/output vengono fatti in formato json in caso di output e in caso di input vengono tradotti da json a oggetti con @RequestBody
@RestController
@CrossOrigin(origins = { "*" })
// consumes non necessario se si lavora solo con json
@RequestMapping(path = "/api/person", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class PersonaRestController {
	private List<Persona> persone;

	public PersonaRestController() {
		persone = new ArrayList<>();
		persone.add(new Persona(1, "Mario", "Rossi"));
		persone.add(new Persona(2, "Paolo", "Ducoli"));
		persone.add(new Persona(3, "Tonino", "Pitonino"));
	}

	@GetMapping("/getAll")
	// fammi arrivare nei parametri di input gli header
	public List<Persona> getAll(@RequestHeader HttpHeaders headers) {
		String headerValue = headers.getFirst("pippo");
		System.out.println(headerValue);
		return persone;
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Persona> getById(@Positive(message = "Errore: ID negativo") @PathVariable("id") Integer id) {
		try {
			Persona p = findById(id);
			HttpStatus status = (p != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
			return new ResponseEntity<Persona>(p, status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// consumes non necessario se si lavora solo con json
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Persona createPersona(@Valid @RequestBody Persona persona) {
		persone.add(persona);
		return persona;
	}

	// update totale
	// input viene tradotto da json a oggetto con @RequestBody
	@PutMapping("/update/{id}")
	public ResponseEntity<Persona> updatePersona(@PathVariable("id") Integer id, @RequestBody Persona p) {
		try {
			Persona pOld = findById(id);
			if (pOld != null) {
				pOld.setNome(p.getNome());
				pOld.setCognome(p.getCognome());
				return new ResponseEntity<Persona>(pOld, HttpStatus.OK);
			} else {
				return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// update parziale
	@PatchMapping("/patch/{id}")
	public ResponseEntity<Persona> patchPersona(@PathVariable("id") Integer id, @RequestBody Persona p) {
		try {
			Persona pOld = findById(id);
			if (pOld != null) {
				if (p.getNome() != null && !p.getNome().trim().isEmpty()) {
					pOld.setNome(p.getNome());
				}
				if (p.getCognome() != null && !p.getCognome().trim().isEmpty()) {
					pOld.setCognome(p.getCognome());
				}
				return new ResponseEntity<Persona>(pOld, HttpStatus.OK);
			} else {
				return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete1/{id}")
	// se non va in eccezione, usa questo
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePersona1(@PathVariable("id") Integer id) {
		Persona p = findById(id);
		persone.remove(p);
	}

	@DeleteMapping("/delete2/{id}")
	public ResponseEntity<Void> deletePersona2(@PathVariable("id") Integer id) {
		try {
			Persona p = findById(id);
			if (p != null) {
				persone.remove(p);
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Persona findById(Integer id) {
		for (Persona p : persone) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

}
