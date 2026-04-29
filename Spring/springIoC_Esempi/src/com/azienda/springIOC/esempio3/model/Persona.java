package com.azienda.springIOC.esempio3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pers")
public class Persona {
	private String nome, cognome;
	// secondo autowired che viene eseguito, va a modificare l'id dell'oggetto
	@Autowired
	@Value("22")
	private Integer id;

	public Persona() {
		super();
	}

	// autowired serve per dire a spring quale costruttore utilizzare di default, se
	// no usa quello vuoto
	@Autowired
	public Persona(@Value("Mario") String nome, @Value("Rossi") String cognome, @Value("1") Integer id) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.id = id;
	}

	public Persona(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	// terzo autowired eseguito, va a modificare il nome
	@Autowired
	public void setNome(@Value("Pippo") String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", id=" + id + "]";
	}

}
