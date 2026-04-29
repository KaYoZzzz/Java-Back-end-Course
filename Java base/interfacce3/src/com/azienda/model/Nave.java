package com.azienda.model;

public class Nave extends AbstractVeicolo {
	private int numeroCabine;

	public Nave(int numeroCabine) {
		super();
		this.numeroCabine = numeroCabine;
	}

	public int getNumeroCabine() {
		return numeroCabine;
	}

	public void setNumeroCabine(int numeroCabine) {
		this.numeroCabine = numeroCabine;
	}

	@Override
	public String toString() {
		return "Numero cabine=" + numeroCabine + ", " + super.toString();
	}
}
