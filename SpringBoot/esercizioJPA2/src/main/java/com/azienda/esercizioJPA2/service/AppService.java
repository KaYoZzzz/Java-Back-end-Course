package com.azienda.esercizioJPA2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azienda.esercizioJPA2.model.Banca;
import com.azienda.esercizioJPA2.model.Conto;
import com.azienda.esercizioJPA2.model.Persona;
import com.azienda.esercizioJPA2.repos.BancaRepo;
import com.azienda.esercizioJPA2.repos.ContoRepo;
import com.azienda.esercizioJPA2.repos.PersonaRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AppService {
	@Autowired
	private BancaRepo bancaRepo;
	@Autowired
	private ContoRepo contoRepo;
	@Autowired
	private PersonaRepo personaRepo;

	public void create(Persona persona, List<Conto> conti, Banca banca) {
		// cerca il nome della banca, se la banca esiste, non salvarla, altrimenti,
		// salvala
		Banca bManaged = bancaRepo.findByNome(banca.getNome()).orElseGet(() -> bancaRepo.save(banca));
		// altrimenti, salvala
		Persona pSaved = personaRepo.save(persona);
		// associa ogni conto alla persona e alla banca
		for (Conto conto : conti) {
			conto.setBanca(bManaged);
			conto.getPersone().add(pSaved);

			bManaged.getConti().add(conto);
			pSaved.getConti().add(conto);

			contoRepo.save(conto);
		}

	}

	public void spostaFondi(String nome1, String cognome1, String nome2, String cognome2, Float importo) {
		Persona p1 = personaRepo.findByNomeAndCognome(nome1, cognome1)
				.orElseThrow(() -> new RuntimeException("Mittente non trovato"));
		Persona p2 = personaRepo.findByNomeAndCognome(nome2, cognome2)
				.orElseThrow(() -> new RuntimeException("Destinatario non trovato"));

		for (Conto c : p1.getConti()) {
			// prendo il saldo, se non è null, lo prendo, altrimenti lo setto a 0
			float nuovoSaldo = (c.getSaldo() != null ? c.getSaldo() : 0f) - importo;
			c.setSaldo(nuovoSaldo);
		}

		for (Conto c : p2.getConti()) {
			// prendo il saldo, se non è null, lo prendo, altrimenti lo setto a 0
			float nuovoSaldo = (c.getSaldo() != null ? c.getSaldo() : 0f) + importo;
			c.setSaldo(nuovoSaldo);
		}

	}
}
