package com.azienda.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IndirizzoImpl implements Indirizzo {
	@Autowired
	@Value("Roma")
	private String comune;
	@Autowired
	@Value("Via Colombo")
	private String viaPiazza;
	@Autowired
	@Value("1")
	private Integer civico;

	public IndirizzoImpl() {

	}

	public IndirizzoImpl(String comune, String viaPiazza, Integer civico) {
		this.comune = comune;
		this.viaPiazza = viaPiazza;
		this.civico = civico;
	}

	@Override
	public String getComune() {
		return comune;
	}

	@Override
	public void setComune(String comune) {
		this.comune = comune;
	}

	@Override
	public String getViaPiazza() {
		return viaPiazza;
	}

	@Override
	public void setViaPiazza(String viaPiazza) {
		this.viaPiazza = viaPiazza;
	}

	@Override
	public Integer getCivico() {
		return civico;
	}

	@Override
	public void setCivico(Integer civico) {
		this.civico = civico;
	}

	@Override
	public String toString() {
		return comune + ", " + viaPiazza + ", " + civico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(civico, comune, viaPiazza);
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
		IndirizzoImpl other = (IndirizzoImpl) obj;
		return Objects.equals(civico, other.civico) && Objects.equals(comune, other.comune)
				&& Objects.equals(viaPiazza, other.viaPiazza);
	}

}