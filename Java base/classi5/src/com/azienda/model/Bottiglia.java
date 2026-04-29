package com.azienda.model;

public class Bottiglia {
	private String contenuto, materiale;
	private float Maxcapacita, quantitaAttuale;

	public Bottiglia(String contenuto, String materiale, float maxcapacita, float quantitaAttuale) {
		super();
		this.contenuto = contenuto;
		this.materiale = materiale;
		Maxcapacita = maxcapacita;
		this.quantitaAttuale = quantitaAttuale;
	}

	public String getContenuto() {
		return contenuto;
	}
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	public String getMateriale() {
		return materiale;
	}
	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}
	public float getMaxcapacita() {
		return Maxcapacita;
	}
	public void setMaxcapacita(float maxcapacita) {
		Maxcapacita = maxcapacita;
	}
	public float getQuantitaAttuale() {
		return quantitaAttuale;
	}
	public void setQuantitaAttuale(float quantitaAttuale) {
		this.quantitaAttuale = quantitaAttuale;
	}

	public boolean isEmpty() {
		if(quantitaAttuale == 0f) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if(quantitaAttuale == Maxcapacita) {
			return true;
		} else {
			return false;
		}
	}

	public String stampaBottiglia(){
		return "Questa è una bottiglia di " + this.materiale + " da " 
				+ this.Maxcapacita + " litri e contiene " 
				+ this.quantitaAttuale + " litri di " + this.contenuto;
	}

	public boolean aggiungi(float add) {
		if(this.quantitaAttuale + add < this.Maxcapacita) {
			this.quantitaAttuale+=add;
			return true;
		} else {
			return false;
		}
	}
	public boolean preleva(float remove) {
		if(this.quantitaAttuale - remove >= 0) {
			this.quantitaAttuale-=remove;
			return true;
		} else {
			return false;
		}
	}
}
