package com.azienda.esercizioSpringBoot1.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ContoCorrenteImpl implements ContoCorrente {
	@Autowired
	@Value("12345678")
	private String numero;
	@Autowired
	@Qualifier("bancaImpl")
	private Banca banca;

	@Autowired
	public ContoCorrenteImpl() {
		super();
	}

	public ContoCorrenteImpl(String numero, Banca banca) {
		this.numero = numero;
		this.banca = banca;
	}

	@Override
	public String getNumero() {
		return numero;
	}

	@Override
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public Banca getBanca() {
		return banca;
	}

	@Override
	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	@Override
	public String toString() {
		return numero + ", " + banca;
	}

}
