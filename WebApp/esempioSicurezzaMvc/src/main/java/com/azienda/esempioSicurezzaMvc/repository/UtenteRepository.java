package com.azienda.esempioSicurezzaMvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esempioSicurezzaMvc.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer>{
	public Optional<Utente> findByUsername(String user);

}
