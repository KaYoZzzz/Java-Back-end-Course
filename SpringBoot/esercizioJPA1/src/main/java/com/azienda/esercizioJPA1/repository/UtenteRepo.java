package com.azienda.esercizioJPA1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esercizioJPA1.model.Utente;

public interface UtenteRepo extends JpaRepository<Utente, Integer> {
	// Per il Login
	Optional<Utente> findByUsernameAndPassword(String username, String password);
}