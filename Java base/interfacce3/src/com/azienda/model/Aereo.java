package com.azienda.model;

public class Aereo extends AbstractVeicolo {
	private boolean diLinea;

	public Aereo(boolean diLinea) {
		super();
		this.diLinea = diLinea;
	}

	public boolean isDiLinea() {
		return diLinea;
	}

	public void setDiLinea(boolean diLinea) {
		this.diLinea = diLinea;
	}

	@Override
	public String toString() {
		return "Di linea=" + (diLinea ? "Sì" : "No") + ", " + super.toString();
	}

}
