package com.azienda.EsercizioRest1.control;

import java.util.ArrayList;
import java.util.List;

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

import com.azienda.EsercizioRest1.model.Localita;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping(path = "/api/localita", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LocalitaRestController {
	private List<Localita> listLocalita;

	public LocalitaRestController() {
		listLocalita = new ArrayList<>();
		listLocalita.add(new Localita(1, "Milano", 13.4f));
		listLocalita.add(new Localita(2, "Pavia", 11.6f));
		listLocalita.add(new Localita(3, "Torino", 12f));
		listLocalita.add(new Localita(4, "Genova", 15.2f));
		listLocalita.add(new Localita(5, "Bologna", 14.8f));
		listLocalita.add(new Localita(6, "Verona", 13.1f));
		listLocalita.add(new Localita(7, "Firenze", 16.5f));
		listLocalita.add(new Localita(8, "Venezia", 12.7f));
		listLocalita.add(new Localita(9, "Bergamo", 11.2f));
		listLocalita.add(new Localita(10, "Novara", 11.9f));
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Localita add(@Valid @RequestBody Localita localita) {
		listLocalita.add(localita);
		return localita;
	}

	@GetMapping("/getAll")
	public List<Localita> getAll() {
		return listLocalita;
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Localita> getById(@PathVariable("id") Integer id) {
		try {
			Localita l = findById(id);
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
			Localita l = findByNome(nome);
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
			List<Localita> newlList = findTempBelow(maxTemp);
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
			List<Localita> newlList = findTempAbove(minTemp);
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
			Localita localitaInDB = findById(id);
			if (localitaInDB != null) {
				localitaInDB.setNome(localita.getNome());
				localitaInDB.setTemperatura(localita.getTemperatura());
				return new ResponseEntity<Localita>(localitaInDB, HttpStatus.OK);
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
			Localita localitaInDB = findById(id);
			if (localitaInDB != null) {
				if (localita.getNome() != null && !localita.getNome().trim().isEmpty()) {
					localitaInDB.setNome(localita.getNome());
				}
				if (localita.getTemperatura() != null) {
					localitaInDB.setTemperatura(localita.getTemperatura());
				}
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
		Localita localita = findById(id);
		listLocalita.remove(localita);
	}

	@DeleteMapping("/deleteBelowTemp/{temperature}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBelowTemp(@PathVariable("temperature") Float temperature) {
		List<Localita> newListLocalita = findTempBelow(temperature);
		listLocalita.removeAll(newListLocalita);
	}

	@DeleteMapping("/deleteAboveTemp/{temperature}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAboveTemp(@PathVariable("temperature") Float temperature) {
		List<Localita> newListLocalita = findTempAbove(temperature);
		listLocalita.removeAll(newListLocalita);
	}

	private Localita findById(Integer id) {
		for (Localita localita : listLocalita) {
			if (localita.getId().equals(id)) {
				return localita;
			}
		}
		return null;
	}

	private Localita findByNome(String nome) {
		for (Localita localita : listLocalita) {
			if (localita.getNome().equals(nome)) {
				return localita;
			}
		}
		return null;
	}

	private List<Localita> findTempBelow(Float temp) {
		List<Localita> newListLocalita = new ArrayList<>();
		for (Localita localita : listLocalita) {
			if (localita.getTemperatura() < temp) {
				newListLocalita.add(localita);
			}
		}
		return newListLocalita;
	}

	private List<Localita> findTempAbove(Float temp) {
		List<Localita> newListLocalita = new ArrayList<>();
		for (Localita localita : listLocalita) {
			if (localita.getTemperatura() > temp) {
				newListLocalita.add(localita);
			}
		}
		return newListLocalita;
	}
}
