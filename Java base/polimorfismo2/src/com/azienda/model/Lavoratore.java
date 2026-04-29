package com.azienda.model;

public class Lavoratore extends Persona{
	private float stipendio;
	
	public Lavoratore(String nome, String cognome, float stipendio) {
		super(nome, cognome);
		this.stipendio = stipendio;
		// TODO Auto-generated constructor stub
	}

	public float getStipendio() {
		return stipendio;
	}

	public void setStipendio(float stipendio) {
		this.stipendio = stipendio;
	}

	
}
