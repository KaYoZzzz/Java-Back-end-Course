package com.azienda.model;

public class Treno extends AbstractVeicolo {
	private String localitaPartenza, localitaArrivo;

	public Treno(String localitaPartenza, String localitaArrivo) {
		super();
		this.localitaPartenza = localitaPartenza;
		this.localitaArrivo = localitaArrivo;
	}

	public String getLocalitaPartenza() {
		return localitaPartenza;
	}

	public void setLocalitaPartenza(String localitaPartenza) {
		this.localitaPartenza = localitaPartenza;
	}

	public String getLocalitaArrivo() {
		return localitaArrivo;
	}

	public void setLocalitaArrivo(String localitaArrivo) {
		this.localitaArrivo = localitaArrivo;
	}

	@Override
	public String toString() {
		return "Partenza=" + localitaPartenza + ", Arrivo=" + localitaArrivo + ", " + super.toString();
	}

}
