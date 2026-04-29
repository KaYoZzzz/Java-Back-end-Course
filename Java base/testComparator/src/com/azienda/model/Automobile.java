package com.azienda.model;

public class Automobile implements Comparable<Automobile> {
	private String modello;
	private Float cilindrata;

	public Automobile(String modello, Float cilindrata) {
		super();
		this.modello = modello;
		this.cilindrata = cilindrata;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Float getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Float cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Override
	public int compareTo(Automobile o) {
		// TODO Auto-generated method stub
		return this.cilindrata.compareTo(o.getCilindrata()); // visto che abbiamo usato la classe Float, non abbiamo
																// dovuto fare tutte le if in quanto lo fa già compareTo
																// di Float
	}

	@Override
	public String toString() {
		return "Automobile [modello=" + modello + ", cilindrata=" + cilindrata + "]";
	}

}
