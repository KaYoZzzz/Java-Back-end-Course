package com.azienda.model;

public class Automobile extends AbstractVeicolo {
	private int cilindrata;

	public Automobile(int cilindrata) {
		super();
		this.cilindrata = cilindrata;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "Cilindrata=" + cilindrata + ", " + super.toString();
	}

}
