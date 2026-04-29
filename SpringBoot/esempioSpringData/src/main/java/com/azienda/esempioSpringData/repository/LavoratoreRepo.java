package com.azienda.esempioSpringData.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.azienda.esempioSpringData.model.Lavoratore;

public interface LavoratoreRepo extends JpaRepository<Lavoratore, Integer> {
	/**
	 * TECNICA 1: Query Derivation (Query Method) * Spring Data JPA analizza il nome
	 * del metodo e genera automaticamente la query SQL. Segue una convenzione
	 * fissa: 'findBy' + nome degli attributi (Matricola, Stipendio) uniti da
	 * operatori logici (And, Or). * Vantaggi: Estremamente rapido e meno soggetto a
	 * errori di sintassi SQL. Svantaggi: Diventa difficile da leggere se i criteri
	 * di filtro sono troppi.
	 */
	public Optional<Lavoratore> findByMatricolaAndStipendio(Integer i, Float f);

	/**
	 * TECNICA 2: @Query Annotation (JPQL - Java Persistence Query Language) * Si
	 * scrive manualmente la query utilizzando JPQL, che lavora sulle classi
	 * (Entity) e sui loro attributi invece che sulle tabelle del database. I
	 * parametri vengono legati tramite l'annotazione @Param o la posizione. *
	 * Vantaggi: Massima flessibilità per query complesse, join o calcoli non
	 * supportati dalla denominazione standard. Permette di slegare il nome del
	 * metodo Java dalla logica di interrogazione.
	 */
	@Query("select x from Lavoratore x where x.matricola =:mat and x.stipendio =:stip")
	public Optional<Lavoratore> searchByMatricolaAndStipendio(@Param("mat") Integer m, @Param("stip") Float s);
}
