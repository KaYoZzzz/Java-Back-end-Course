package com.azienda.esercizioJPA2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esercizioJPA2.model.Conto;

public interface ContoRepo extends JpaRepository<Conto, Integer> {

}
