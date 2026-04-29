package com.azienda.esercizio2MVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azienda.esercizio2MVC.model.Indirizzo;
import com.azienda.esercizio2MVC.repos.IndirizzoRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApplicationService {
	@Autowired
	private IndirizzoRepo indirizzoRepo;

	public void insertIndirizzo(String citta, String via, String civico) {
		// creo un indirizzo solo se non esiste già
		Indirizzo indirizzoInDb = indirizzoRepo.findByCittaAndViaAndCivico(citta, via, civico).orElse(null);
		if (indirizzoInDb == null) {
			Indirizzo indirizzo = new Indirizzo(citta, via, civico);
			indirizzoRepo.save(indirizzo);
		}
	}

	public List<Indirizzo> findAllIndirizzi() {
		return indirizzoRepo.findAll();
	}

	public List<Indirizzo> findByCitta(String citta) {
		return indirizzoRepo.findByCitta(citta);
	}

	public List<Indirizzo> findByCittaOrVia(String citta, String via) {
		return indirizzoRepo.findByCittaOrVia(citta, via);
	}
}
