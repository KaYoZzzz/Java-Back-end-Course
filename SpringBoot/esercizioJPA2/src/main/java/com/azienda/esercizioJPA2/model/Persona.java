package com.azienda.esercizioJPA2.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cognome;
	@ManyToMany(mappedBy = "persone")
	private List<Conto> conti = new ArrayList<>();

	public Persona() {
		super();
	}

	public Persona(String nome, String cognome, List<Conto> conti) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.conti = conti;
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

	public List<Conto> getConti() {
		return conti;
	}

	public void setConti(List<Conto> conti) {
		this.conti = conti;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", conti=" + conti + "]";
	}

}
