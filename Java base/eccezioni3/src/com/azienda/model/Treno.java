package com.azienda.model;

public class Treno extends Veicolo {
	private boolean regionale;

	public Treno(String modello, float velocita, boolean regionale) {
		super(modello, velocita);
		this.regionale = regionale;
	}

	public boolean isRegionale() {
		return regionale;
	}

	public void setRegionale(boolean regionale) {
		this.regionale = regionale;
	}

	public String percorreBinari() {
		return "Percorrendo i binari!";
	}

}
