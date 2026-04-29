package com.azienda.EsercizioRest2.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azienda.EsercizioRest2.model.Localita;

@Repository
public interface LocalitaRepo extends JpaRepository<Localita, Integer> {
	// Trova per nome esatto
	Optional<Localita> findByNome(String nome);

	// Trova temperature minori di...
	List<Localita> findByTemperaturaLessThan(Float temperatura);

	// Trova temperature maggiori di...
	List<Localita> findByTemperaturaGreaterThan(Float temperatura);

	// Cancella temperature minori di...
	void deleteByTemperaturaLessThan(Float temperatura);

	// Cancella temperature maggiori di...
	void deleteByTemperaturaGreaterThan(Float temperatura);
}
