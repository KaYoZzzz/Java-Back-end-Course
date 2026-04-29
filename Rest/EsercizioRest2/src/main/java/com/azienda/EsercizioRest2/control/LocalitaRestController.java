package com.azienda.EsercizioRest2.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.azienda.EsercizioRest2.model.Localita;
import com.azienda.EsercizioRest2.service.LocalitaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping(path = "/api/localita2", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LocalitaRestController {
	@Autowired
	private LocalitaService service;

	public LocalitaRestController() {

	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Localita add(@Valid @RequestBody Localita localita) {
		service.save(localita);
		return localita;
	}

	@GetMapping("/getAll")
	public List<Localita> getAll() {
		return service.findAll();
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Localita> getById(@PathVariable("id") Integer id) {
		try {
			Localita l = service.findById(id);
			HttpStatus status = (l != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
			return new ResponseEntity<Localita>(l, status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Localita>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getByNome/{nome}")
	public ResponseEntity<Localita> getById(@PathVariable("nome") String nome) {
		try {
			Localita l = service.findByNome(nome);
			HttpStatus status = (l != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
			return new ResponseEntity<Localita>(l, status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Localita>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getTemperatureBelow/{MaxTemp}")
	public ResponseEntity<List<Localita>> getTemperatureBelow(@PathVariable("MaxTemp") Float maxTemp) {
		try {
			List<Localita> newlList = service.findTempBelow(maxTemp);
			HttpStatus status = (newlList.isEmpty()) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
			return new ResponseEntity<List<Localita>>(newlList, status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<List<Localita>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getTemperatureAbove/{MinTemp}")
	public ResponseEntity<List<Localita>> getTemperatureAbove(@PathVariable("MinTemp") Float minTemp) {
		try {
			List<Localita> newlList = service.findTempBelow(minTemp);
			HttpStatus status = (newlList.isEmpty()) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
			return new ResponseEntity<List<Localita>>(newlList, status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<List<Localita>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/put/{id}")
	public ResponseEntity<Localita> putLocalita(@PathVariable("id") Integer id, @RequestBody Localita localita) {
		try {
			Localita updatedLocalita = service.putLocalita(id, localita);
			if (updatedLocalita != null) {
				return new ResponseEntity<Localita>(updatedLocalita, HttpStatus.OK);

			} else {
				return new ResponseEntity<Localita>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Localita>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/patch/{id}")
	public ResponseEntity<Localita> patchLocalita(@PathVariable("id") Integer id, @RequestBody Localita localita) {
		try {
			Localita localitaInDB = service.patchLocalita(id, localita);
			if (localitaInDB != null) {
				return new ResponseEntity<Localita>(localitaInDB, HttpStatus.OK);
			} else {
				return new ResponseEntity<Localita>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Localita>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLocalita(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}

	@DeleteMapping("/deleteBelowTemp/{temperature}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBelowTemp(@PathVariable("temperature") Float temperature) {
		service.deleteBelowTemp(temperature);
	}

	@DeleteMapping("/deleteAboveTemp/{temperature}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAboveTemp(@PathVariable("temperature") Float temperature) {
		service.deleteAboveTemp(temperature);
	}

}
