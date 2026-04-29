package com.azienda.model;

public class Televisore extends DispositivoMultimediale {
	private int numeroCanali, canaleSelezionato;

	public Televisore(String marca, String modello, float prezzo, int numeroCanali, int canaleSelezionato) {
		super(marca, modello, prezzo);
		this.numeroCanali = numeroCanali;
		this.canaleSelezionato = canaleSelezionato;
	}

	public int getNumeroCanali() {
		return numeroCanali;
	}

	public void setNumeroCanali(int numeroCanali) {
		this.numeroCanali = numeroCanali;
	}

	public int getCanaleSelezionato() {
		return canaleSelezionato;
	}

	public void cambiaCanale(int canaleSelezionato) {
		this.canaleSelezionato = canaleSelezionato;
	}

}
