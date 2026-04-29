package com.azienda.model;

public class ContoCorrente {
	public String numeroConto;
	private Banca banca;

	public ContoCorrente() {
		super();
	}

	public ContoCorrente(String numeroConto, Banca banca) {
		super();
		this.numeroConto = numeroConto;
		this.banca = banca;
	}

	public String getNumeroConto() {
		return numeroConto;
	}

	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}

	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	@Override
	public String toString() {
		return "ContoCorrente [numeroConto=" + numeroConto + ", banca=" + banca + "]";
	}

}
