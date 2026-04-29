package com.azienda.esempioSpringData.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.azienda.esempioSpringData.model.Ruolo;

public interface RuoloRepo extends JpaRepository<Ruolo, Integer> {
	/**
	 * TECNICA 2: @Query Annotation (JPQL - Java Persistence Query Language) * Si
	 * scrive manualmente la query utilizzando JPQL, che lavora sulle classi
	 * (Entity) e sui loro attributi invece che sulle tabelle del database. I
	 * parametri vengono legati tramite l'annotazione @Param o la posizione. *
	 * Vantaggi: Massima flessibilità per query complesse, join o calcoli non
	 * supportati dalla denominazione standard. Permette di slegare il nome del
	 * metodo Java dalla logica di interrogazione.
	 */
	@Query("Select r from Ruolo r where r.nome=:parnome")
	public Optional<Ruolo> searchByName(@Param("parnome") String r);

	/**
	 * TECNICA 1: Query Derivation (Query Method) * Spring Data JPA analizza il nome
	 * del metodo e genera automaticamente la query SQL. Segue una convenzione
	 * fissa: 'findBy' + nome degli attributi (Matricola, Stipendio) uniti da
	 * operatori logici (And, Or). * Vantaggi: Estremamente rapido e meno soggetto a
	 * errori di sintassi SQL. Svantaggi: Diventa difficile da leggere se i criteri
	 * di filtro sono troppi.
	 * 
	 * accetta inoltre una Stringa per capire come fare il like, tramite una
	 * "injection"
	 */
	public List<Ruolo> findByNomeLike(String s);
}
