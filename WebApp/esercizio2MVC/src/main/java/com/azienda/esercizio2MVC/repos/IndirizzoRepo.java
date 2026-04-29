package com.azienda.esercizio2MVC.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esercizio2MVC.model.Indirizzo;

public interface IndirizzoRepo extends JpaRepository<Indirizzo, Integer> {
	public List<Indirizzo> findByCitta(String citta);

	public List<Indirizzo> findByCittaOrVia(String citta, String via);

	public Optional<Indirizzo> findByCittaAndViaAndCivico(String citta, String via, String civico);
}
