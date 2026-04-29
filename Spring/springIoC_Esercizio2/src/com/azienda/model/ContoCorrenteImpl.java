package com.azienda.model;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(banca, numero);
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
		ContoCorrenteImpl other = (ContoCorrenteImpl) obj;
		return Objects.equals(banca, other.banca) && Objects.equals(numero, other.numero);
	}

}
