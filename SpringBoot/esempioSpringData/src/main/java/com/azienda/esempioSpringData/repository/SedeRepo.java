package com.azienda.esempioSpringData.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esempioSpringData.model.Sede;

public interface SedeRepo extends JpaRepository<Sede, Integer> {
	/**
	 * TECNICA 1: Query Derivation (Query Method) * Spring Data JPA analizza il nome
	 * del metodo e genera automaticamente la query SQL. Segue una convenzione
	 * fissa: 'findBy' + nome degli attributi (Matricola, Stipendio) uniti da
	 * operatori logici (And, Or). * Vantaggi: Estremamente rapido e meno soggetto a
	 * errori di sintassi SQL. Svantaggi: Diventa difficile da leggere se i criteri
	 * di filtro sono troppi.
	 */
	public Optional<Sede> findByCitta(String citta);
}
