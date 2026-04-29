package com.azienda.model;

public class Aereo extends Veicolo {
	private boolean diLinea;

	public Aereo(String modello, float velocita, boolean diLinea) {
		super(modello, velocita);
		this.diLinea = diLinea;
	}

	public boolean isDiLinea() {
		return diLinea;
	}

	public void setDiLinea(boolean diLinea) {
		this.diLinea = diLinea;
	}

	public String vola() {
		return "Sto volando!";
	}
}
