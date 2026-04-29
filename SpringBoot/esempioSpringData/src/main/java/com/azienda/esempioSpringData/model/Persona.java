package com.azienda.esempioSpringData.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Persona {
	//chiave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome, cognome;
	// Lato NON proprietario della relazione 1:1.
	//mappedBy indica a jpa che la relazione è già mappata dal campo persona nella classe Lavoratore
	@OneToOne(mappedBy = "persona")
	private Lavoratore lavoratore;
	public Persona() {
		super();
	}
	public Persona(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Lavoratore getLavoratore() {
		return lavoratore;
	}
	public void setLavoratore(Lavoratore lavoratore) {
		this.lavoratore = lavoratore;
	}
	
	
	
}
