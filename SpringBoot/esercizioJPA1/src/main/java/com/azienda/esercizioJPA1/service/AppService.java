package com.azienda.esercizioJPA1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azienda.esercizioJPA1.model.Profilo;
import com.azienda.esercizioJPA1.model.Utente;
import com.azienda.esercizioJPA1.repository.ProfiloRepo;
import com.azienda.esercizioJPA1.repository.UtenteRepo;
import com.azienda.esercizioJPA1.utils.Costanti;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AppService {
	@Autowired
	private ProfiloRepo profiloRepo;
	@Autowired
	private UtenteRepo utenteRepo;

	// Creazione Profili (usano le tue costanti)
	public Profilo createAdminProfile(String nome) {
		return profiloRepo.save(new Profilo(nome + Costanti.AMMINISTRATORE));
	}

	public Profilo createStandardUserProfile(String nome) {
		return profiloRepo.save(new Profilo(nome + Costanti.STANDARD_USER));
	}

	// Salvataggio Utente: lo username viene creato combinando nome + costante del
	// profilo
	// Salvataggio pulito
	public Utente createUser(String username, String pwd, Profilo profilo) {
		// Salviamo l'username così come arriva ("mario")
		return utenteRepo.save(new Utente(username, pwd, profilo));
	}

	/**
	 * Requisito 4: Login pulito e oggettivo Cerca l'utente esattamente per come è
	 * stato salvato
	 */
	public Utente checkUtenteExists(String username, String pwd) {
		return utenteRepo.findByUsernameAndPassword(username, pwd)
				.orElseThrow(() -> new RuntimeException("Credenziali errate: nessun utente trovato"));
	}

	/**
	 * Requisito 5: Verifica specifica Admin Cerca solo con il suffisso Admin
	 */
	// Verifica Admin corretta
	public void isUserAdmin(String username, String pwd) {
		Utente u = utenteRepo.findByUsernameAndPassword(username, pwd)
				.orElseThrow(() -> new RuntimeException("Utente non trovato"));

		// Controlliamo l'oggetto Profilo collegato, non la stringa username
		if (!u.getProfilo().getNome().contains(Costanti.AMMINISTRATORE)) {
			throw new RuntimeException("Accesso negato: L'utente non ha i privilegi di Amministratore");
		}
	}
}