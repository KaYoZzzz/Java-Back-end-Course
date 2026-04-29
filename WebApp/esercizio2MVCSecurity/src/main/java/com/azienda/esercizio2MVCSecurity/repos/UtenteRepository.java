package com.azienda.esercizio2MVCSecurity.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esercizio2MVCSecurity.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	public Optional<Utente> findByUsername(String user);
}