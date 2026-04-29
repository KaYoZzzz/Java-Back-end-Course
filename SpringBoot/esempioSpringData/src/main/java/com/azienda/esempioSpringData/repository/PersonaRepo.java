package com.azienda.esempioSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.esempioSpringData.model.Persona;

public interface PersonaRepo extends JpaRepository<Persona, Integer> {

}
