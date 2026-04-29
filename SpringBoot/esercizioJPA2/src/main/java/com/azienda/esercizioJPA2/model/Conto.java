package com.azienda.esercizioJPA2.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Conto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numeroConto;
	private Float saldo;
	@ManyToOne
	@JoinColumn(name = "banca_id")
	private Banca banca;
	@ManyToMany
	@JoinTable(name = "conto_persona", // Nome della tabella di giunzione
			joinColumns = @JoinColumn(name = "conto_id"), inverseJoinColumns = @JoinColumn(name = "persona_id"))
	private List<Persona> persone = new ArrayList<>();

	public Conto() {
		super();
	}

	public Conto(String numeroConto, Float saldo, Banca banca, List<Persona> persone) {
		super();
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.banca = banca;
		this.persone = persone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroConto() {
		return numeroConto;
	}

	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	public List<Persona> getPersone() {
		return persone;
	}

	public void setPersone(List<Persona> persone) {
		this.persone = persone;
	}

	@Override
	public String toString() {
		return "ContoCorrente [id=" + id + ", numeroConto=" + numeroConto + ", saldo=" + saldo + ", banca=" + banca
				+ ", persone=" + persone + "]";
	}

}
