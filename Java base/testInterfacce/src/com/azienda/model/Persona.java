package com.azienda.model;

public class Persona {
	protected String nome, cognome;
	protected float altezza;
	private static int contatorePersona;

	public Persona(String nome, String cognome, float altezza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.altezza = altezza;
		contatorePersona++;
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

	public float getAltezza() {
		return altezza;
	}

	public void setAltezza(float altezza) {
		this.altezza = altezza;
	}

	public static int getContatore() {
		return contatorePersona;
	}

	public void cresce(float altezza) {
		this.altezza += altezza;
	}

	public String info() {
		return "Nome adulto:" + this.nome + "\nCognome adulto:" + this.cognome + "\nAltezza adulto:" + this.altezza;
	}
}
