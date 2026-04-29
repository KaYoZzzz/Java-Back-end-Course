package com.azienda.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BancaImpl implements Banca {
	@Autowired
	@Value("Banca Popolare di Sondrio")
	private String nome;
	@Autowired
	@Qualifier("indirizzoImpl")
	private Indirizzo indirizzo;

	@Autowired
	public BancaImpl() {

	}

	public BancaImpl(String nome, Indirizzo indirizzo) {
		this.nome = nome;
		this.indirizzo = indirizzo;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	@Override
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return nome + ", " + indirizzo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(indirizzo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BancaImpl other = (BancaImpl) obj;
		return Objects.equals(indirizzo, other.indirizzo) && Objects.equals(nome, other.nome);
	}

}
