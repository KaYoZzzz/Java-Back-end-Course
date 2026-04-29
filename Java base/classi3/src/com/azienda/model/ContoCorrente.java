package com.azienda.model;

public class ContoCorrente {
	private String numeroConto;
	private float saldo;
	private Banca banca;
	public ContoCorrente(String numeroConto, float saldo, Banca banca) {
		super();
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.banca = banca;
	}
	public String getNumeroConto() {
		return numeroConto;
	}
	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	
	public String descrizione () {
		return "Saldo:" + this.saldo + 
				"\n" +
				this.banca.descrizione();
	}
	
	public String getNomeBanca() {
		if(banca != null) {
			return this.banca.getNome();
		}
		else {
			return "Banca non impostata";
		}
	}
	
	public void setNomeBanca(String nome) {
		if(banca != null) {
			this.banca.setNome(nome);
		}
		else {
			System.err.println("Banca non impostata"); 
		}
	}
	
	public String getCittaBanca() {
		if(banca != null && banca.getIndirizzo() != null) {
			return this.banca.getCittaBanca();
		}
		else {
			return "Banca non impostata o senza indirizzo";
		}
	}
	
	public void setCittaBanca(String citta) {
		if(banca != null && banca.getIndirizzo() != null) {
			this.banca.setCittaBanca(citta);
		}
		else {
			System.err.println("Banca non impostata o senza indirizzo"); 
		}
	}
}
