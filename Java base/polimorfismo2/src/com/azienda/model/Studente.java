package com.azienda.model;

public class Studente extends Persona{
	private float mediaVoti;
	
	public Studente(String nome, String cognome, float mediaVoti) {
		super(nome, cognome);
		this.mediaVoti = mediaVoti;
	}

	public float getMediaVoti() {
		return mediaVoti;
	}

	public void setMediaVoti(float mediaVoti) {
		this.mediaVoti = mediaVoti;
	}
	
	
}
