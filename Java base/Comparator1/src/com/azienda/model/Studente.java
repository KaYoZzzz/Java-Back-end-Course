package com.azienda.model;

public class Studente {
	private String nome, cognome;
	private Float mediaVoti;

	public Studente(String nome, String cognome, Float mediaVoti) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.mediaVoti = mediaVoti;
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

	public Float getMediaVoti() {
		return mediaVoti;
	}

	public void setMediaVoti(Float mediaVoti) {
		this.mediaVoti = mediaVoti;
	}

	@Override
	public String toString() {
		return this.getNome() + ", " + this.getCognome() + ", " + this.getMediaVoti();
	}

}
