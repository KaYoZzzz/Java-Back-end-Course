package com.azienda.esercizioJPA2.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esercizioJPA2.model.Banca;

public interface BancaRepo extends JpaRepository<Banca, Integer> {

	public Optional<Banca> findByNome(String nome);
}
