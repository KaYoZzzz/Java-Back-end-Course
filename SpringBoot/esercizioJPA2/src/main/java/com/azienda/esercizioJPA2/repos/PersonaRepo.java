package com.azienda.esercizioJPA2.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esercizioJPA2.model.Persona;

public interface PersonaRepo extends JpaRepository<Persona, Integer> {
	public Optional<Persona> findByNomeAndCognome(String nome, String cognome);
}
